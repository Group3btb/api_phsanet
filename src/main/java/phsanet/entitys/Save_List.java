package phsanet.entitys;

public class Save_List {
	private int list_id;
	private Products product;
	private User user;
	private Web_Source web;
	public Web_Source getWeb() {
		return web;
	}
	public void setWeb(Web_Source web) {
		this.web = web;
	}
	public int getList_id() {
		return list_id;
	}
	public void setList_id(int list_id) {
		this.list_id = list_id;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
