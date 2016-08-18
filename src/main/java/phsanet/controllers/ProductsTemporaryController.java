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

import phsanet.service.implement.ProductTemporaryImplement;
import phsanet.util.Paging;
import phsanet.util.ProductFilter;


@RestController
public class ProductsTemporaryController {
	@Autowired
	@Qualifier("producttemporaryimplement")
	private ProductTemporaryImplement producttemporaryimplement;
	
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
	
	
}
