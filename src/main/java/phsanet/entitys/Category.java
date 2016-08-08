package phsanet.entitys;

public class Category {
	private int 			category_id;
	private String 			category_name;
	private Main_Category 	main_category;
	private String 			description;

	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.category_id +" "+" "+category_name +" "+description;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
	public Main_Category getMain_category() {
		return main_category;
	}

	public void setMain_category(Main_Category main_category) {
		this.main_category = main_category;
	}

}
