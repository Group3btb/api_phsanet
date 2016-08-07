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

import phsanet.entitys.SubCategory;
import phsanet.service.implement.SubCategoryServiceImplement;

@RestController
public class SubCategoryController {
	
	@Autowired
	@Qualifier("subcategoryserviceimplement")
	private SubCategoryServiceImplement subcategory;
	
	@RequestMapping(value={"/api/subcategory"},method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findAllSubCategory(){
		Map<String,Object> map = new HashMap<String, Object>();
		ArrayList<SubCategory> allsub = new ArrayList<SubCategory>();
		allsub = subcategory.findAll();
		if(allsub.isEmpty()){
			map.put("MESSAG","DATA NOT FOUND!");
			map.put("STATUS",false);
		}else{
			map.put("MESSAG","DATA FOUND!");
			map.put("STATUS",true);
			map.put("DATA",allsub);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/subcategory/{search}"} , method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findOneSubCategory(@PathVariable("search") String search){
		Map<String,Object> map = new HashMap<String, Object>();
		ArrayList<SubCategory> arr = new ArrayList<SubCategory>();
		arr = subcategory.search(search);
		if(arr.isEmpty()){
			map.put("MESSAG","DATA NOT FOUND!");
			map.put("STATUS",false);
		}else{
			map.put("MESSAG","DATA FOUND!");
			map.put("STATUS",true);
			map.put("DATA",arr);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/subcategory"} , method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> saveSubCategory(@RequestBody SubCategory subcate){
		Map<String,Object> map = new HashMap<String, Object>();
		if(subcategory.save(subcate)){
			map.put("MESSAG","SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","FAILD");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/subcategory/{id}"} , method = RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> removeSubCategory(@PathVariable int id){
		Map<String,Object> map = new HashMap<String, Object>();
		if(subcategory.remove(id)){
			map.put("MESSAG","SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","FAILD");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/subcategory"},method = RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateSubCategory(@RequestBody SubCategory subcate){
		Map<String,Object> map = new HashMap<String, Object>();
		if(subcategory.update(subcate)){
			map.put("MESSAG","SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","FAIL");
			map.put("STATUS",false);
		}
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
}
