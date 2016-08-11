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

import phsanet.entitys.Scrap_Managerment;

@Repository
@Qualifier("Scrapmanagermentrepository")
public interface ScrapManagermentRepository {
	
	@Select(SQL.findAll)
	@Results({
		
		@Result(property="url"								,column=	"scrap_url"),
		@Result(property="scrap_id"							,column=	"scrap_id"),
		@Result(property="web_source.website"				,column=	"web_name"),
		@Result(property="subcategory.subcategory_name"		,column=	"sub_name"),
		@Result(property="web_source.logo"					,column=	"web_logo")
		
	})
	public ArrayList<Scrap_Managerment> findAll();
	
	@Select(SQL.search)
	@Results({
		
		@Result(property="url"								,column=	"scrap_url"),
		@Result(property="scrap_id"							,column=	"scrap_id"),
		@Result(property="web_source.website"				,column=	"web_name"),
		@Result(property="subcategory.subcategory_name"		,column=	"sub_name"),
		@Result(property="web_source.logo"					,column=	"web_logo")
		
	})
	public ArrayList<Scrap_Managerment> search(String search);
	
	@Insert(SQL.save)
	public boolean save(Scrap_Managerment scrap);
	
	@Update(SQL.update)
	public boolean update(Scrap_Managerment scrap);
	
	@Delete(SQL.delete)
	public boolean remove(int id);
	
	interface SQL{
		
		String findAll="Select "
				
				+ "		scp.scrap_id 			as scrap_id				,"
				+ "		web.website 			as web_name				,"
				+ "		web.logo 				as web_logo				,"
				+ "		scp.url 				as scrap_url			,"
				+ "		sub.subcategory_name 	as sub_name				 "
				+ " 	From scrap scp Inner Join web_source web "
				+ "		on scp.web_source_id = web.web_source_id "
				+ "		Inner Join subcategory sub "
				+ "		on scp.subcategory_id = sub.subcategory_id";
		
		String save = "Insert Into scrap"
				+ "		(url,web_source_id,subcategory_id) 			"
				+ "		Values(#{url}							   ,"
				+ "		#{web_source.web_source_id}				   ,"
				+ "		#{subcategory.subcategory_id}) 				";
		
		String search="	Select "
				+ "		scp.scrap_id 			as scrap_id				,"
				+ "		web.website 			as web_name				,"
				+ "		web.logo 				as web_logo				,"
				+"		sub.subcategory_name 	as sub_name				,"
				+ "		scp.url 				as scrap_url			 "
				+ " 	From scrap scp Inner Join web_source web "
				+ "		on scp.web_source_id = web.web_source_id "
				+ "		Inner Join subcategory sub "
				+ "		on scp.subcategory_id = sub.subcategory_id Where web.web_name '%'||#{search}||'%'";
		
		String update="	Update scrap Set url=#{url} Where scrap_id=#{scrap_id} ";
		
		String delete=" Delete From scrap Where scrap_id=#{id}";
		
		
		
	}
	
}
