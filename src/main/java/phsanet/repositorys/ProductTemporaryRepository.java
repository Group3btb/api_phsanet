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
		@Result(property="web.website",					column="website"),
		@Result(property="web.logo",					column="logo")
		
	})
	public ArrayList<Temporary_Item> search(String search);
	
	@Insert(SQL.save_product)
	public boolean save(Temporary_Item product);
	
	@Update(SQL.update_product)
	public boolean update(Temporary_Item product);
	
	@Delete(SQL.remove_product)
	public boolean remove(int id);
		
		interface SQL{
	
				String findall_product = "SELECT  pro.* , sub.* , web.*  FROM "
						+ " tbtemporary pro INNER JOIN tbsubcategory sub "
						+ "	ON pro.subcategoryid = sub.subcategoryid "
						+ " INNER JOIN tbweb web "
						+ " ON pro.webid = web.webid "
						;
				String search_product="SELECT  pro.* , sub.* , web.*  FROM "
						+ " tbtemporary pro INNER JOIN tbsubcategory sub "
						+ "	ON pro.subcategoryid = sub.subcategoryid "
						+ "WHERE LOWER(pro.productname) LIKE '%'||LOWER(#{search})||'%' ";
				
				String save_product="INSERT INTO tbtemporary "
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
