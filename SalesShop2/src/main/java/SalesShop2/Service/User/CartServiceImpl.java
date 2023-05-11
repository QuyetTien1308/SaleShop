package SalesShop2.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SalesShop2.Dao.CartDao;
import SalesShop2.Dto.CartDto;

@Service
public class CartServiceImpl implements ICartService {
	@Autowired
	private CartDao cartDao=new CartDao();

	public HashMap<Long, CartDto> addCart(long id, HashMap<Long, CartDto> cart) {
		
		return cartDao.addCart(id, cart);
	}

	public HashMap<Long, CartDto> eidtCart(long id, int quanty, HashMap<Long, CartDto> cart) {
	
		return cartDao.editCart(id, quanty, cart);
	}

	public HashMap<Long, CartDto> deleteCart(long id, HashMap<Long, CartDto> cart) {
		
		return cartDao.deleteCart(id, cart);
	}

	public int totalQuanty(HashMap<Long, CartDto> cart) {
		
		return cartDao.totalQuanty(cart);
	}

	public double totalPrice(HashMap<Long, CartDto> cart) {
		
		return cartDao.totalPrice(cart);
	}
	
}
