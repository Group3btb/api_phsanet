package phsanet.repositorys.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import phsanet.util.ProductFilter;

public class ProductProvider { 
	public String selectPersonLike(Map<String, Object> params) {
		  final ProductFilter filter = (ProductFilter) params.get("filter");
		  System.out.println("=>" + filter);
		  return new SQL() {{
			  
			  SELECT(	"	pro.product_id as pro_id						,"
						+ "	pro.product_name as pro_name					,"
						+ "	pro.product_image as pro_image					,"
						+ "	pro.price as pro_price							,"
						+ "	pro.description as pro_description				,"
						+ "	sub.subcategory_id as sub_id					,"
						+ "	sub.subcategory_name as sub_category_name		,"
						+ "	sub.description as sub_description				,"
						+ "	cat.category_name as cat_name					,"
						+ "	main.category_name as main_name					,"
						+ "	web.web_source_id as web_id						,"
						+ "	web.website as web_website						,"
						+ "	web.url as web_url								,"
						+ "	web.logo as web_logo							");
			  
			  FROM("product pro");
			  
			  INNER_JOIN("subcategory sub On pro.subcategory_id = sub.subcategory_id");
			  INNER_JOIN("web_source web On web.web_source_id = pro.web_source_id");
			  INNER_JOIN("category cat on cat.category_id = sub.category_id");
			  INNER_JOIN("main_category main on cat.maincategory_id = main.maincategory_id");
			  
			  
			  
			  
			  if(filter.getProductname()!= null &&  filter.getMaincategory()==null  && filter.getSubcategoryname()==null){
				  WHERE(" Lower(pro.product_name) Like '%'|| Lower(#{filter.productname}) ||'%' ");
			  }
			  if(filter.getProductname()!=null || filter.getSubcategoryname()!=null){
				  WHERE("(Lower(pro.product_name) Like '%'|| Lower(#{filter.productname}) ||'%') Or (Lower(sub.subcategory_name) = Lower(#{filter.subcategoryname}))");
				  
			  }
			  
			  if(filter.getProductname()!=null  &&  filter.getMaincategory()!=null){
				  WHERE("(Lower(pro.product_name) Like '%'|| Lower(#{filter.productname}) || '%') And (Lower(main.category_name)= Lower(#{filter.maincategory}))");
			  }
			  
			  if(filter.getMaincategory() !=null && filter.getProductname()==null){
				  WHERE("	Lower(main.category_name) = Lower(#{filter.maincategory})");
			  }
			  if(filter.getSubcategoryname()!=null  && filter.getProductname()==null){
				  WHERE("	Lower(sub.subcategory_name) = Lower(#{filter.subcategoryname})");
			  }
			  
			  if(filter.getWebsite()!=null){
				  WHERE("	Lower(web.website) = Lower(#{filter.website})");
			  }
			
			  ORDER_BY("pro_id desc LIMIT #{paging.limit} OFFSET #{paging.offset} ");
			  
			  
			  
			  
		  }}.toString();
		}
	
	public String selectcount(Map<String, Object> params) {
		  final ProductFilter filter = (ProductFilter) params.get("filter");
		 
		  return new SQL() {{
			  
			  SELECT("COUNT(*)");
			  
			  FROM("product pro");
			  
			  INNER_JOIN("subcategory sub On pro.subcategory_id = sub.subcategory_id");
			  INNER_JOIN("web_source web On web.web_source_id = pro.web_source_id");
			  INNER_JOIN("category cat on cat.category_id = sub.category_id");
			  INNER_JOIN("main_category main on cat.maincategory_id = main.maincategory_id");
			  
			  if(filter.getProductname()!= null &&  filter.getMaincategory()==null  && filter.getSubcategoryname()==null){
				  WHERE(" Lower(pro.product_name) Like '%'|| Lower(#{filter.productname}) ||'%' ");
			  }
			  if(filter.getProductname()!=null && filter.getSubcategoryname()!=null){
				  WHERE("(Lower(pro.product_name) Like '%'|| Lower(#{filter.productname}) ||'%') AND (Lower(sub.subcategory_name) = Lower(#{filter.subcategoryname}))");
			  }
			  
			  if(filter.getProductname()!=null  &&  filter.getMaincategory()!=null){
				  WHERE("(Lower(pro.product_name) Like '%'|| Lower(#{filter.productname}) || '%') And (Lower(main.category_name)= Lower(#{filter.maincategory}))");
			  }
			  if(filter.getMaincategory() !=null && filter.getProductname()==null){
				  WHERE("	Lower(main.category_name) = Lower(#{filter.maincategory})");
			  }
			  if(filter.getSubcategoryname()!=null  && filter.getProductname()==null){
				  WHERE("	Lower(sub.subcategory_name) = Lower(#{filter.subcategoryname})");
			  }
			  
			  if(filter.getWebsite()!=null){
				  WHERE("	Lower(web.website) = Lower(#{filter.website})");
			  }
			  
		  }}.toString();
		}
	
		
}
