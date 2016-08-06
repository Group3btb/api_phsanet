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

import phsanet.entitys.Webs;
// SIM RATHAHAUSONG 
@Repository
@Qualifier("webrepository")
public interface WebRepository {
	
	@Select(SQL.findall)
	@Results({
		@Result(property="webid"			, column="webid"),
		@Result(property="website" 			, column="website"),
		@Result(property="logo" 			, column="logo"),
		@Result(property="status"			, column="status"),
		@Result(property="selectorrow"		, column="selectorrow"),
		@Result(property="selectorname" 	, column="selectorname"),
		@Result(property="selectorprice"	, column="selectorprice"),
		@Result(property="selectorimg" 		, column="selectorimg"),
		@Result(property="selectordescribe"	, column="selectordescribe")
	})
	public ArrayList<Webs> findAll();
	
	@Select(SQL.searchlike)
	@Results({
		
		@Result(property="webid"			, column="webid"),
		@Result(property="website" 			, column="website"),
		@Result(property="logo" 			, column="logo"),
		@Result(property="status"			, column="status"),
		@Result(property="selectorrow"		, column="selectorrow"),
		@Result(property="selectorname" 	, column="selectorname"),
		@Result(property="selectorprice"	, column="selectorprice"),
		@Result(property="selectorimg" 		, column="selectorimg"),
		@Result(property="selectordescribe"	, column="selectordescribe")
	})
	public ArrayList<Webs> search(String search);
	
	@Insert(SQL.insertweb)
	public boolean save(Webs web);
	
	@Delete(SQL.deleteweb)
	public boolean remove(int id);
	
	@Update(SQL.updateweb)
	public boolean update(Webs web);
	
	
	interface SQL{
		
		String findall=" SELECT * FROM tbweb ";
		
		String searchlike="SELECT * FROM tbweb "
				+ "WHERE website LIKE '%'|| #{search} ||'%'";
		
		String insertweb="INSERT INTO tbweb("
				+ "website, "
				+ "logo, "
				+ "status, "
				+ "selectorrow, "
				+ "selectorname, "
				+ "selectorprice, "
				+ "selectorimg, "
				+ "selectordescribe) "
				+ "VALUES("
				+ "#{website}, "
				+ "#{logo}, "
				+ "#{status}, "
				+ "#{selectorrow}, "
				+ "#{selectorname},"
				+ "#{selectorprice}, "
				+ "#{selectorimg}, "
				+ "#{selectordescribe})";
		
		String updateweb="UPDATE tbweb SET "
				+ "website=#{website}, "
				+ "logo=#{logo}, "
				+ "status=#{status},"
				+ "selectorrow=#{selectorrow},"
				+ "selectorname=#{selectorname},"
				+ "selectorprice=#{selectorprice},"
				+ "selectorimg=#{selectorimg},"
				+ "selectordescribe=#{selectordescribe}"
				+ " WHERE webid=#{webid}";
		String deleteweb="DELETE FROM "
				+ "tbweb WHERE webid =#{webid} ";
	}
	
}
