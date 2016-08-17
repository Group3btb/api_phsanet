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

import phsanet.entitys.Site_Detail_Managerment;

@Repository
@Qualifier("Scrapmanagermentrepository")
public interface SiteDetailManagermentRepository {
	
	@Select(SQL.findAll)
	@Results({
		
		@Result(property="url"								,	column=	"scrap_url"),
		@Result(property="scrap_id"							,	column=	"scrap_id"),
		@Result(property="status"							,	column=	"scrap_status"),
		@Result(property="web_source.web_source_id"			,	column=	"web_id"),
		@Result(property="web_source.website"				,	column=	"web_name"),
		@Result(property="subcategory.subcategory_id"		,	column=	"sub_id"),
		@Result(property="subcategory.subcategory_name"		,	column=	"sub_name"),
		@Result(property="web_source.logo"					,	column=	"web_logo"),
		@Result(property="web_source.url"					, 	column= "web_url"),
		@Result(property="web_source.selector_row"			, 	column= "web_row"),
		@Result(property="web_source.selector_name" 		, 	column= "web_product_name"),
		@Result(property="web_source.selector_price"		, 	column= "web_price"),
		@Result(property="web_source.selector_image" 		, 	column= "web_image"),
		@Result(property="web_source.selector_description"	, 	column= "web_description")
		
	})
	public ArrayList<Site_Detail_Managerment> findAll();
	
	@Select(SQL.search)
	@Results({
		
		@Result(property="url"								,	column=	"scrap_url"),
		@Result(property="scrap_id"							,	column=	"scrap_id"),
		@Result(property="status"							,	column=	"scrap_status"),
		@Result(property="web_source.web_source_id"			,	column=	"web_id"),
		@Result(property="web_source.website"				,	column=	"web_name"),
		@Result(property="subcategory.subcategory_id"		,	column=	"sub_id"),
		@Result(property="subcategory.subcategory_name"		,	column=	"sub_name"),
		@Result(property="web_source.logo"					,	column=	"web_logo"),
		@Result(property="web_source.url"					, 	column= "web_url"),
		@Result(property="web_source.selector_row"			, 	column= "web_row"),
		@Result(property="web_source.selector_name" 		, 	column= "web_product_name"),
		@Result(property="web_source.selector_price"		, 	column= "web_price"),
		@Result(property="web_source.selector_image" 		, 	column= "web_image"),
		@Result(property="web_source.selector_description"	, 	column= "web_description")
		
	})
	public ArrayList<Site_Detail_Managerment> search(int id);
	
	@Insert(SQL.save)
	public boolean save(Site_Detail_Managerment scrap);
	
	@Update(SQL.update)
	public boolean update(Site_Detail_Managerment scrap);
	
	@Update(SQL.update_status)
	public boolean update_status(Site_Detail_Managerment scrap);
	
	@Delete(SQL.delete)
	public boolean remove(int id);
	
	interface SQL{
		
		String findAll="Select "
				
				+ "		scp.scrap_id 			as scrap_id				,"
				+ "		web.website 			as web_name				,"
				+ "		web.web_source_id 		as web_id				,"
				+ "		web.logo 				as web_logo				,"
				+ "		web.url					as web_url				,"
				+ "		web.selector_row 		as web_row				,"
				+ "		web.selector_name 		as web_product_name		,"
				+ "		web.selector_price		as web_price			,"
				+ "		web.selector_image 		as web_image			,"
				+ "		web.selector_description as web_description		,"
				+ "		scp.url 				as scrap_url			,"
				+ "		scp.status				as scrap_status			,"
				+"		sub.subcategory_id      as sub_id				,"	
				+ "		sub.subcategory_name 	as sub_name				 "
				+ " 	From scrap scp Inner Join web_source web 		 "
				+ "		on scp.web_source_id = web.web_source_id		 "
				+ "		Inner Join subcategory sub 						 "
				+ "		on scp.subcategory_id = sub.subcategory_id		 ";
		
		String save = "Insert Into scrap"
				+ "		(url,web_source_id,subcategory_id) 			"
				+ "		Values(#{url}							   ,"
				+ "		#{web_source.web_source_id}				   ,"
				+ "		#{subcategory.subcategory_id}) 				";
		
		String search="Select "
				
				+ "		scp.scrap_id 			as scrap_id				,"
				+ "		web.website 			as web_name				,"
				+ "		web.web_source_id 		as web_id				,"
				+ "		web.logo 				as web_logo				,"
				+ "		web.url					as web_url				,"
				+ "		web.selector_row 		as web_row				,"
				+ "		web.selector_name 		as web_product_name		,"
				+ "		web.selector_price		as web_price			,"
				+ "		web.selector_image 		as web_image			,"
				+ "		web.selector_description as web_description		,"
				+ "		scp.url 				as scrap_url			,"
				+ "		scp.status				as scrap_status			,"
				+"		sub.subcategory_id      as sub_id				,"	
				+ "		sub.subcategory_name 	as sub_name				 "
				+ " 	From scrap scp Inner Join web_source web "
				+ "		on scp.web_source_id = web.web_source_id "
				+ "		Inner Join subcategory sub "
				+ "		on scp.subcategory_id = sub.subcategory_id 		"
				+ "		Where 	web.web_source_id = #{id}				";
		
		String update="	Update scrap Set url=#{url} Where scrap_id=#{scrap_id} ";
		
		String update_status =" Update scrap Set status=#{status} Where scrap_id=#{scrap_id} ";
		
		String delete=" Delete From scrap Where scrap_id=#{id}";
				
		
	}
	
}
