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

import phsanet.entitys.Main_Category;


@Repository
@Qualifier("maincategoryrepository")
public interface MainCategoryRepository {
	// SIM RATHAHAUSONG
	/**
	 * 
	 * @return
	 */
	@Select(SQL.findall_maincategory)
	@Results({
		@Result(property="maincate_id"			,	column="maincat_id"),
		@Result(property="category_name"		, 	column="category_name"),
		@Result(property="description"				, 	column="description")
	})
	ArrayList<Main_Category> findAll();
	/***
	 * 
	 * @param search
	 * @return
	 */
	@Select(SQL.search_maincategory)
	@Results({
		@Result(property="maincateid"		, 	column="maincatid"),
		@Result(property="maincatename"		, 	column="categoryname"),
		@Result(property="description"		, 	column="description")
	})
	ArrayList<Main_Category> search(String search);
	
	/**
	 * 
	 * @param maincate
	 * @return one object maincategory
	 */
	@Select("SELECT *FROM main_category where maincategory_id=#{id}")
	Main_Category findOne(int id);
	
	/***
	 * 
	 * @param maincate
	 * @return
	 */
	@Insert(SQL.save_maincategory)
	boolean save(Main_Category maincate);
	/***
	 * 
	 * @param id
	 * @return
	 */
	@Delete(SQL.remove_maincategory)
	boolean remove(int id);
	/***
	 * 
	 * @param maincate
	 * @return
	 */
	@Update(SQL.update_maincategory)
	boolean update(Main_Category maincate);
	
	interface SQL{
		
		String findall_maincategory="SELECT  *FROM main_category";
		
		String search_maincategory ="Select *From main_category "
				+ "	where Lower(category_name) Like '%'||Lower(#{search})||'%'  ";
		
		String save_maincategory="Insert Into "
				+ "	main_category	"
				+ "	(category_name,	"
				+ "	description)		"
				+ "	Values(			"
				+ "	#{category_name},"
				+ "	#{description})	";
		
		String remove_maincategory="Delete From main_category Where maincategory_id=#{id}";
		
		String update_maincategory="Update  main_category  "
				+ "	Set 						  		    "
				+ "	category_name=#{category_name}, 		"
				+ "	description=#{description} 					"
				+ "	where maincategory_id=#{maincategory_id}	";
	}
	
}
