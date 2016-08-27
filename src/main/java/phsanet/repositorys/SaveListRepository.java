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

import phsanet.entitys.Save_List;

@Repository
@Qualifier("saveListrepository")
public interface SaveListRepository {
	
	@Insert(SQL.save)
	public boolean save(Save_List savelist);
	
	@Update(SQL.update)
	public boolean update(Save_List savelist);
	
	@Delete(SQL.remove)
	public boolean delete(int id);
	
	@Select(SQL.search)
	@Results({
		@Result(property="list_id"				, 	column="list_id"),
		@Result(property="product.product_name"	,	column="product_name"),
		@Result(property="product.product_image",	column="product_image"),
		@Result(property="product.web.logo" 	, 	column="logo")
	})
	public ArrayList<Save_List> search(String search);
	
	@Select(SQL.findall)
	@Results({
		@Result(property="list_id"					, 	column="list_id"),
		@Result(property="user.user_id"				,	column="user_id"),
		@Result(property="product.product_id" 		,	column="product_id"),
		@Result(property="product.product_name"		,	column="product_name"),
		@Result(property="product.product_image"	,	column="product_image"),
		@Result(property="product.price"			,	column="price"),
		@Result(property="product.description"		,	column="description"),
		@Result(property="web.web_source_id"		,	column="web_source_id"),
		@Result(property="web.website"				,	column="website"),
		@Result(property="web.url"					,	column="url"),
		@Result(property="web.logo" 				, 	column="logo")
	})
	public ArrayList<Save_List> findAll(int id);
	
	interface SQL{
		
		String findall="	Select 									"
				+ " 	s.list_id		 							,"
				+ " 	s.user_id		 					   		,"
				+ " 	pro.product_id	 							,"
				+ " 	pro.product_name 							,"
				+ " 	pro.product_image 							 ,"
				+ " 	pro.price									 ,"
				+ " 	pro.description 							 ,"
				+ " 	web.web_source_id							 ,"
				+ " 	web.website									 ,"
				+ " 	web.url										 ,"
				+ " 	web.logo									"
				+ "		FROM user_phsanet u                         "
				+ "	    Inner Join save_list					    "
				+ " 	s On u.user_id = s.user_id		    	"
				+ "		Inner Join product pro					    "
				+ "		On s.product_id = pro.product_id Inner		"
				+ "		Join web_source web						    "
				+ "		On web.web_source_id = pro.web_source_id 	"
				+ "		Where s.user_id=#{id} 						";
		
		String search="	Select 									"
				+ " 	product_name 							   ,"
				+ " 	product_image 							   ,"
				+ " 	website									   ,"
				+ " 	logo									    "
				+ "		From user_phsanet u                         "
				+ "I	nner Join save_list							"
				+ " 	save On u.user_id = save.user_id		    "
				+ "		Inner Join product pro					    "
				+ "		On save.product_id = pro.product_idInner	"
				+ "		Join web_source web						    "
				+ "		On web.web_source_id = pro.web_source_id	"
				+ "		Where product_name Like '%'||Lower(#{search}||'%')";
		String save="Insert Into save_list(user_id,product_id)"
				+ " VALUES(			 "
				+ "	#{user.user_id},	 "
				+ "	#{product.product_id})";
		
		String update="Update save_list 	"
				+ "	SET 					"
				+ "	user_id=#{user.user_id}  ,"
				+ " product_id=#{product.product_id} 	"
				+ "	Where listid=#{list_id}	";
		
		String remove="Delete From save_list Where list_id=#{id}";
	}
	
}
