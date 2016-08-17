package phsanet.service.implement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import phsanet.entitys.Site_Detail_Managerment;
import phsanet.repositorys.SiteDetailManagermentRepository;
import phsanet.services.SiteDetailMangermentService;

@Service
@Qualifier("scrapmanagermenetimplement")
public class SiteDetailManagermenetImplement implements SiteDetailMangermentService {
	
	@Autowired
	@Qualifier("Scrapmanagermentrepository")
	private SiteDetailManagermentRepository scrapmanagermentrepository;
	
	@Override
	public ArrayList<Site_Detail_Managerment> findAll() {
		return scrapmanagermentrepository.findAll();
	}

	@Override
	public boolean save(Site_Detail_Managerment scrap) {
		// TODO Auto-generated method stub
		return scrapmanagermentrepository.save(scrap);
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return scrapmanagermentrepository.remove(id);
	}

	@Override
	public boolean update(Site_Detail_Managerment scrap) {
		// TODO Auto-generated method stub
		return scrapmanagermentrepository.update(scrap);
	}

	@Override
	public ArrayList<Site_Detail_Managerment> search(int id) {
		// TODO Auto-generated method stub
		return scrapmanagermentrepository.search(id);
	}

	@Override
	public boolean update_status(Site_Detail_Managerment scrap) {
		// TODO Auto-generated method stub
		return scrapmanagermentrepository.update_status(scrap);
	}

}
