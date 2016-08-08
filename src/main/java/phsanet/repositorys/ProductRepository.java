package phsanet.repositorys;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ch.qos.logback.core.filter.Filter;
import phsanet.entitys.Products;
import phsanet.repositorys.provider.ProductProvider;
import phsanet.util.Paging;
import phsanet.util.ProductFilter;

@Repository
@Qualifier("productrepository")
public interface ProductRepository {
	//SIM RATHAHAUSONG
	@SelectProvider(type=ProductProvider.class, method = "selectPersonLike")
	@Results({
		@Result(property="product_id" 					,	column="pro_id"),
		@Result(property="product_name" 				,	column="pro_name"),
		@Result(property="product_image" 				,	column="pro_image"),
		@Result(property="price"						,	column="pro_price"),
		@Result(property="description"					,	column="pro_description"),
		@Result(property="link"							,	column="pro_link"),
		@Result(property="subcategory.subcategory_id"	,	column="sub_id"),
		@Result(property="subcategory.subcategory_name"	,	column="sub_category_name"),
		@Result(property="subcategory.description"		,	column="sub_description"),
		@Result(property="web.web_source_id"			,	column="web_id"),
		@Result(property="web.website"					,	column="web_website"),
		@Result(property="web.logo"						,	column="web_logo")
	})
	public ArrayList<Products> findAll(@Param("filter") ProductFilter filter , @Param("paging") Paging paging);
	
	@Select(SQL.count)
	public long count(@Param("filter") ProductFilter filter);
	
	@Insert(SQL.insert_product)
	public boolean save(Products product);
	
	@Delete(SQL.remove_product)
	public boolean remove(int id);
	
	@Update(SQL.update_product)
	public boolean update(Products product);
	
	interface SQL{
		
		String count=" Select Count(*) "
				+ " From product pro Inner Join subcategory sub 	 "
				+ "	On pro.subcategory_id = sub.subcategory_id    	 "
				+ "	Inner Join web_source web On 					 "
				+ "	web.web_source_id = pro.web_source_id			 " ;
		
		String select_pagin = " Select "
				+ "	pro.product_id as pro_id						,"
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
				+ "	web.logo as web_logo							 "
				+ " From product pro Inner Join subcategory sub 	 "
				+ "	On pro.subcategory_id = sub.subcategory_id    	 "
				+ "	Inner Join web_source web On 					 "
				+ "	web.web_source_id = pro.web_source_id			 "
				+ "	Where pro_name Like '%'||#{filter.productname}||'%' " 
				+ "	ORDER BY "
				+ "	pro_id DESC	"
				+ "	LIMIT "
				+ "		#{paging.limit} "
				+ "	OFFSET "
				+ "		#{paging.offset}";
		
		String insert_product="INSERT INTO tbproduct "
				+ "(productname,	"
				+ "price, 			"
				+ "describe,		"
				+ "productimg, 		"
				+ "link, 			"
				+ "subcategoryid)   "
				+ "VALUES("
				+ "#{productname},				"
				+ "#{price},					"
				+ "#{describe},					"
				+ "#{productimg},				"
				+ "#{link},						"
				+ "#{subcategory.subcategoryid}	"
				+ ")							";
		
		String remove_product="DELETE FROM tbproduct "
				+ "WHERE proid = #{proid}";
		
		String update_product="UPDATE tbproduct "
				+ "productname=#{productname},	"
				+ "price	  =#{price}, 		"
				+ "describe	  =#{describe},		"
				+ "productimg =#{productimg}, 	"
				+ "link		  =#{link}, 		"
				+ "subcategoryid =#{subcategory.subcategoryid} "
				+ "WHERE proid=#{proid} ";
		
	}
	
}
