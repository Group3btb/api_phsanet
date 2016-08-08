package phsanet.entitys;

public class SubCategory {
	private int 		subcategory_id;
	private String 		subcategory_name;
	private String 		description;
	private Category 	category;
	
	public int getSubcategory_id() {
		return subcategory_id;
	}
	public void setSubcategory_id(int subcategory_id) {
		this.subcategory_id = subcategory_id;
	}
	public String getSubcategory_name() {
		return subcategory_name;
	}
	public void setSubcategory_name(String subcategory_name) {
		this.subcategory_name = subcategory_name;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
