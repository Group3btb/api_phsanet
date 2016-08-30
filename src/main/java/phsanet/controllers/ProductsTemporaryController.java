package phsanet.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import phsanet.entitys.Products;
import phsanet.service.implement.ProductServiceImplement;
import phsanet.service.implement.ProductTemporaryImplement;
import phsanet.util.Paging;
import phsanet.util.ProductFilter;


@RestController
public class ProductsTemporaryController {
	@Autowired
	@Qualifier("producttemporaryimplement")
	private ProductTemporaryImplement producttemporaryimplement;
	
	@Autowired
	@Qualifier("productserviceimplement")
	private ProductServiceImplement productserviceimplement;
	
	/*@Scheduled(cron="0 0 12 1/7 * ? *")
	public void autoscrap(){
		
		try{	
			producttemporaryimplement.removeall();
		}catch(Exception ex){
			System.out.println("Error auto scrap "+ex.getMessage());
		}
	}*/
	
	@RequestMapping(value={"/api/temporary"},method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findAllProductsTemporary(ProductFilter filter,Paging pagin){
		Map<String,Object> map = new HashMap<String,Object>();
		ArrayList<Products> allproduct = new ArrayList<>();
		allproduct = producttemporaryimplement.findAll(filter,pagin);
		if(allproduct.isEmpty()){
			map.put("MESSAG","DATA NOT FOUND");
			map.put("STATUS",false);
		}else{
			map.put("MESSAG","DATA FOUND");
			map.put("STATUS",true);
			map.put("PAGE",pagin);
			map.put("DATA",allproduct);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/temporary/{id}"},method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findOneProductsTemporary(@PathVariable("id") int id){
		Map<String,Object> map = new HashMap<String,Object>();
		Products product = new Products();
		product = producttemporaryimplement.find_into_product(id);
		if(product==null){
			map.put("MESSAG","DATA NOT FOUND");
			map.put("STATUS",false);
		}else{
			map.put("MESSAG","DATA FOUND");
			map.put("STATUS",true);
			map.put("DATA",product);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value={"api/temporary/status"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> findproductbyid(@RequestBody List<Object> id){
		System.out.println("Hello id API");
		Map<String,Object> map = new HashMap<>();
		ArrayList<Products> all_product = new ArrayList<>();
		try{
			System.out.println("API "+id);
			for(Object pro_id : id){
				int pro_i = Integer.parseInt(String.valueOf(pro_id));
				all_product.add(producttemporaryimplement.find_into_product(pro_i));
				producttemporaryimplement.update_status("yes",pro_i);
				productserviceimplement.save(all_product);
			}
			
			System.out.println("pro "+all_product);
		}catch(Exception ex){
			System.out.println("Error "+ex.getMessage());
		}
		map.put("s", 123);
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/temporary"},method= RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateProductTemporary(@RequestBody Products product){
		Map<String,Object> map = new HashMap<String, Object>();
		if(producttemporaryimplement.update(product)){
			map.put("MESSAG","UPDATE SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","UPDATE FAIL");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	
	@RequestMapping(value={"/api/temporary/{id}"},method= RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> removeProductTemporary(@PathVariable("id") int id){
		Map<String,Object> map = new HashMap<String, Object>();
		if(producttemporaryimplement.remove(id)){
			map.put("MESSAG","DELTE SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","DELTE FAIL");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	
}
