package phsanet.entitys;

public class Products {
	// SIM RATHAHAUSONG
	 private int 			proid;
	 private SubCategory 	subcategory;
	 private String 		productname;
	 private String 		price;
	 private String 		describe;
	 private String 		link;
	 private String 		productimg;
	 private Webs web;
	public Webs getWeb() {
		return web;
	}
	public void setWeb(Webs web) {
		this.web = web;
	}
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
	public SubCategory getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(SubCategory subcategory) {
		this.subcategory = subcategory;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getProductimg() {
		return productimg;
	}
	public void setProductimg(String productimg) {
		this.productimg = productimg;
	}
}
