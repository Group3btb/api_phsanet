package phsanet.services;

import java.util.ArrayList;

import phsanet.entitys.SubCategory;

public interface SubCategoryService {
	/**
	 * 
	 * @param subcategory
	 * @return boolean
	 */
	public boolean save(SubCategory subcategory);
	/***
	 * 
	 * @param id
	 * @return boolean 
	 */
	public boolean remove(int id);
	/***
	 * 
	 * @param subcategory
	 * @return boolean
	 */
	public boolean update(SubCategory subcategory);
	/***
	 * 
	 * @return all subcategory
	 */
	public ArrayList<SubCategory> findAll();
	/**
	 * 
	 * @return one subcategory
	 */
	public ArrayList<SubCategory> search(String search);
}
