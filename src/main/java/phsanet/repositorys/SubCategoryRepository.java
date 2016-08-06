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
import phsanet.entitys.SubCategory;

@Service
@Qualifier("subcategoryrepository")
public interface SubCategoryRepository {
	//SIM RATHAHAUSONG
	
	@Insert(SQL.save)
	public boolean save(SubCategory subcategory);
	
	@Select(SQL.findall)
	@Results({
		@Result(property="subcategoryid"			,	column="subcategoryid"),
		@Result(property="category.categoryid"		, 	column="cateid"),
		@Result(property="category.categoryname"	,	column="catename"),
		@Result(property="category.describe"		, 	column="desc"),
		@Result(property="subcategoryname"			, 	column="subcategoryname"),
		@Result(property="describe"					, 	column="subcate.describe")
	})
	public ArrayList<SubCategory> findAll();
	
	@Select(SQL.search)
	@Results({
		@Result(property="subcategoryid"			,	column="subcategoryid"),
		@Result(property="category.categoryid"		, 	column="cateid"),
		@Result(property="category.categoryname"	, 	column="catename"),
		@Result(property="category.describe"		, 	column="desc"),
		@Result(property="subcategoryname"			, 	column="subcategoryname"),
		@Result(property="describe"					, 	column="subcate.describe")
	})
	public ArrayList<SubCategory> search(String search);
	
	@Delete(SQL.remove)
	public boolean remove(int id);
	
	@Update(SQL.update)
	public boolean update(SubCategory subcategory);
	
	
	interface SQL{
		String findall="	SELECT subcate.*,cate.categoryid as cateid,		"
				+ "	cate.categoryname as catename						   ,"
				+ "	cate.describe as desc 									"
				+ "	FROM tbcategory cate INNER JOIN tbsubcategory subcate on"
				+ " cate.categoryid = subcate.categoryid					";
		
		String search="	SELECT subcate.*,cate.categoryid as cateid		,"
				+ "	cate.categoryname as catename						,"
				+ "	cate.describe as desc 								 "
				+ "	FROM (tbcategory cate INNER							 "
				+ " JOIN tbsubcategory subcate on						 "
				+ " cate.categoryid = subcate.categoryid)"
				+ " where subcate.subcategoryname LIKE '%'||#{search}||'%'";
		
		String save ="	INSERT INTO 				"
				+ "	tbsubcategory(categoryid	   ,"
				+ "	subcategoryname,describe)		"
				+ " VALUES(#{category.categoryid}  ,"
				+ "	#{subcategoryname}			   ,"
				+ "	#{describe})				    ";
		
		String remove="DELETE FROM tbsubcategory WHERE subcategoryid=#{id}";
		
		String update="UPDATE tbsubcategory					"
				+ "SET categoryid=#{category.categoryid}   ,"
				+ " subcategoryname=#{subcategoryname}     ,"
				+ "describe =#{describe} 					"
				+ "where subcategoryid =#{subcategoryid}	";
	}
	
}
