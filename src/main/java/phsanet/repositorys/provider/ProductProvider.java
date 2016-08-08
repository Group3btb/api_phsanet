package phsanet.repositorys.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;


import phsanet.util.ProductFilter;

public class ProductProvider {
	public String selectPersonLike(Map<String, Object> params) {
		  final ProductFilter filter = (ProductFilter) params.get("filter");
		 
		
		  return new SQL() {{
			  
			  SELECT(	"	pro.product_id as pro_id						,"
						+ "	pro.product_name as pro_name					,"
						+ "	pro.product_image as pro_image					,"
						+ "	pro.price as pro_price							,"
						+ "	pro.description as pro_description				,"
						+ "	pro.link as pro_link							,"
						+ "	sub.subcategory_id as sub_id					,"
						+ "	sub.subcategory_name as sub_category_name		,"
						+ "	sub.description as sub_description				,"
						+ "	web.web_source_id as web_id						,"
						+ "	web.website as web_website						,"
						+ "	web.logo as web_logo							 ");
			  
			  FROM("product pro");
			  
			  INNER_JOIN("subcategory sub On pro.subcategory_id = sub.subcategory_id");
			  INNER_JOIN("web_source web On web.web_source_id = pro.web_source_id");
			  
			  if(filter.getProductname()!=null){
				  WHERE("pro_name Like '%'|| #{filter.productname} ||'%' ");
			  }
			  if(filter.getProductname()!=null && filter.getSubcategoryname()!=null){
				  WHERE("pro_name Like '%'|| #{filter.productname} ||'%' And sub_cateogry_name '%'||#{filter.subcategoryname}");
			  }
			  ORDER_BY("pro_id");
			  
			  
		  }}.toString();
		}
}
