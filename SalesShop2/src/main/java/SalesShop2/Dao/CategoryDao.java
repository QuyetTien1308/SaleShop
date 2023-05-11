package SalesShop2.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import SalesShop2.Entity.Categorys;
import SalesShop2.Entity.MapperCategorys;
@Repository
public class CategoryDao extends BaseDao{

	
	public List<Categorys> GetDataCategorys()
	{
		List<Categorys> list=new ArrayList<Categorys>();
		String sql="SELECT * FROM categorys";
		list=_jdbcTemplate.query(sql, new MapperCategorys());
		return list;
	}
}
