package phsanet.service.implement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import phsanet.entitys.User;
import phsanet.repositorys.UserRepository;
import phsanet.services.UserService;

@Service
@Qualifier("userserviceimplement")
public class UserServiceImplement implements UserService {
	@Autowired
	@Qualifier("userrepository")
	private UserRepository userrepository;

	@Override
	public ArrayList<User> findAll() {
		return userrepository.findAll();
	}

	@Override
	public ArrayList<User> findUserById(int uid) {
		// TODO Auto-generated method stub
		return userrepository.search(uid);
	}

	@Override
	public boolean save(User user) {
		// TODO Auto-generated method stub
		return userrepository.save(user);
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return userrepository.update(user);
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return userrepository.delete(id);
	}

	@Override
	public User findUserByEmail(String email) {
		return userrepository.findUserByEmail(email);
	}
	
}
