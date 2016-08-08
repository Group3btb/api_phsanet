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

import phsanet.entitys.Web_Source;
import phsanet.service.implement.WebServiceImplement;

@RestController
public class WebSourceController {
	
	@Autowired
	@Qualifier("webserviceimplement")
	private WebServiceImplement webserviceimplement;
	@RequestMapping(value={"/api/web"}, method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findAllWeb(){
		ArrayList<Web_Source> allweb = new ArrayList<Web_Source>();
		Map<String,Object> map = new HashMap<String, Object>();
		allweb = webserviceimplement.findAll();
		if(allweb.isEmpty()){
			map.put("MESSAGE","DATA NOT FOUND");
			map.put("STATUS",false);
		}else{
			map.put("MESSAGE","DATA FOUND");
			map.put("STATUS",true);
			map.put("DATA",allweb);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/web"},method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> saveWeb(@RequestBody Web_Source web){
		Map<String,Object> map = new HashMap<String, Object>();
		System.out.println(web.toString());
		if(webserviceimplement.save(web)){
			map.put("MESSAG","INSERT SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","INSERT FAILD");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	@RequestMapping(value={"/api/web/{id}"}, method = RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> removeWeb(@PathVariable("id") int id){
		Map<String,Object> map = new HashMap<String, Object>();
		if(webserviceimplement.remove(id)){
			map.put("MESSAG","SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","FAILD");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	
	@RequestMapping(value={"/api/web"},method = RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateWeb(@RequestBody Web_Source web){
		Map<String,Object> map = new HashMap<String, Object>();
		if(webserviceimplement.update(web)){
			map.put("MESSAG","UPDATE SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","UPDATE FAILD");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/web/{search}"},method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> searchWeb(@PathVariable("search") String search){
		Map<String,Object> map = new HashMap<String, Object>();
		ArrayList<Web_Source> allweb = new ArrayList<Web_Source>();
		allweb = webserviceimplement.search(search);
		if(allweb.isEmpty()){
			map.put("MESSAGE","SEARCH NOT FOUND");
			map.put("STATUS",false);
		}else{
			map.put("MESSAGE","SEARCH FOUND");
			map.put("STATUS",true);
			map.put("DATA",allweb);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
}
