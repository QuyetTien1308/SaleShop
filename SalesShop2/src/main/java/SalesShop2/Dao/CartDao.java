package SalesShop2.Dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import SalesShop2.Dto.CartDto;
import SalesShop2.Dto.ProductDto;
@Repository
public class CartDao extends BaseDao{
	@Autowired
	ProductDao productDao=new ProductDao();
	public HashMap<Long,CartDto> addCart(long id,HashMap<Long,CartDto> cart) {
		CartDto itemCart=new CartDto();
		ProductDto product=productDao.FindProductByID(id);
		if(product !=null && cart.containsKey(id))
		{
			itemCart=cart.get(id);
			
			itemCart.setQuanty(itemCart.getQuanty()+1);
			itemCart.setTotalPrice(itemCart.getQuanty()*itemCart.getProduct().getPrice());
		}
		else
		{
			itemCart.setProduct(product);
			itemCart.setQuanty(1);
			
			itemCart.setTotalPrice(product.getPrice());
		}
		cart.put(id, itemCart);
		return cart;
	}
	public HashMap<Long,CartDto> editCart(long id,int quanty,HashMap<Long,CartDto> cart) {
		if(cart==null)
		{
			return cart;
		}
		
		CartDto itemCart=new CartDto();
		if(cart.containsKey(id))
		{
			itemCart=cart.get(id);
			itemCart.setQuanty(quanty);	
			double totalPrice=quanty*itemCart.getProduct().getPrice();
			itemCart.setTotalPrice(totalPrice);
		}
		
		cart.put(id, itemCart);
		return cart;
	}
	
	
public HashMap<Long,CartDto> deleteCart(long id,HashMap<Long,CartDto> cart) {
		
	if(cart==null)
	{
		return cart;
	}
	if(cart.containsKey(id))
	{
		cart.remove(id);
	}
		
		return cart;
}
public int totalQuanty(HashMap<Long,CartDto> cart) {
	
	int totalQuanty=0;
	for(Map.Entry<Long,CartDto> itemCart : cart.entrySet())
	{
		 totalQuanty+=itemCart.getValue().getQuanty();
	}
		
		return totalQuanty;
}
public double totalPrice(HashMap<Long,CartDto> cart) {
	
	double totalPrice=0;
	for(Map.Entry<Long,CartDto> itemCart : cart.entrySet())
	{
		 totalPrice+=itemCart.getValue().getTotalPrice();
	}
		
		return totalPrice;
	
	
}
}
