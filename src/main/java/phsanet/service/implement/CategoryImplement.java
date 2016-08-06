package phsanet.service.implement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import phsanet.entitys.Category;
import phsanet.repositorys.CategoryRepository;
import phsanet.services.CategoryService;

@Service
@Qualifier("categoryimplement")
public class CategoryImplement implements CategoryService {
	@Autowired
	@Qualifier("categoryrepository")
	private CategoryRepository categoryrepository;

	@Override
	public ArrayList<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryrepository.findALL();
	}

	@Override
	public boolean save(Category category) {
		return categoryrepository.save(category);
	}

	@Override
	public boolean update(Category category) {
		// TODO Auto-generated method stub
		return categoryrepository.update(category);
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return categoryrepository.remove(id);
	}

	@Override
	public ArrayList<Category> search(String search) {
		// TODO Auto-generated method stub
		return categoryrepository.search(search);
	}

}
