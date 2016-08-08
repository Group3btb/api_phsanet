package phsanet.service.implement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import phsanet.entitys.Main_Category;
import phsanet.repositorys.MainCategoryRepository;
import phsanet.services.MainCategoryService;

@Service
@Qualifier("maincategoryimplement")
public class MainCategoryServiceImplement implements MainCategoryService {
	@Autowired
	@Qualifier("maincategoryrepository")
	private MainCategoryRepository maincategoryrepository;
	
	@Override
	public ArrayList<Main_Category> findAll() {
		return maincategoryrepository.findAll();
	}

	@Override
	public boolean save(Main_Category maincate) {
		return maincategoryrepository.save(maincate);
	}

	@Override
	public boolean update(Main_Category maincate) {
		// TODO Auto-generated method stub
		return maincategoryrepository.update(maincate);
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return maincategoryrepository.remove(id);
	}

	@Override
	public Main_Category findOne(int id) {
		// TODO Auto-generated method stub
		return maincategoryrepository.findOne(id);
	}

	@Override
	public ArrayList<Main_Category> search(String search) {
		// TODO Auto-generated method stub
		return maincategoryrepository.search(search);
	}

}
