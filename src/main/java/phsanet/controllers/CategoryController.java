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

import phsanet.entitys.Category;
import phsanet.service.implement.CategoryImplement;

@RestController
public class CategoryController {
	
	@Autowired
	@Qualifier("categoryimplement")
	private CategoryImplement categoryimplement;
	
	@RequestMapping(value={"/api/category"},method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> saveCategory(@RequestBody Category category){
		Map<String,Object> map = new HashMap<String,Object>();
		if(categoryimplement.save(category)){
			map.put("MESSAG","SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","FAILD");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/category"},method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findAllCategory(){
		Map<String,Object> map = new HashMap<String, Object>();
		ArrayList<Category> arr = new ArrayList<Category>();
		arr = categoryimplement.findAll();
		if(arr.isEmpty()){
			map.put("MESSAG","DATA NOT FOUND");
			map.put("STATUS",false);
		}else{
			map.put("MESSAG","DATA FOUND");
			map.put("STATUS",true);
			map.put("DATA",arr);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/category"},method = RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateCategory(@RequestBody Category category){
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(category);
		if(categoryimplement.update(category)){
			map.put("MESSAG","SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","FAILD");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/category/{id}"}, method = RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> removeCategory(@PathVariable int id){
		Map<String,Object> map = new HashMap<String, Object>();
		if(categoryimplement.remove(id)){
			map.put("MESSAG","SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","FAILD");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/category/{search}"},method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> searchCategory(@PathVariable("search") String search){
		
		ArrayList<Category> arr = new ArrayList<Category>();
		Map<String,Object> map = new HashMap<String, Object>();
		arr = categoryimplement.search(search);
		if(arr.isEmpty()){
			map.put("MESSAG","SEARCH NOT FOUND");
			map.put("STATUS",false);
		}else{
			map.put("MESSAG","SEARCH FOUND");
			map.put("STATUS",true);
			map.put("DATA",arr);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
}
