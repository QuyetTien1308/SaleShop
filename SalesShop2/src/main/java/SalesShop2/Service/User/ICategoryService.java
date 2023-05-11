package SalesShop2.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import SalesShop2.Dto.ProductDto;
@Service
public interface ICategoryService {
	public List<ProductDto>GetALLProductsByID(int id);

	public List<ProductDto>GetDataProductsPaginate(int id,int start, int end);
}
