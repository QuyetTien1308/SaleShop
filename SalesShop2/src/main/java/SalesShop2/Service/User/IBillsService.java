package SalesShop2.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import SalesShop2.Dto.CartDto;
import SalesShop2.Entity.Bills;

@Service
public interface IBillsService {

	public int addBills(Bills bill);
	public void addBillsDetail(HashMap<Long, CartDto> carts);
}
