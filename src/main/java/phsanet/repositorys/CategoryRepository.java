package phsanet.repositorys;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import phsanet.entitys.Category;

@Service
@Qualifier("categoryrepository")
public interface CategoryRepository {
	
	@Select(SQL.findall_category)
	@Results({
		
		@Result(property="category_id"					,	column="cate_id"),
		@Result(property="main_category.maincategory_id", 	column="main_id"),
		@Result(property="main_category.category_name"	, 	column="main_name"),
		@Result(property="main_category.description"	, 	column="main_description"),
		@Result(property="category_name"				,	column="cate_name"),
		@Result(property="description"					, 	column="cate_description")
		
		
	})
	public ArrayList<Category> findALL();
	
	@Select(SQL.search_category)
	@Results({
		
		@Result(property="category_id"					,	column="cate_id"),
		@Result(property="main_category.maincategory_id", 	column="main_id"),
		@Result(property="main_category.category_name"	, 	column="main_name"),
		@Result(property="main_category.description"	, 	column="main_description"),
		@Result(property="category_name"				,	column="cate_name"),
		@Result(property="description"					, 	column="cate_description")
		
	})
	public ArrayList<Category> search(String search);
	
	@Insert(SQL.save_category)
	public boolean save(Category category);
	
	@Update(SQL.update_category)
	public boolean update(Category category);
	
	@Delete(SQL.remove_category)
	public boolean remove(int id);
	
	
	interface SQL{ 
		
		String findall_category="	Select "
				+ " main.maincategory_id As main_id			,"
				+ " main.category_name As main_name 		,"
				+ " main.description As main_description	,"
				+ " cate.category_id As cate_id 			,"
				+ " cate.category_name As cate_name			,"
				+ "	cate.description As cate_description	 "
				+ " FROM main_category main INNER 		 	 "
				+ " JOIN category cate ON 				 	 "
				+ " main.maincategory_id = cate.maincategory_id";
		
		String search_category="	Select "
				+ " main.maincategory_id As main_id			,"
				+ " main.category_name As main_name 		,"
				+ " main.description As main_description	,"
				+ " cate.category_id As cate_id 			,"
				+ " cate.category_name As cate_name			,"
				+ "	cate.description As cate_description	 "
				+ " From main_category main Inner 		 	 "
				+ " Join category cate On 				 	 "
				+ " main.maincategory_id = cate.maincategory_id"
				+ " Where Lower(cate.category_name) Like '%'||Lower(#{search})||'%' ";
		
		String save_category="Insert Into category"
				+ "	(maincategory_id			 ,"
				+ "	category_name				 ,"
				+ "	description)		 		  "
				+ " VALUES(#{main_category.maincategory_id},"
				+ "	#{category_name}	,"
				+ "	#{description})	 ";
		
		String update_category="Update category"
				+ " 	Set 								"
				+ "		maincategory_id=#{main_category.maincategory_id}"
				+ " 	,category_name=#{category_name} 		"
				+ "		,description=#{description}				"
				+ " 	where category_id=#{category_id}		";
		
		String remove_category="Delete From category where category_id=#{id}";
	}
	
	
}
