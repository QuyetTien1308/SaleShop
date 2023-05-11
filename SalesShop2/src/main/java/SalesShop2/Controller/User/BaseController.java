package SalesShop2.Controller.User;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import SalesShop2.Service.User.HomeServiceImpl;
@Controller
public class BaseController {
	@Autowired
	HomeServiceImpl _homeSevice;
	public ModelAndView _mvShare=new ModelAndView();
	@PostConstruct
	public ModelAndView Init()
	{
		_mvShare.addObject("menus",_homeSevice.GetDataMenus());
		return _mvShare;
	}
}
