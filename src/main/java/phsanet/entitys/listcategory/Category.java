package phsanet.entitys.listcategory;

import java.util.ArrayList;

public class Category {
	
	private int 			category_id;
	private String 			category_name;
	private String 			description;
	private ArrayList<SubCategory> listsubcategory;
								 
	
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<SubCategory> getListsubcategory() {
		return listsubcategory;
	}
	public void setListsubcategory(ArrayList<SubCategory> listsubcategory) {
		this.listsubcategory = listsubcategory;
	}
	
	
}
