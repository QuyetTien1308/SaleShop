package SalesShop2.Controller.User;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SalesShop2.Dto.ProductDto;
import SalesShop2.Entity.Bills;
import SalesShop2.Service.User.IProductService;
import SalesShop2.Service.User.PaginatesServiceImpl;

@Controller
public class ProductController extends BaseController {

	@Autowired
	private IProductService _productService;
	@RequestMapping(value= { "chi-tiet-san-pham/{id}"})
	public ModelAndView Index(@PathVariable long id)
	{
		_mvShare.setViewName("user/products/product");
		_mvShare.addObject("product",_productService.GetProductByID(id));
		int idCategory=_productService.GetProductByID(id).getId_category();
		_mvShare.addObject("productByIDCategory",_productService.GetProductByIDCategory(idCategory));
		return _mvShare;
	}
	@RequestMapping(value= "tim-kiem",  method=RequestMethod.GET)
	public ModelAndView SearchProduct(HttpServletRequest request,@RequestParam(value="nameProduct", required=false,defaultValue = "")String nameProduct)
	{
		_mvShare.setViewName("user/products/search-product");
		_mvShare.addObject("productSearch",_productService.SearchProduct(nameProduct));
		return _mvShare;
	}
	
}
