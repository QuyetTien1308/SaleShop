package SalesShop2.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SalesShop2.Dao.CategoryDao;
import SalesShop2.Dao.MenuDao;
import SalesShop2.Dao.ProductDao;
import SalesShop2.Dao.SlideDao;
import SalesShop2.Dto.ProductDto;
import SalesShop2.Entity.Categorys;
import SalesShop2.Entity.Menus;
import SalesShop2.Entity.Slides;
@Service
public class HomeServiceImpl implements IHome {
	@Autowired
	private SlideDao slideDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private MenuDao menuDao;
	@Autowired
	private ProductDao productDao;
	public List<Slides> GetDataSlide() {
		
		return slideDao.GetDataSlide();
	}
	public List<Categorys> GetDataCategorys() {
		
		return categoryDao.GetDataCategorys();
	}
public List<Menus> GetDataMenus() {
		
		return menuDao.GetDataMenus();
	}

public List<ProductDto> GetDataProducts() {
	List<ProductDto>listProducts=productDao.GetDataProducts();
	return listProducts;
}


}
