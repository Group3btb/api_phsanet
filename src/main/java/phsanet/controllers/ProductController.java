package phsanet.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import phsanet.entitys.Products;
import phsanet.service.implement.ProductServiceImplement;
import phsanet.util.Paging;
import phsanet.util.ProductFilter;

@RestController
public class ProductController {
	
	@Autowired
	@Qualifier("productserviceimplement")
	private ProductServiceImplement productserviceimplement;
		
	
	@RequestMapping(value={"/api/product"},method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findAllProducts(ProductFilter filter,Paging pagin){
		Map<String,Object> map = new HashMap<String,Object>();
		ArrayList<Products> allproduct = new ArrayList<Products>();
		allproduct = productserviceimplement.findAll(filter,pagin);
		System.out.println("Filter "+ filter.getProductname());
		phsanet.util.Console.log(filter);
		phsanet.util.Console.log(pagin);
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
	@RequestMapping(value={"/api/product"},method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> saveProduct(@RequestBody ArrayList<Products> product){
		Map<String,Object> map = new HashMap<String, Object>();
		if(productserviceimplement.save(product)){
			map.put("MESSAG","INSERT SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","INSERT FAIL");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	
	/*@RequestMapping(value={"/product/{search}"},method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> searchProducts(@PathVariable("search") String search){
		Map<String,Object> map = new HashMap<String,Object>();
		ArrayList<Products> allproduct = new ArrayList<Products>();
		allproduct = productserviceimplement.search(search);
		if(allproduct.isEmpty()){
			map.put("MESSAG","DATA NOT FOUND");
			map.put("STATUS",false);
		}else{
			map.put("MESSAG","DATA FOUND");
			map.put("STATUS",true);
			map.put("DATA",allproduct);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/product"},method= RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> saveProductTemporary(@RequestBody Products product){
		Map<String,Object> map = new HashMap<String, Object>();
		if(productserviceimplement.save(product)){
			map.put("MESSAG","INSERT SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","INSERT FAIL");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}*/
	
	@RequestMapping(value={"/api/product/{id}"},method= RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> deleteProductTemporary(@PathVariable("id") int id){
		Map<String,Object> map = new HashMap<String, Object>();
		if(productserviceimplement.remove(id)){
			map.put("MESSAG","REMOVE SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","REMOVE FAIL");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	/*@RequestMapping(value={"/product"},method= RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateProductTemporary(@RequestBody Products product){
		Map<String,Object> map = new HashMap<String, Object>();
		if(productserviceimplement.update(product)){
			map.put("MESSAG","UPDATE SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","UPDATE FAIL");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}*/
	
}
