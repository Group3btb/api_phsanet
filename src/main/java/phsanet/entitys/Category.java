package phsanet.entitys;

public class Category {
	private int categoryid;
	private String categoryname;
	
	private MainCategory maincategory;
	
	public Category(){
		
	}
	public Category(int categoryid,int maincategoryid,String categoryname,String describe){
		this.categoryid = categoryid;
		this.categoryname = categoryname;
		this.describe = describe;
	}
	
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}

	private String describe;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.categoryid +" "+ maincategory.getMaincateid()+" "+categoryname +" "+describe;
	}

	public MainCategory getMaincategory() {
		return maincategory;
	}

	public void setMaincategory(MainCategory maincategory) {
		this.maincategory = maincategory;
	}
}
