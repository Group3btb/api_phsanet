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
import phsanet.entitys.Main_Category;
import phsanet.service.implement.MainCategoryServiceImplement;

@RestController
public class MainCategoryController {
	@Autowired
	@Qualifier("maincategoryimplement")
	private MainCategoryServiceImplement mainCategoryServiceImplement;
	
	@RequestMapping(value={"/api/maincategory"} , method = RequestMethod.GET)
	
	public ResponseEntity<Map<String,Object>> findAllMainCategory(){
		Map<String,Object> map = new HashMap<String, Object>();
		ArrayList<Main_Category> maincate = new ArrayList<Main_Category>();
		maincate = mainCategoryServiceImplement.findAll();
		if(maincate.isEmpty()){
			map.put("MESSAGE","DATA NOT FOUND");
			map.put("STATUS",false);
		}else{
			map.put("MESSAGE","DATA FOUND");
			map.put("STATUS",true);
			map.put("DATA",maincate);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/maincategory/{search}"} , method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> searchMaincategory(@PathVariable("search") String search){
		Map<String,Object> map = new HashMap<String, Object>();
		ArrayList<Main_Category> main = mainCategoryServiceImplement.search(search);
		if(main.isEmpty()){
			map.put("MESSAGE","DATA NOT FOUND");
			map.put("STATUS",false);
			
		}else{
			map.put("MESSAGE","DATA FOUND");
			map.put("STATUS",true);
			map.put("DATA",main);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/maincategory/{id}"},method = RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> deleteMainCategory(@PathVariable("id") int id){
		Map<String,Object> map = new HashMap<String, Object>();
		System.out.println("ID "+id);
		if(mainCategoryServiceImplement.remove(id)){
			map.put("MESSAGE","DELETE SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAGE","DELETE FAILD");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/maincategory"} , method= RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateMainCategory(@RequestBody Main_Category maincate){
		
		Map<String,Object> map = new HashMap<String, Object>();
		if(mainCategoryServiceImplement.update(maincate)){
			map.put("MESSAGE","UPDATE SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAGE","UPDATE FAILD");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/maincategory"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> saveMainCategory(@RequestBody Main_Category maincate){
		Map<String,Object> map = new HashMap<String,Object>();
		if(mainCategoryServiceImplement.save(maincate)){
			map.put("MESSAGE","SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAGE","FAILD");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);	
	}
	
/*	@RequestMapping(value={"/maincategory"},method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> searchMainCategory(@RequestBody String search){
		System.out.println("search "+search);
		Map<String,Object> map = new HashMap<String,Object>();
		if(mainCategoryServiceImplement.search(search).isEmpty()){
			map.put("MESSAGE","SEARCH NOT FOUND");
			map.put("STATUS",false);
		}else{
			map.put("MESSAGE","DATA");
			map.put("STATUS",true);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	*/
}
