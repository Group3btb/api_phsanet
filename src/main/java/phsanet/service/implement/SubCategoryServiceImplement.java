package phsanet.service.implement;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import phsanet.entitys.SubCategory;
import phsanet.repositorys.SubCategoryRepository;
import phsanet.services.SubCategoryService;

@Service
@Qualifier("subcategoryserviceimplement")
public class SubCategoryServiceImplement  implements SubCategoryService  {

	@Autowired
	@Qualifier("subcategoryrepository")
	private SubCategoryRepository subcategoryrepository;
	@Override
	public boolean save(SubCategory subcategory) {
		// TODO Auto-generated method stub
		return subcategoryrepository.save(subcategory);
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return subcategoryrepository.remove(id);
	}

	@Override
	public boolean update(SubCategory subcategory) {
		// TODO Auto-generated method stub
		return subcategoryrepository.update(subcategory);
	}

	@Override
	public ArrayList<SubCategory> findAll() {
		// TODO Auto-generated method stub
		return subcategoryrepository.findAll();
	}

	@Override
	public ArrayList<SubCategory> search(String search) {
		// TODO Auto-generated method stub
		return subcategoryrepository.search(search);
	}

}
