package phsanet.services;

import java.util.ArrayList;

import phsanet.entitys.Main_Category;

public interface MainCategoryService {
	
	
	public ArrayList<Main_Category> findAll();
	public boolean save(Main_Category maincate);
	public boolean update(Main_Category maincate);
	public boolean remove(int id);
	public Main_Category findOne(int id);
	public ArrayList<Main_Category> search(String search);
	
}
