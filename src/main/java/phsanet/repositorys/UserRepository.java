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
		@Result(property="user_id"		,	column="user_id"),
		@Result(property="user_name"	,	column="user_name"),
		@Result(property="password"		,	column="password"),
		@Result(property="email"		,	column="email")
	})
	public ArrayList<User> findAll();
	
	@Select(SQL.search)
	@Results({
		@Result(property="user_id"		,	column="user_id"),
		@Result(property="user_name"	,	column="user_name"),
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
	
	@Select("SELECT user_id, user_name, password, email, role FROM user_phsanet WHERE email=#{email}")
	public User findUserByEmail(String email);
	
	interface SQL{
		
		String findall= " Select * From user_phsanet ";
		
		String search =	" Select * From user_phsanet Where Lower(user_name) Like '%'||Lower(#{search})||'%'";
		
		String save="	Insert Into user_phsanet (user_name,password,email, role)  "
				+ "		Values(#{user_name},#{password},#{email},#{role})	 ";
		
		String update="	Update user_phsanet SET		 "
				+ " user_name=#{user_name} 	,"
				+ " password=#{password}  	 "
				+ " Where user_id=#{user_id} ";
		
		String remove ="Delete From user_phsanet Where user_id=#{user_id}";
	}
	
}
