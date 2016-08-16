package phsanet.entitys;

public class Scrap_Managerment {
	
	private int scrap_id;
	private Web_Source web_source;
	private SubCategory subcategory;
	private String url;
	private String status;
	public Web_Source getWeb_source() {
		return web_source;
	}
	public void setWeb_source(Web_Source web_source) {
		this.web_source = web_source;
	}
	public SubCategory getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(SubCategory subcategory) {
		this.subcategory = subcategory;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getScrap_id() {
		return scrap_id;
	}
	public void setScrap_id(int scrap_id) {
		this.scrap_id = scrap_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
