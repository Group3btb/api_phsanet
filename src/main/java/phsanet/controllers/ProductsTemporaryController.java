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

import phsanet.entitys.ProductTemporary;
import phsanet.service.implement.ProductTemporaryImplement;

@RestController
public class ProductsTemporaryController {
	@Autowired
	@Qualifier("producttemporaryimplement")
	private ProductTemporaryImplement producttemporaryimplement;
	
	@RequestMapping(value={"/producttemporary"},method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findAllProductsTemporary(){
		Map<String,Object> map = new HashMap<String,Object>();
		ArrayList<ProductTemporary> allproduct = new ArrayList<ProductTemporary>();
		allproduct = producttemporaryimplement.findAll();
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
	
	@RequestMapping(value={"/producttemporary/{search}"},method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> searchProductsTemporary(@PathVariable("search") String search){
		Map<String,Object> map = new HashMap<String,Object>();
		ArrayList<ProductTemporary> allproduct = new ArrayList<ProductTemporary>();
		allproduct = producttemporaryimplement.findAll();
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
	
	@RequestMapping(value={"/producttemporary"},method= RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> saveProductTemporary(@RequestBody ProductTemporary product){
		Map<String,Object> map = new HashMap<String, Object>();
		if(producttemporaryimplement.save(product)){
			map.put("MESSAG","INSERT SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","INSERT FAIL");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/producttemporary/{id}"},method= RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> deleteProductTemporary(@PathVariable("id") int id){
		Map<String,Object> map = new HashMap<String, Object>();
		if(producttemporaryimplement.remove(id)){
			map.put("MESSAG","REMOVE SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","REMOVE FAIL");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/producttemporary"},method= RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateProductTemporary(@RequestBody ProductTemporary product){
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
	
	
}
