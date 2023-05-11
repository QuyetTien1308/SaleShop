package SalesShop2.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import SalesShop2.Dto.ProductDto;

@Service
public interface IProductService {
	public  ProductDto GetProductByID(long id);
	public  List<ProductDto> GetProductByIDCategory(int id);
	 public List<ProductDto> SearchProduct(String nameProduct);

	
	
}
