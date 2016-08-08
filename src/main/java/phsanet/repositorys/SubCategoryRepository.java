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
		@Result(property="subcategory_id"			,	column="sub_id"),
		@Result(property="subcategory_name"			, 	column="sub_name"),
		@Result(property="description"				,	column="sub_description"),
		@Result(property="category.category_id"		, 	column="cate_id"),
		@Result(property="category.category_name"	, 	column="cate_name"),
		@Result(property="category.description"	, 	column="cate_description")
	})
	public ArrayList<SubCategory> findAll();
	
	@Select(SQL.search)
	@Results({
		@Result(property="subcategory_id"			,	column="sub_id"),
		@Result(property="subcategory_name"			, 	column="sub_name"),
		@Result(property="description"				,	column="sub_description"),
		@Result(property="category.category_id"		, 	column="cate_id"),
		@Result(property="category.category_name"	, 	column="cate_name"),
		@Result(property="category.description"		, 	column="cate_description")
	})
	public ArrayList<SubCategory> search(String search);
	
	@Delete(SQL.remove)
	public boolean remove(int id);
	
	@Update(SQL.update)
	public boolean update(SubCategory subcategory);
	
	
	interface SQL{
		String findall="Select "
				+ "	sub.subcategory_id As sub_id		,"
				+ " sub.subcategory_name As sub_name 	,"
				+ " sub.description As sub_description	,"
				+ "	cate.category_id As cate_id 		,"
				+ " cate.category_name As cate_name 	,"
				+ " cate.description As cate_description "
				+ " From category cate Inner Join   	 "
				+ "	subcategory sub On cate.category_id	 "
				+ " = sub.category_id";
		
		String search="Select "
				+ "	sub.subcategory_id As sub_id		,"
				+ " sub.subcategory_name As sub_name 	,"
				+ " sub.description As sub_description	,"
				+ "	cate.category_id As cate_id 		,"
				+ " cate.category_name As cate_name 	,"
				+ " cate.description As cate_description "
				+ " From category cate Inner Join   	 "
				+ "	subcategory sub On cate.category_id	 "
				+ " = sub.category_id 					 "
				+ " Where Lower(sub.subcategory_name) Like '%'|| Lower(#{search}) ||'%'";
		
		String save ="	Insert Into 				"
				+ "	subcategory(category_id	   ,"
				+ "	subcategory_name,description)	"
				+ " Values(#{category.category_id}  ,"
				+ "	#{subcategory_name}			   ,"
				+ "	#{description})				    ";
		
		String remove="DELETE FROM subcategory WHERE subcategory_id=#{id}";
		
		String update="Update subcategory					"
				+ "SET category_id=#{category.category_id}   ,"
				+ " subcategory_name=#{subcategory_name}     ,"
				+ "description =#{description} 					"
				+ "where subcategory_id =#{subcategory_id}	";
	}
	
}
