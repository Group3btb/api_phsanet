package phsanet.service.implement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import phsanet.entitys.Scrap_Managerment;
import phsanet.repositorys.ScrapManagermentRepository;
import phsanet.services.ScrapMangermentService;

@Service
@Qualifier("scrapmanagermenetimplement")
public class ScrapManagermenetImplement implements ScrapMangermentService {
	
	@Autowired
	@Qualifier("Scrapmanagermentrepository")
	private ScrapManagermentRepository scrapmanagermentrepository;
	
	@Override
	public ArrayList<Scrap_Managerment> findAll() {
		return scrapmanagermentrepository.findAll();
	}

	@Override
	public boolean save(Scrap_Managerment scrap) {
		// TODO Auto-generated method stub
		return scrapmanagermentrepository.save(scrap);
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return scrapmanagermentrepository.remove(id);
	}

	@Override
	public boolean update(Scrap_Managerment scrap) {
		// TODO Auto-generated method stub
		return scrapmanagermentrepository.update(scrap);
	}

	@Override
	public ArrayList<Scrap_Managerment> search(String search) {
		// TODO Auto-generated method stub
		return scrapmanagermentrepository.search(search);
	}

}
