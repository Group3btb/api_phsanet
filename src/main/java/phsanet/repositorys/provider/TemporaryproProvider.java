package phsanet.repositorys.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;


import phsanet.util.ProductFilter;

public class TemporaryproProvider {
	public String selectPersonLike(Map<String, Object> params) {
		  final ProductFilter filter = (ProductFilter) params.get("filter");
		 
		
		  return new SQL() {{
			  
			  SELECT(	"	pro.product_id as pro_id						,"
						+ "	pro.product_name as pro_name					,"
						+ "	pro.product_image as pro_image					,"
						+ "	pro.price as pro_price							,"
						+ "	pro.description as pro_description				,"
						+ "	pro.status as pro_status						,"
						+ "	sub.subcategory_id as sub_id					,"
						+ "	sub.subcategory_name as sub_category_name		,"
						+ "	sub.description as sub_description				,"
						+ "	cat.category_name as cat_name					,"
						+ "	main.category_name as main_name					,"
						+ "	web.web_source_id as web_id						,"
						+ "	web.website as web_website						,"
						+ "	web.url as web_url								,"
						+ "	web.logo as web_logo							");
			  
			  FROM("temporary_item pro");
			  
			  INNER_JOIN("subcategory sub On pro.subcategory_id = sub.subcategory_id");
			  INNER_JOIN("web_source web On web.web_source_id = pro.web_source_id");
			  INNER_JOIN("category cat on cat.category_id = sub.category_id");
			  INNER_JOIN("main_category main on cat.maincategory_id = main.maincategory_id");
			  
			  
			  if(filter.getProductname()!= null){
				  WHERE(" Lower(pro.product_name) Like '%'|| Lower(#{filter.productname}) ||'%' ");
			  }
			  if(filter.getProductname()!=null && filter.getSubcategoryname()!=null){
				  WHERE("pro_name Like '%'|| #{filter.productname} ||'%' And sub_cateogry_name '%'||#{filter.subcategoryname}");
				  
			  }
			  if(filter.getMaincategory() !=null){
				  WHERE("	main.category_name = #{filter.maincategory}");
			  }
			  if(filter.getSubcategoryname()!=null){
				  WHERE("	cat.category_name = #{filter.subcategoryname}");
			  }
			  
			  WHERE(" Lower(pro.status) <> 'yes'");
			
			  ORDER_BY("pro_id desc LIMIT #{paging.limit} OFFSET #{paging.offset} ");
			  
		  }}.toString();
		}
	
	public String selectcount(Map<String, Object> params) {
		  final ProductFilter filter = (ProductFilter) params.get("filter");
		 
		  return new SQL() {{
			  
			  SELECT("COUNT(*)");
			  
			  FROM("temporary_item pro");
			  
			  INNER_JOIN("subcategory sub On pro.subcategory_id = sub.subcategory_id");
			  INNER_JOIN("web_source web On web.web_source_id = pro.web_source_id");
			  INNER_JOIN("category cat on cat.category_id = sub.category_id");
			  INNER_JOIN("main_category main on cat.maincategory_id = main.maincategory_id");
			  
			  if(filter.getProductname()!= null){
				  WHERE(" Lower(pro.product_name) Like '%'|| Lower(#{filter.productname}) ||'%' ");
			  }
			  if(filter.getProductname()!=null && filter.getSubcategoryname()!=null){
				  WHERE("pro_name Like '%'|| #{filter.productname} ||'%' And sub_cateogry_name '%'||#{filter.subcategoryname}");
				  
			  }
			  if(filter.getMaincategory() !=null){
				  WHERE("	main.category_name = #{filter.maincategory}");
			  }
			  if(filter.getSubcategoryname()!=null){
				  WHERE("	cat.category_name = #{filter.subcategoryname}");
			  }
			  
			  WHERE(" Lower(pro.status) <> 'yes' ");
			  
		  }}.toString();
		}
}
