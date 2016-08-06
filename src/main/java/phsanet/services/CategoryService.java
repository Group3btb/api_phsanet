package phsanet.services;

import java.util.ArrayList;

import phsanet.entitys.Category;


public interface CategoryService {
	public ArrayList<Category> findAll();
	public boolean save(Category category);
	public boolean update(Category category);
	public boolean remove(int id);
	public ArrayList<Category> search(String search);
}
