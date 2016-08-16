package phsanet.controllers;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import phsanet.entitys.Products;
import phsanet.entitys.Scrap_Managerment;
import phsanet.entitys.SubCategory;
import phsanet.entitys.Web_Source;
import phsanet.service.implement.ProductServiceImplement;
import phsanet.service.implement.ProductTemporaryImplement;
import phsanet.service.implement.ScrapManagermenetImplement;

@RestController
public class ScrapingManagermentController {
	
	@Autowired
	@Qualifier("scrapmanagermenetimplement")
	private ScrapManagermenetImplement scrapmanagermenetimplement;
	
	@Autowired
	@Qualifier("productserviceimplement")
	private ProductServiceImplement productserviceimplement;
	
	@Autowired
	@Qualifier("producttemporaryimplement")
	private ProductTemporaryImplement producttemporaryimplement;
	
	@RequestMapping(value={"/startscrap"} , method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> start_scraping(@RequestBody Web_Source web){
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		try{
			
			for(Scrap_Managerment scrap : this.findAll_scrap(web.getWeb_source_id())){
				if(scrap.getStatus().toLowerCase().trim().compareTo("yes")==0){
						productserviceimplement.save(this._scraping(scrap));
				}else{
						producttemporaryimplement.save(this._scraping(scrap));
				}
			}
			
		}catch(Exception ex){
			map.put("ERROR",false);
			ex.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	
	public ArrayList<Scrap_Managerment> findAll_scrap(int id){
		ArrayList<Scrap_Managerment> scrap = new ArrayList<>();
		scrap = scrapmanagermenetimplement.search(id);
		return scrap;
	}
	
	
	private ArrayList<Products> _scraping(Scrap_Managerment scrap) throws IOException{
		
		
		ArrayList<String> all_name 		= new ArrayList<>();
		ArrayList<String> all_image 	= new ArrayList<>();
		ArrayList<String> all_price 	= new ArrayList<>();
		ArrayList<String> all_describe 	= new ArrayList<>();
		ArrayList<Products> all_product = new ArrayList<Products>(); 
		String url					=	scrap.getUrl().trim();//"http://www.kaymu.com.kh/women-clothing/";
		String row_selector 		=	scrap.getWeb_source().getSelector_row(); // "div.product";
		String selector_product_name=  	scrap.getWeb_source().getSelector_name();   //"h3.ellipsis";
		String selector_price 		= 	scrap.getWeb_source().getSelector_price();  //"span.price";
		String selector_url_image	=	scrap.getWeb_source().getSelector_image() ;  //"img";
		String selector_descride	=	scrap.getWeb_source().getSelector_description() ; //"p";
		//String website 				= 	scrap.getWeb_source().getWebsite().trim();
		int web_source_id 			=   scrap.getWeb_source().getWeb_source_id();
		int subcategory_id 			= 	scrap.getSubcategory().getSubcategory_id();
		
		try {
			
			Document document = Jsoup.connect(url).timeout(10000).get();
			Elements main_selector = document.select(row_selector);
			
			System.out.println("URL "+scrap.getUrl());
			/*Connection con = HttpConnection.connect(url)
					.method(Method.POST)
					.da*/
			//System.out.println(main_selector.text());
			
			Elements e_product_name =main_selector.select(selector_product_name);
			for(Element e : e_product_name){
				
				System.out.println(e.text());
				all_name.add(e.text());
				
			}
			
			Elements e_url_image = main_selector.select(selector_url_image);
			for(Element e: e_url_image){
				/*System.out.println(e.attr("data-layzr"));
				all_image.add(e.attr("data-layzr"));*/
				String img = e.attr("data-layzr").toString().trim();
				System.out.println("Boolean "+img.compareTo(""));
				if(img.compareTo("")!=0){
					all_image.add(e.attr("data-layzr"));
					System.out.println(e.attr("data-layzr"));
				}else{
					System.out.println(e.attr("src"));
					all_image.add(e.attr("src"));
				}
				
			}
			//ArrayList<String> price = new ArrayList<String>();
			Elements e_price = main_selector.select(selector_price);
			for(Element e:e_price){
				 System.out.println(e.text());
				all_price.add(e.text());
			}
		
			Elements e_descride = main_selector.select(selector_descride);
			for(Element e : e_descride){
				System.out.println("Detail "+e.attr("href"));
				all_describe.add(url+e.attr("href"));
			}
		
			int i = 0;
			for(String pro_name : all_name){
				
				Products product = new Products();
				try{
					product.setWeb(new Web_Source());
					product.getWeb().setWeb_source_id(web_source_id);
				}catch(Exception ex){
					System.out.println("Web "+ex.getMessage());
				}
				try{
					product.setSubcategory(new SubCategory());
					product.getSubcategory().setSubcategory_id(subcategory_id);
				}catch(Exception ex){
					System.out.println("Error sub "+ex.getMessage());
				}
				try{
					product.setProduct_name(pro_name);
				}catch(Exception ex){}
				try{
					product.setPrice(all_price.get(i));
				}catch(Exception ex){}
				try{
					product.setProduct_image(all_image.get(i));	
				}catch(Exception ex){}
				try{
					product.setDescription(all_describe.get(i));	
				}catch(Exception ex){}
				all_product.add(product);
				
				i++;
			}
			System.out.println("All product "+all_product);
			System.out.println("Size "+all_product.size());	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return all_product;
	}
	
}
