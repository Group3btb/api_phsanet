package phsanet.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import phsanet.entitys.listcategory.Main_Category;
import phsanet.service.implement.ListCategoryImplement;

@RestController
public class ListCategoryController {
	@Autowired
	@Qualifier("listcategoryimplement")
	private ListCategoryImplement listcategoryimplement;
	
	@RequestMapping(value={"api/listcategory"},method= RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> listcategory(){
		Map<String,Object> map = new HashMap<>();
		ArrayList<Main_Category> all = new ArrayList<>();
		all = listcategoryimplement.findall();
		if(all.isEmpty()){
			
		}else{
			map.put("MESSAGE","SUCCESS");
			map.put("STATUS",true);
			map.put("DATA",all);
		}
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
}
