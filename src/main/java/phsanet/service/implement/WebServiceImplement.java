package phsanet.service.implement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import phsanet.entitys.Web_Source;
import phsanet.repositorys.WebRepository;
import phsanet.services.WebService;

@Repository
@Qualifier("webserviceimplement")
public class WebServiceImplement implements WebService {
	@Autowired
	@Qualifier("webrepository")
	private WebRepository webrepository;
	@Override
	public boolean save(Web_Source web) {
		// TODO Auto-generated method stub
		return webrepository.save(web);
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return webrepository.remove(id);
	}

	@Override
	public boolean update(Web_Source web) {
		// TODO Auto-generated method stub
		return webrepository.update(web);
	}

	@Override
	public ArrayList<Web_Source> findAll() {
		// TODO Auto-generated method stub
		return webrepository.findAll();
	}

	@Override
	public ArrayList<Web_Source> search(String search) {
		// TODO Auto-generated method stub
		return webrepository.search(search);
	}

}
