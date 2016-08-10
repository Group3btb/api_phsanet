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

import phsanet.entitys.Web_Source;
// SIM RATHAHAUSONG 
@Repository
@Qualifier("webrepository")
public interface WebRepository {
	
	@Select(SQL.findall)
	@Results({
		@Result(property="web_source_id"		, column="web_resource_id"),
		@Result(property="website" 				, column="website"),
		@Result(property="logo" 				, column="logo"),
		@Result(property="url"					, column="url"),
		@Result(property="selector_row"			, column="selector_row"),
		@Result(property="selector_name" 		, column="selector_name"),
		@Result(property="selector_price"		, column="selector_price"),
		@Result(property="selector_image" 		, column="selector_image"),
		@Result(property="selector_description"	, column="selector_description")
	})
	public ArrayList<Web_Source> findAll();
	
	@Select(SQL.searchlike)
	@Results({
		
		@Result(property="web_source_id"		, column="web_resource_id"),
		@Result(property="website" 				, column="website"),
		@Result(property="logo" 				, column="logo"),
		@Result(property="url"					, column="url"),
		@Result(property="selector_row"			, column="selector_row"),
		@Result(property="selector_name" 		, column="selector_name"),
		@Result(property="selector_price"		, column="selector_price"),
		@Result(property="selector_image" 		, column="selector_image"),
		@Result(property="selector_description"	, column="selector_description")
	})
	public ArrayList<Web_Source> search(String search);
	
	@Insert(SQL.insertweb)
	public boolean save(Web_Source web);
	
	@Delete(SQL.deleteweb)
	public boolean remove(int id);
	
	@Update(SQL.updateweb)
	public boolean update(Web_Source web);
	
	
	interface SQL{
		
		String findall=" Select * From web_source ";
		
		String searchlike="Select * FROM web_source "
				+ "Where Lower(website) Like '%'|| Lower(#{search}) ||'%'";
		
		String insertweb="	Insert Into web_source("
				+ "website, "
				+ "logo, "
				+ "url, "
				+ "selector_row, "
				+ "selector_name, "
				+ "selector_price, "
				+ "selector_image, "
				+ "selector_description) "
				+ "Values("
				+ "#{website}, "
				+ "#{logo}, "
				+ "#{url}, "
				+ "#{selector_row}, "
				+ "#{selector_name},"
				+ "#{selector_price}, "
				+ "#{selector_image}, "
				+ "#{selector_description})";
		
		String updateweb="Update web_source Set "
				+ "website=#{website}, "
				+ "logo=#{logo}, "
				+ "url=#{url},"
				+ "selector_row=#{selector_row},"
				+ "selector_name=#{selector_name},"
				+ "selector_price=#{selector_price},"
				+ "selector_image=#{selector_image},"
				+ "selector_description=#{selector_description}"
				+ " Where web_source_id=#{web_source_id}";
		String deleteweb="Delete From "
				+ "web_source Where web_source_id =#{web_source_id} ";
	}
	
}
