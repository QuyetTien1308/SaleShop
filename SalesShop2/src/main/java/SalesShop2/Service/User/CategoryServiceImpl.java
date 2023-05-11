package SalesShop2.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SalesShop2.Dao.ProductDao;
import SalesShop2.Dto.ProductDto;
@Service
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	private ProductDao productDao;
	public List<ProductDto> GetALLProductsByID(int id) {
		List<ProductDto> products = productDao.GetAllProductsByID(id);
		return products;
	}
	
	public List<ProductDto> GetDataProductsPaginate(int id, int start, int totalPage) {
		List<ProductDto> products = productDao.GetDataProductsPaginates(id, start, totalPage);
		return products;
	}

	
	

}
