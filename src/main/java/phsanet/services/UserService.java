package phsanet.services;

import java.util.ArrayList;

import phsanet.entitys.User;

public interface UserService {
	public ArrayList<User> findAll();
	public ArrayList<User> search(String search);
	public boolean save(User user);
	public boolean update(User user);
	public boolean remove(int id);
}
