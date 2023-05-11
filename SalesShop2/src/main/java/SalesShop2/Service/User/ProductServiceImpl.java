package SalesShop2.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SalesShop2.Dao.ProductDao;
import SalesShop2.Dto.ProductDto;

@Service
public class ProductServiceImpl implements IProductService {

	
	@Autowired
	ProductDao productDao=new ProductDao();
	public ProductDto GetProductByID(long id) {
		List<ProductDto> listProduct=productDao.GetProductByID(id);
		return listProduct.get(0);
	}
	public List<ProductDto> GetProductByIDCategory(int id) {
		return productDao.GetAllProductsByID(id);

	}
	public List<ProductDto> SearchProduct(String nameProduct) {
		
		return productDao.SearchProduct(nameProduct);
	}

	
}
