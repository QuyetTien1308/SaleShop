package SalesShop2.Controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import SalesShop2.Entity.Users;
import SalesShop2.Service.User.AcountServiceImpl;

@Controller
public class UserController extends BaseController {

	@Autowired
	AcountServiceImpl acountSevice=new AcountServiceImpl();
	@RequestMapping(value="/dang-ky",method=RequestMethod.GET)
	public ModelAndView Register()
	{
		_mvShare.setViewName("user/acount/register");
		
		_mvShare.addObject("user",new Users());
		
		return _mvShare;
	}
	@RequestMapping(value="/dang-ky",method=RequestMethod.POST)
	public ModelAndView CreateAcount(@ModelAttribute("user") Users user)
	{
		int count=acountSevice.addAcount(user);
		if(count>0)
		{
			_mvShare.addObject("status","Đăng ký tài khoản thành công");
			
		}
		else
		{
			_mvShare.addObject("status","Đăng ký tài khoản thất bại");
			
		}
		//_mvShare.addObject("status",true);
		_mvShare.setViewName("user/acount/register");
		return _mvShare;
	}
	@RequestMapping(value="/dang-nhap",method=RequestMethod.POST)
	public ModelAndView LoginAcount(HttpSession session,@ModelAttribute("user") Users user)
	{
		 user=acountSevice.checkAcount(user);
		if(user!=null)
		{
			
			_mvShare.setViewName("redirect:/trang-chu");
			session.setAttribute("LoginInfo", user);
		}
		else
		{
			_mvShare.addObject("statusLogin","Đăng nhập tài khoản thất bại");
			
		}
		
		
		return _mvShare;
	}
	@RequestMapping(value="/dang-xuat",method=RequestMethod.GET)
	public String Logout(HttpSession session,HttpServletRequest request)
	{
		session.removeAttribute("LoginInfo");
		
		
		return "redirect:"+request.getHeader("Referer");
	}
}
