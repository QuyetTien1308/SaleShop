package SalesShop2.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import SalesShop2.Dto.ProductDto;
import SalesShop2.Dto.ProductDtoMapper;
import SalesShop2.Entity.MapperMenus;
@Repository
public class ProductDao extends BaseDao {
	
	private final boolean YES=true;
	private final boolean NO=false;
	
	private StringBuffer sqlString()
	{
		StringBuffer  sql = new StringBuffer();
		 sql.append("SELECT * FROM products ");
		

		return sql;
	}
	public String sqlProducts(boolean newProduct, boolean highLight)
	{
		StringBuffer  sql = sqlString();
		sql.append("WHERE 1 = 1 " );
		if(highLight)
		{
			sql.append("AND highlight = true " );
		}	
		if(newProduct)
		{
			sql.append("AND new_product = true " );
		}
		
		sql.append("ORDER BY RAND() "  );
		if(highLight)
		{
			sql.append("LIMIT 9 "  );
		}	
		if(newProduct)
		{
			sql.append("LIMIT 12 "  );
		}
	
		return sql.toString();
	}
	public StringBuffer sqlProductsByID(int id )
	{
		StringBuffer  sql = sqlString();
		sql.append("WHERE 1 = 1 " );
		sql.append("AND id_category = "+id+" ");
		return sql;
	}
	public String sqlProductsPaginates(int id, int start, int totalPage )
	{
		StringBuffer  sql = sqlProductsByID(id);
		
		sql.append("LIMIT  "+start + ", "+totalPage+" " );
		return sql.toString();
	}
	
	public List<ProductDto> GetDataProducts()
	{
		String sql=sqlProducts(NO,YES);
		List<ProductDto>listProducts=_jdbcTemplate.query(sql, new ProductDtoMapper());
				return listProducts;
	}
	public List<ProductDto> GetAllProductsByID(int id)
	{
		String sql=sqlProductsByID(id).toString();
		List<ProductDto>listProducts=_jdbcTemplate.query(sql, new ProductDtoMapper());
				return listProducts;
	}
	public List<ProductDto> GetDataProductsPaginates(int id, int start, int totalPage)
	{
		StringBuffer sqlGetDataByID=sqlProductsByID(id);
		List<ProductDto>listProductsByID=_jdbcTemplate.query(sqlGetDataByID.toString(), new ProductDtoMapper());
		List<ProductDto>listProducts=new ArrayList<ProductDto>();
		if(listProductsByID.size()>0)
		{
			String sql=sqlProductsPaginates(id,start,totalPage);
			listProducts=_jdbcTemplate.query(sql, new ProductDtoMapper());
		}
		
		
				return listProducts;
	}
	
	
	
	public String sqlProductByID(long id )
	{
		StringBuffer  sql = sqlString();
		sql.append("WHERE 1 = 1 " );
		sql.append("AND id = "+id+" " );
		sql.append("LIMIT 1 " );

		return sql.toString();
	}
	public String sqlSearchProduct(String nameProduct )
	{
		StringBuffer  sql = sqlString();
		sql.append("WHERE 1 = 1 " );
		sql.append("AND name LIKE '"+nameProduct+"%' " );
		return sql.toString();
	}
	public List<ProductDto> GetProductByID(long id) {
		String sql=sqlProductByID(id);
		List<ProductDto>  listProduct=_jdbcTemplate.query(sql, new ProductDtoMapper());

		return listProduct;
	}

    public List<ProductDto> SearchProduct(String nameProduct) {
	String sql=sqlSearchProduct(nameProduct);
	List<ProductDto>  listProduct=_jdbcTemplate.query(sql, new ProductDtoMapper());

	return listProduct;
}
	
	public ProductDto FindProductByID(long id) {
		String sql=sqlProductByID(id);
		ProductDto product=_jdbcTemplate.queryForObject(sql, new ProductDtoMapper());

		return product;
	}
}
