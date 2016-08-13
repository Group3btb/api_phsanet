package phsanet.entitys;

public class Temporary_Item {
	
		 // SIM RATHAHAUSONG
		private int 			product_id;
		private SubCategory 	subcategory;
		private String 			product_name;
		private String 			price;
		private String 			description;
		private String 			product_image;
		private Web_Source 		web_source;
		
			
		public int getProduct_id() {
			return product_id;
		}
		public void setProduct_id(int product_id) {
			this.product_id = product_id;
		}
		public SubCategory getSubcategory() {
			return subcategory;
		}
		public void setSubcategory(SubCategory subcategory) {
			this.subcategory = subcategory;
		}
		public String getProduct_name() {
			return product_name;
		}
		public void setProduct_name(String product_name) {
			this.product_name = product_name;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
	
		public String getProduct_image() {
			return product_image;
		}
		public void setProduct_image(String product_image) {
			this.product_image = product_image;
		}
		public Web_Source getWeb_source() {
			return web_source;
		}
		public void setWeb_source(Web_Source web_source) {
			this.web_source = web_source;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	
}
