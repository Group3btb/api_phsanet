package phsanet.repositorys;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import phsanet.entitys.Products;
import phsanet.util.Paging;
import phsanet.util.ProductFilter;

@Repository
@Qualifier("productrepository")
public interface ProductRepository {
	//SIM RATHAHAUSONG
	@Select(SQL.select_pagin)
	@Results({
		@Result(property="proid" ,						column="proid"),
		@Result(property="productname" , 				column="productname"),
		@Result(property="price" ,						column="price"),
		@Result(property="describe",					column="describe"),
		@Result(property="productimg",					column="productimg"),
		@Result(property="link",						column="link"),
		@Result(property="subcategory.subcategoryname",	column="subcategoryname"),
		@Result(property="subcategory.describe",		column="describe"),
		@Result(property="web.website",					column="website"),
		@Result(property="web.logo",					column="logo")
		
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
		
		String count=""
				+ "	SELECT COUNT(*) FROM"
				+ " tbproduct pro INNER JOIN tbsubcategory sub "
				+ "	ON pro.subcategoryid = sub.subcategoryid "
				+ " INNER JOIN tbweb web "
				+ "ON pro.webid = web.webid "
				+ " WHERE pro.productname LIKE '%'|| #{filter.productname} ||'%' "
				+ " AND sub.subcategoryname LIKE '%'|| #{filter.subcategoryname} ||'%' "
				+ " OR pro.productname LIKE '%'|| #{filter.productname} ||'%' "
				+ " AND web.website LIKE '%'||#{filter.website}||'%' "
				+ " OR web.website LIKE '%'||#{filter.website}||'%' "
				;
		
		String select_pagin = "SELECT  pro.* , sub.* , web.*  FROM "
				+ " tbproduct pro INNER JOIN tbsubcategory sub "
				+ "	ON pro.subcategoryid = sub.subcategoryid "
				+ " INNER JOIN tbweb web "
				+ " ON pro.webid = web.webid "
				+ " WHERE LOWER(pro.productname) LIKE '%'|| LOWER(#{filter.productname}) ||'%' "
				+ " AND LOWER(sub.subcategoryname) LIKE '%'|| LOWER(#{filter.subcategoryname}) ||'%' "
				+ " OR LOWER(pro.productname LIKE) '%'|| LOWER(#{filter.productname}) ||'%' "
				+ " AND LOWER(web.website) LIKE '%'||LOWER(#{filter.website})||'%' "
				+ " OR LOWER(web.website) LIKE '%'||LOWER(#{filter.website})||'%' "
				+ "	ORDER BY "
				+ "	proid DESC	"
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
