package SalesShop2.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import SalesShop2.Entity.Categorys;
import SalesShop2.Entity.MapperCategorys;
import SalesShop2.Entity.MapperMenus;
import SalesShop2.Entity.Menus;
@Repository
public class MenuDao extends BaseDao {
	public List<Menus> GetDataMenus()
	{
		List<Menus> list=new ArrayList<Menus>();
		String sql="SELECT * FROM menus";
		list=_jdbcTemplate.query(sql, new MapperMenus());
		return list;
	}
}
