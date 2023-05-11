package SalesShop2.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SalesShop2.Dto.ProductDto;
import SalesShop2.Entity.Categorys;
import SalesShop2.Entity.Menus;
import SalesShop2.Entity.Slides;
@Service
public interface IHome {
	@Autowired
	public List<Slides> GetDataSlide();
	public List<Categorys> GetDataCategorys();
	public List<Menus> GetDataMenus();
	public List<ProductDto> GetDataProducts();

}
