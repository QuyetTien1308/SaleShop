package SalesShop2.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController{
	
	
	@RequestMapping(value= {"/", "/trang-chu"})
	public ModelAndView Index()
	{
		
		_mvShare.addObject("slides",_homeSevice.GetDataSlide());
		_mvShare.addObject("categorys",_homeSevice.GetDataCategorys());
		_mvShare.addObject("products",_homeSevice.GetDataProducts());
		_mvShare.setViewName("user/index");
		return _mvShare;
	}
	@RequestMapping(value = "/product")
	public ModelAndView Product()
	{
		ModelAndView mv=new ModelAndView("user/product");
	
		return mv;
	}
}
 