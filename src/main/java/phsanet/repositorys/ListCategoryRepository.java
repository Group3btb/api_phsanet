package phsanet.repositorys;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import phsanet.entitys.SubCategory;
import phsanet.entitys.listcategory.Category;
import phsanet.entitys.listcategory.Main_Category;

@Repository
@Qualifier("listcategoryrepository")
public interface ListCategoryRepository {
	
	
	
	@Select("Select maincategory_id ,"
			+" category_name		,"
			+" description 			 "
			+" From main_category    "
			+" Order By maincategory_id"
			+ "	LIMIT "
			+ "		8 "
			+ "	OFFSET "
			+ "		1 ")
	@Results({
		
		@Result(property="maincategory_id"			,	column="maincategory_id"),
		@Result(property="category_name"			, 	column="category_name"),
		@Result(property="description"				, 	column="description"),
		@Result(property="listcategory"				, 	column="maincategory_id" 
		, many = @Many(select = "findallcategory")),
		
	})
	public ArrayList<Main_Category> findallmaincategory();
	
	
	
	@Select("Select 				"
			+ " category_id		   ,"
			+ " maincategory_id	   ,"
			+ " category_name	   ,"
			+ "	description 		"
			+ " From category Where maincategory_id = #{maincategory_id} ")
	@Results({
		
		@Result(property="category_id"					,	column="category_id"),
		@Result(property="category_name"				, 	column="category_name"),
		@Result(property="description"					, 	column="description"),
		@Result(property="listsubcategory"				, 	column="category_id" 
		, many = @Many(select = "findallsubcategory"))
	})
	public ArrayList<Category> findallcategory(@Param("category_id") int category_id);
	
	
	@Select("Select subcategory_id	,"
			+ "category_id			,"
			+ "subcategory_name		,"
			+ "description			"
			+ "From subcategory	Where category_id =#{category_id}")
	
	@Results({
		@Result(property="subcategory_id"			,	column="subcategory_id"),
		@Result(property="subcategory_name"			, 	column="subcategory_name"),
		@Result(property="description"				,	column="description")
	})
	public ArrayList<SubCategory> findallsubcategory(@Param("category_id") int category_id);
	
	
}
