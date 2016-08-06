package phsanet.services;

import java.util.ArrayList;

import phsanet.entitys.MainCategory;

public interface MainCategoryService {
	
	
	public ArrayList<MainCategory> findAll();
	public boolean save(MainCategory maincate);
	public boolean update(MainCategory maincate);
	public boolean remove(int id);
	public MainCategory findOne(int id);
	public ArrayList<MainCategory> search(String search);
	
}
