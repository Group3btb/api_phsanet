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
import phsanet.entitys.User;


@Repository
@Qualifier("userrepository")
public interface UserRepository {
	
	@Select(SQL.findall)
	@Results({
		@Result(property="userid"		,	column="userid"),
		@Result(property="username"		,	column="username"),
		@Result(property="password"		,	column="password"),
		@Result(property="email"		,	column="email")
	})
	public ArrayList<User> findAll();
	
	@Select(SQL.search)
	@Results({
		@Result(property="userid"		,	column="userid"),
		@Result(property="username"		,	column="username"),
		@Result(property="password"		,	column="password"),
		@Result(property="email"		,	column="email")
	})
	public ArrayList<User> search(String search);
	
	
	@Insert(SQL.save)
	public boolean save(User user);
	
	@Update(SQL.update)
	public boolean update(User user);
	
	@Delete(SQL.remove)
	public boolean delete(int id);
	
	interface SQL{
		
		String findall= " SELECT *FROM tbuser ";
		
		String search =	" SELECT *FROM tbuser WHERE LOWER(username) LIKE '%'||LOWER(#{search})||'%'";
		
		String save="	INSERT INTO tbuser(username,password,email) "
				+ "		VALUES(#{username},#{password},#{email})	";
		
		String update="	UPDATE tbuser SET"
				+ " username=#{username} ,"
				+ " password=#{password}  "
				+ " WHERE userid=#{userid}";
		
		String remove ="DELETE FROM tbuser WHERE userid=#{userid}";
	}
	
}
