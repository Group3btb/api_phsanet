package phsanet.service.implement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import phsanet.entitys.Webs;
import phsanet.repositorys.WebRepository;
import phsanet.services.WebService;

@Repository
@Qualifier("webserviceimplement")
public class WebServiceImplement implements WebService {
	@Autowired
	@Qualifier("webrepository")
	private WebRepository webrepository;
	@Override
	public boolean save(Webs web) {
		// TODO Auto-generated method stub
		return webrepository.save(web);
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return webrepository.remove(id);
	}

	@Override
	public boolean update(Webs web) {
		// TODO Auto-generated method stub
		return webrepository.update(web);
	}

	@Override
	public ArrayList<Webs> findAll() {
		// TODO Auto-generated method stub
		return webrepository.findAll();
	}

	@Override
	public ArrayList<Webs> search(String search) {
		// TODO Auto-generated method stub
		return webrepository.search(search);
	}

}
