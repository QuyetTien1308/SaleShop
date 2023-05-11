package SalesShop2.Service.User;

import org.springframework.stereotype.Service;

import SalesShop2.Entity.Users;

@Service
public interface IAcountService {
	public int addAcount(Users user);
	public Users checkAcount(Users user);
}
