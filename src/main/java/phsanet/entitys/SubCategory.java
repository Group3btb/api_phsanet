package phsanet.entitys;

public class SubCategory {
	private int subcategoryid;
	private String subcategoryname;
	private String describe;
	private Category category;
	
	public SubCategory(){
		
	}
	public SubCategory(int subcategoryid,int categoryid, String subcategoryname,String describe){
		this.subcategoryid = subcategoryid;
		this.subcategoryname = subcategoryname;
		this.describe = describe;
	}
	public int getSubcategoryid() {
		return subcategoryid;
	}
	public void setSubcategoryid(int subcategoryid) {
		this.subcategoryid = subcategoryid;
	}
	public String getSubcategoryname() {
		return subcategoryname;
	}
	public void setSubcategoryname(String subcategoryname) {
		this.subcategoryname = subcategoryname;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
