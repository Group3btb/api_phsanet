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

import phsanet.entitys.MainCategory;


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
		@Result(property="maincateid"		,	column="maincatid"),
		@Result(property="maincatename"		, 	column="categoryname"),
		@Result(property="describe"			, 	column="describe")
	})
	ArrayList<MainCategory> findAll();
	/***
	 * 
	 * @param search
	 * @return
	 */
	@Select(SQL.search_maincategory)
	@Results({
		@Result(property="maincateid"		, 	column="maincatid"),
		@Result(property="maincatename"		, 	column="categoryname"),
		@Result(property="describe"			, 	column="describe")
	})
	ArrayList<MainCategory> search(String search);
	
	/**
	 * 
	 * @param maincate
	 * @return one object maincategory
	 */
	@Select("SELECT *FROM tbmaincategory where maincatid=#{id}")
	MainCategory findOne(int id);
	
	/***
	 * 
	 * @param maincate
	 * @return
	 */
	@Insert(SQL.save_maincategory)
	boolean save(MainCategory maincate);
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
	boolean update(MainCategory maincate);
	
	interface SQL{
		
		String findall_maincategory="SELECT  *FROM tbmaincategory";
		
		String search_maincategory ="select *from tbmaincategory "
				+ "	where LOWER(categoryname) like '%'||LOWER(#{search})||'%'  ";
		
		String save_maincategory="INSERT INTO "
				+ "	tbmaincategory	"
				+ "	(categoryname,	"
				+ "	describe)		"
				+ "	VALUES(			"
				+ "	#{maincatename},"
				+ "	#{describe})	";
		
		String remove_maincategory="DELETE FROM tbmaincategory where maincatid=#{id}";
		
		String update_maincategory="UPDATE  tbmaincategory "
				+ "	SET 						  	"
				+ "	categoryname=#{maincatename}, 	"
				+ "	describe=#{describe} 			"
				+ "	where maincatid=#{maincateid}	";
	}
	
}
