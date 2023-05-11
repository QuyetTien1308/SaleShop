package SalesShop2.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import SalesShop2.Dto.CartDto;
import SalesShop2.Entity.Bills;
import SalesShop2.Entity.Users;
import SalesShop2.Service.User.BillsServiceImpl;
import SalesShop2.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController {
	@Autowired
	private CartServiceImpl cartService=new CartServiceImpl();
	@Autowired
	private BillsServiceImpl billService=new BillsServiceImpl();
	@RequestMapping(value= "gio-hang")
	public ModelAndView Index()
	{
		_mvShare.addObject("slides",_homeSevice.GetDataSlide());
		_mvShare.addObject("categorys",_homeSevice.GetDataCategorys());
		_mvShare.addObject("products",_homeSevice.GetDataProducts());
		_mvShare.setViewName("user/cart/list_cart");
		return _mvShare;
	}
	
	
	@RequestMapping(value= "AddCart/{id}")
	public String AddCart(HttpServletRequest request,HttpSession session, @PathVariable long id)
	{
		HashMap<Long, CartDto> cart= (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart==null)
		{
			cart=new HashMap<Long, CartDto>();
		}
		cart =cartService.addCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.totalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.totalPrice(cart));
		//return "redirect:/chi-tiet-san-pham/"+id;
		return "redirect:"+request.getHeader("Referer");
	}
	@RequestMapping(value= "EditCart/{id}/{quanty}")
	public String EditCart(HttpServletRequest request,HttpSession session, @PathVariable long id,@PathVariable int quanty)
	{
		HashMap<Long, CartDto> cart= (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart==null)
		{
			cart=new HashMap<Long, CartDto>();
		}
		cart =cartService.eidtCart(id,quanty, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.totalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.totalPrice(cart));
		//return "redirect:/chi-tiet-san-pham/"+id;
		return "redirect:"+request.getHeader("Referer");
	}
	@RequestMapping(value= "DeleteCart/{id}")
	public String DeleteCart(HttpServletRequest request,HttpSession session, @PathVariable long id)
	{
		HashMap<Long, CartDto> cart= (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart==null)
		{
			cart=new HashMap<Long, CartDto>();
		}
		cart =cartService.deleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.totalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.totalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	@RequestMapping(value= "Checkout", method=RequestMethod.GET)
	public ModelAndView CheckOut(HttpServletRequest request,HttpSession session)
	{
		_mvShare.setViewName("user/bills/checkout");
		Bills bills=new Bills();
		Users loginInfo =(Users)session.getAttribute("LoginInfo");
		if(loginInfo !=null)
		{
			bills.setAddress(loginInfo.getAddress());
			bills.setDisplay_name(loginInfo.getDisplay_name());
			bills.setUser(loginInfo.getUser());
		}
		_mvShare.addObject("bills",bills);
		return _mvShare;
	}
	@RequestMapping(value= "Checkout", method=RequestMethod.POST)
	public String CheckOutBill(HttpServletRequest request,HttpSession session,@ModelAttribute("bills") Bills bill)
	{
		
		if(billService.addBills(bill)>0)
		{
			HashMap<Long, CartDto> carts=(HashMap<Long, CartDto>)session.getAttribute("Cart");
			billService.addBillsDetail(carts);
		}
		session.removeAttribute("Cart");
		return "redirect:gio-hang";		
	}
	
}
