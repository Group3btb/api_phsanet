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

import phsanet.entitys.Site_Detail_Managerment;
import phsanet.service.implement.SiteDetailManagermenetImplement;

@RestController
public class SiteDetailManagerment {
	
	@Autowired
	@Qualifier("scrapmanagermenetimplement")
	private SiteDetailManagermenetImplement scrapmanegermentimplement;
	
	@RequestMapping(value={"/api/sitedetail"},method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> saveScrap(@RequestBody Site_Detail_Managerment scrap){
		Map<String,Object> map = new HashMap<String,Object>();
		if(scrapmanegermentimplement.save(scrap)){
			map.put("MESSAG","SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","FAILD");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/sitedetail"},method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findAllScrap(){
		Map<String,Object> map = new HashMap<String, Object>();
		ArrayList<Site_Detail_Managerment> arr = new ArrayList<Site_Detail_Managerment>();
		arr = scrapmanegermentimplement.findAll();
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
	
	@RequestMapping(value={"/api/sitedetail"},method = RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updateScrap(@RequestBody Site_Detail_Managerment scrap){
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(scrapmanegermentimplement.update(scrap)){
			map.put("MESSAG","SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","FAILD");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/status"},method = RequestMethod.PUT)
	public ResponseEntity<Map<String,Object>> updatestatus(@RequestBody Site_Detail_Managerment scrap){
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(scrapmanegermentimplement.update_status(scrap)){
			map.put("MESSAG","SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","FAILD");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	
	@RequestMapping(value={"/api/sitedetail/{id}"}, method = RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> removeScrap(@PathVariable int id){
		Map<String,Object> map = new HashMap<String, Object>();
		if(scrapmanegermentimplement.remove(id)){
			map.put("MESSAG","SUCCESS");
			map.put("STATUS",true);
		}else{
			map.put("MESSAG","FAILD");
			map.put("STATUS",false);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value={"/api/sitedetail/{id}"},method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> searchScrap(@PathVariable("id") int id){
		
		ArrayList<Site_Detail_Managerment> arr = new ArrayList<Site_Detail_Managerment>();
		Map<String,Object> map = new HashMap<String, Object>();
		arr = scrapmanegermentimplement.search(id);
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
