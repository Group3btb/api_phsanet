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

import phsanet.entitys.User;
import phsanet.service.implement.UserServiceImplement;

@RestController
public class UserController {
	@Autowired
	@Qualifier("userserviceimplement")
	private UserServiceImplement userserviceimplement;
	

	@RequestMapping(value={"/api/user"},method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findAllSubCategory(){
		Map<String,Object> map = new HashMap<String, Object>();
		ArrayList<User> allsub = new ArrayList<User>();
		allsub = userserviceimplement.findAll();
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
	
	@RequestMapping(value={"/api/user/{search}"} , method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>>searchSubCategory(@PathVariable("search") String search){
		Map<String,Object> map = new HashMap<String, Object>();
		ArrayList<User> arr = new ArrayList<User>();
		arr = userserviceimplement.search(search);
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
	
	@RequestMapping(value={"/api/user"} , method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> saveSubCategory(@RequestBody User user){
		Map<String,Object> map = new HashMap<String, Object>();
		if(userserviceimplement.save(user)){
			map.put("MESSAG","SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","FAILD");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/user/{id}"} , method = RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> removeSubCategory(@PathVariable int id){
		Map<String,Object> map = new HashMap<String, Object>();
		if(userserviceimplement.remove(id)){
			map.put("MESSAG","SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","FAILD");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/user"},method = RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateSubCategory(@RequestBody User user){
		Map<String,Object> map = new HashMap<String, Object>();
		if(userserviceimplement.update(user)){
			map.put("MESSAG","SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","FAILD");
			map.put("STATUS",false);
		}
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
}
