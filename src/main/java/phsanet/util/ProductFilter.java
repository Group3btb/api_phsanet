package phsanet.util;

public class ProductFilter {
	
	private String subcategoryname;
	public String getSubcategoryname() {
		return subcategoryname;
	}
	public void setSubcategoryname(String subcategoryname) {
		this.subcategoryname = subcategoryname;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	private String productname;
	private String website;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "productname "+this.productname +" subcategory "+this.subcategoryname+" website "+this.website;
	}
	
}

