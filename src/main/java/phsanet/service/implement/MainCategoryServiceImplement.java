package phsanet.service.implement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import phsanet.entitys.MainCategory;
import phsanet.repositorys.MainCategoryRepository;
import phsanet.services.MainCategoryService;

@Service
@Qualifier("maincategoryimplement")
public class MainCategoryServiceImplement implements MainCategoryService {
	@Autowired
	@Qualifier("maincategoryrepository")
	private MainCategoryRepository maincategoryrepository;
	
	@Override
	public ArrayList<MainCategory> findAll() {
		return maincategoryrepository.findAll();
	}

	@Override
	public boolean save(MainCategory maincate) {
		return maincategoryrepository.save(maincate);
	}

	@Override
	public boolean update(MainCategory maincate) {
		// TODO Auto-generated method stub
		return maincategoryrepository.update(maincate);
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return maincategoryrepository.remove(id);
	}

	@Override
	public MainCategory findOne(int id) {
		// TODO Auto-generated method stub
		return maincategoryrepository.findOne(id);
	}

	@Override
	public ArrayList<MainCategory> search(String search) {
		// TODO Auto-generated method stub
		return maincategoryrepository.search(search);
	}

}
