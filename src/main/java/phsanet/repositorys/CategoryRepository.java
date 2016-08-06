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
		
		@Result(property="categoryid"				,	column="categoryid"),
		@Result(property="maincategory.maincateid"	, 	column="maincategoryid"),
		@Result(property="maincategory.maincatename", 	column="maincategory"),
		@Result(property="maincategory.describe"	, 	column="desc"),
		@Result(property="categoryname"				,	column="tbcategory.categoryname"),
		@Result(property="describe"					, 	column="describe")
		
	})
	public ArrayList<Category> findALL();
	
	@Select(SQL.search_category)
	@Results({
		@Result(property="categoryid"				,	column="tbmaincategory.maincatid"),
		@Result(property="maincategory.maincateid"	,	column="tbcategory.maincatid"),
		@Result(property="maincategory.maincatename", 	column="maincategory"),
		@Result(property="maincategory.describe"	, 	column="desc"),
		@Result(property="categoryname"				, 	column="tbcategory.categoryname"),
		@Result(property="describe"					, 	column="describe")
	})
	public ArrayList<Category> search(String search);
	
	@Insert(SQL.save_category)
	public boolean save(Category category);
	
	@Update(SQL.update_category)
	public boolean update(Category category);
	
	@Delete(SQL.remove_category)
	public boolean remove(int id);
	
	
	interface SQL{
		
		String findall_category="SELECT tbcategory.* , "
				+ "	tbcategory.maincatid			"
				+ " as maincategoryid,				"
				+ " tbmaincategory.categoryname as 	"
				+ "	maincategory ,					"
				+ " tbmaincategory.describe as 		"
				+ "	desc FROM 						"
				+ "	tbmaincategory INNER JOIN tbcategory on 		"
				+ "	tbmaincategory.maincatid = tbcategory.maincatid ";
		
		String search_category="SELECT tbcategory.*				"
				+ " , tbmaincategory.categoryname				"
				+ " as maincategory , tbmaincategory.describe	"
				+ " as desc FROM tbmaincategory INNER JOIN 		"
				+ "	tbcategory on 								"
				+ "	tbmaincategory.maincatid = tbcategory.maincatid "
				+ "	WHERE categoryname LIKE '%'||#{search}||'%' ";
		
		String save_category="INSERT INTO tbcategory"
				+ "	(maincatid		,"
				+ "	categoryname	,"
				+ "	describe)		 "
				+ " VALUES(#{maincategory.maincateid},"
				+ "	#{categoryname}	,"
				+ "	#{describe})	 ";
		
		String update_category="UPDATE tbcategory"
				+ " 	set 								"
				+ "		maincatid=#{maincategory.maincateid}"
				+ " 	,categoryname=#{categoryname} 		"
				+ "		,describe=#{describe}				"
				+ " 	where categoryid=#{categoryid}		";
		
		String remove_category="DELETE FROM tbcategory where categoryid=#{id}";
	}
	
	
}
