package SalesShop2.Service.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SalesShop2.Dao.UserDao;
import SalesShop2.Entity.Users;
@Service
public class AcountServiceImpl implements IAcountService {
	@Autowired
	UserDao userDao=new UserDao();
	public int addAcount(Users user)
	{
		
		user.setPassword(BCrypt.hashpw( user.getPassword(),BCrypt.gensalt(12)));
		
		return userDao.addAcount(user);
	}
	public Users checkAcount(Users user)
	{
		String pass=user.getPassword();
		user=userDao.getUserByAcount(user);
		if(user !=null)
		{
			if(BCrypt.checkpw(pass, user.getPassword())) {
				return user;
			}
			else
			{
				return null;
			}
			
		}
		return null;
	}
}
