package SalesShop2.Service.User;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import SalesShop2.Dto.CartDto;
import SalesShop2.Dto.ProductDto;

@Service
public interface ICartService {

	public HashMap<Long,CartDto> addCart(long id,HashMap<Long,CartDto> cart);
	public HashMap<Long,CartDto> eidtCart(long id,int quanty,HashMap<Long,CartDto> cart);
	
	public HashMap<Long,CartDto> deleteCart(long id,HashMap<Long,CartDto> cart);
	
	
	public int totalQuanty(HashMap<Long,CartDto> cart) ;
	public double totalPrice(HashMap<Long,CartDto> cart) ;


}

