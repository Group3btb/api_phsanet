package phsanet.service.implement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import phsanet.entitys.listcategory.Main_Category;
import phsanet.repositorys.ListCategoryRepository;
import phsanet.services.ListCategoryService;


@Service
@Qualifier("listcategoryimplement")
public class ListCategoryImplement implements  ListCategoryService {
  
	@Autowired
	@Qualifier("listcategoryrepository")
	private ListCategoryRepository listcategoryrepository;
	@Override
	public ArrayList<Main_Category> findall() {
		// TODO Auto-generated method stub
		return listcategoryrepository.findallmaincategory();
	}
	
	

}
