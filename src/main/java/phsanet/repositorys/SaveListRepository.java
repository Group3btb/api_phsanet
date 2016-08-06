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

import phsanet.entitys.SaveList;

@Repository
@Qualifier("saveListrepository")
public interface SaveListRepository {
	
	@Insert(SQL.save)
	public boolean save(SaveList savelist);
	
	@Update(SQL.update)
	public boolean update(SaveList savelist);
	
	@Delete(SQL.remove)
	public boolean delete(int id);
	
	@Select(SQL.search)
	@Results({
		@Result(property="listid"				, 	column="listid"),
		@Result(property="product.productname"	,	column="productname"),
		@Result(property="product.productimg"	,	column="productimg"),
		@Result(property="product.web.logo" 	, 	column="logo")
	})
	public ArrayList<SaveList> search(String search);
	
	@Select(SQL.findall)
	@Results({
		@Result(property="listid"				, 	column="listid"),
		@Result(property="product.productname"	,	column="productname"),
		@Result(property="product.productimg"	,	column="productimg"),
		@Result(property="product.web.logo" 	, 	column="logo")
	})
	public ArrayList<SaveList> findAll();
	
	interface SQL{
		
		String findall="SELECT listid , productname , productimg , logo "
				+ "	FROM tbuser 						"
				+ "	u INNER JOIN						"
				+ " tbsavelist save						"
				+ " on u.userid = save.userid 			"
				+ "	INNER JOIN tbproduct pro on 		"
				+ "	save.proid = pro.proid INNER JOIN	"
				+ " tbweb web on web.linkid = pro.linkid";
		
		String search="SELECT listid , productname , productimg , logo "
				+ "	FROM tbuser 						"
				+ "	u INNER JOIN						"
				+ " tbsavelist save						"
				+ " on u.userid = save.userid 			"
				+ "	INNER JOIN tbproduct pro on 		"
				+ "	save.proid = pro.proid INNER JOIN	"
				+ " tbweb web on web.linkid = pro.linkid"
				+ "	WHERE productname LIKE '%'||#{search}||'%'";
		
		String save="INSERT INTO tbsavelist(userid,proid)"
				+ " VALUES(			 "
				+ "	#{user.userid},	 "
				+ "	#{product.proid})";
		
		String update="UPDATE tbsavelist 	"
				+ "	SET 					"
				+ "	userid=#{user.userid}  ,"
				+ " proid=#{product.proid} 	"
				+ "	WHERE listid=#{listid}	";
		
		String remove="DELETE FROM tbsavelist WHERE listid=#{listid}";
	}
	
}
