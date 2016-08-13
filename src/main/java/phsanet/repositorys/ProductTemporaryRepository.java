package phsanet.repositorys;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import phsanet.entitys.Temporary_Item;

@Repository
@Qualifier("proudcttemporaryrepository")
public interface ProductTemporaryRepository {
	
	@Select(SQL.findall_product)
	@Results({
		
		@Result(property="product_id" 					,	column="pro_id"),
		@Result(property="product_name" 				,	column="pro_name"),
		@Result(property="product_image" 				,	column="pro_image"),
		@Result(property="price"						,	column="pro_price"),
		@Result(property="description"					,	column="pro_description"),
		@Result(property="subcategory.subcategory_id"	,	column="sub_id"),
		@Result(property="subcategory.subcategory_name"	,	column="sub_category_name"),
		@Result(property="subcategory.description"		,	column="sub_description"),
		@Result(property="web_source.web_source_id"		,	column="web_id"),
		@Result(property="web_source.website"			,	column="web_website"),
		@Result(property="web_source.logo"				,	column="web_logo")
		
	})
	public ArrayList<Temporary_Item> findAll();
	
	@Select(SQL.search_product)
	@Results({
		@Result(property="proid" ,						column="proid"),
		@Result(property="productname" , 				column="productname"),
		@Result(property="price" ,						column="price"),
		@Result(property="describe",					column="describe"),
		@Result(property="productimg",					column="productimg"),
		@Result(property="link",						column="link"),
		@Result(property="subcategory.subcategoryname",	column="subcategoryname"),
		@Result(property="subcategory.describe",		column="describe"),
		@Result(property="web_source.website",					column="website"),
		@Result(property="web_source.logo",					column="logo")
		
	})
	public ArrayList<Temporary_Item> search(String search);
	
	@Insert(SQL.save_product)
	public boolean save(ArrayList<Temporary_Item> product);
	
	@Update(SQL.update_product)
	public boolean update(Temporary_Item product);
	
	@Delete(SQL.remove_product)
	public boolean remove(int id);
		
		interface SQL{
	
				String findall_product = " Select "
						+ "	pro.product_id as pro_id						,"
						+ "	pro.product_name as pro_name					,"
						+ "	pro.product_image as pro_image					,"
						+ "	pro.price as pro_price							,"
						+ "	pro.description as pro_description				,"
						+ "	sub.subcategory_id as sub_id					,"
						+ "	sub.subcategory_name as sub_category_name		,"
						+ "	sub.description as sub_description				,"
						+ "	web.web_source_id as web_id						,"
						+ "	web.website as web_website						,"
						+ "	web.logo as web_logo							 "
						+ " From temporary_item pro Inner Join subcategory sub 	 "
						+ "	On pro.subcategory_id = sub.subcategory_id    	 "
						+ "	Inner Join web_source web On 					 "
						+ "	web.web_source_id = pro.web_source_id			 "
						;
				String search_product="SELECT  pro.* , sub.* , web.*  FROM "
						+ " tbtemporary pro INNER JOIN tbsubcategory sub "
						+ "	ON pro.subcategoryid = sub.subcategoryid "
						+ "WHERE LOWER(pro.productname) LIKE '%'||LOWER(#{search})||'%' ";
				
				String save_product="INSERT INTO temporary_item  "
						
						+ "	(	subcategory_id					,"
						+ "		product_name					,"
						+ "		price							,"
						+ "		description						,"
						+ "		web_source_id					,"
						+ "		product_image					 "
						+ "				  	)   				 "
						+ "		Values(							 "
						+ "		#{subcategory.subcategory_id}	,"
						+ "		#{product_name}					,"
						+ "		#{price}						,"
						+ "		#{description}					,"
						+ "		#{web_source.web_source_id}		,"
						+ "		#{product_image}				 "			
						+ "										)";
				
				String remove_product="DELETE FROM tbtemporary "
						+ "WHERE proid = #{proid}";
				
				String update_product="UPDATE tbtemporary "
						+ "productname=#{productname},	"
						+ "price	  =#{price}, 		"
						+ "describe	  =#{describe},		"
						+ "productimg =#{productimg}, 	"
						+ "link		  =#{link}, 		"
						+ "subcategoryid =#{subcategory.subcategoryid} "
						+ "WHERE proid=#{proid} ";
				
			}
	
}
