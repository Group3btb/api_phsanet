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

import phsanet.entitys.SaveList;
import phsanet.service.implement.SaveListServiceImplement;

@RestController
public class SaveListController {
	@Autowired
	@Qualifier("saveListserviceimplement")
	private SaveListServiceImplement savelistimplement;
	@RequestMapping(value={"/savelist"},method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> saveCategory(@RequestBody SaveList savelist){
		
		System.out.println("Userid "+savelist.getUser().getUserid()+" Username "+savelist.getProduct().getProid());
		Map<String,Object> map = new HashMap<String,Object>();
		if(savelistimplement.save(savelist)){
			map.put("MESSAG","SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","FAIL");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/svaelist"},method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findAllCategory(){
		Map<String,Object> map = new HashMap<String, Object>();
		ArrayList<SaveList> arr = new ArrayList<SaveList>();
		arr = savelistimplement.findAll();
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
	
	@RequestMapping(value={"/savelist"},method = RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateCategory(@RequestBody SaveList savelist){
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(savelistimplement.update(savelist)){
			map.put("MESSAG","SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","FAIL");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/savelist/{id}"}, method = RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> removeCategory(@PathVariable int id){
		Map<String,Object> map = new HashMap<String, Object>();
		if(savelistimplement.remove(id)){
			map.put("MESSAG","SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","FAIL");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	
}
