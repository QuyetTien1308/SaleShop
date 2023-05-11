package SalesShop2.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import SalesShop2.Dto.PaginatesDto;
import SalesShop2.Service.User.CategoryServiceImpl;
import SalesShop2.Service.User.PaginatesServiceImpl;
@Controller
public class CategoryController extends BaseController{
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@Autowired
	private PaginatesServiceImpl paginatesServiceImpl;
	
	private int totalProductsPage=9;
	@RequestMapping(value= "/san-pham/{id}")
	public ModelAndView Product(@PathVariable String id)
	{
		
		_mvShare.setViewName("user/products/category");
		
		int totalData= categoryServiceImpl.GetALLProductsByID(Integer.parseInt(id)).size();
		PaginatesDto paginateInfo=paginatesServiceImpl.GetInforPaginates(totalData, totalProductsPage, 1);
		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("productsPaginate", categoryServiceImpl.GetDataProductsPaginate(Integer.parseInt(id),paginateInfo.getStart(),totalProductsPage));

		return _mvShare;
	}
	@RequestMapping(value= "/san-pham/{id}/{currentPage}")
	public ModelAndView Product(@PathVariable String id, @PathVariable String currentPage)
	{
		
		_mvShare.setViewName("user/products/category");
		
		int totalData= categoryServiceImpl.GetALLProductsByID(Integer.parseInt(id)).size();
		PaginatesDto paginateInfo=paginatesServiceImpl.GetInforPaginates(totalData, totalProductsPage, Integer.parseInt(currentPage));
		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("productsPaginate", categoryServiceImpl.GetDataProductsPaginate(Integer.parseInt(id),paginateInfo.getStart(),totalProductsPage));

		return _mvShare;
	}
	
}
