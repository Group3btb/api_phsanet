package phsanet.service.implement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import phsanet.entitys.SaveList;
import phsanet.repositorys.SaveListRepository;
import phsanet.services.SaveListService;

@Service
@Qualifier("saveListserviceimplement")
public class SaveListServiceImplement implements SaveListService {
	@Autowired
	@Qualifier("saveListrepository")
	private SaveListRepository savelistrepository;
	@Override
	public boolean save(SaveList savelist) {
		// TODO Auto-generated method stub
		return savelistrepository.save(savelist);
	}

	@Override
	public boolean update(SaveList savelist) {
		// TODO Auto-generated method stub
		return savelistrepository.update(savelist);
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return savelistrepository.delete(id);
	}

	@Override
	public ArrayList<SaveList> findAll() {
		// TODO Auto-generated method stub
		return savelistrepository.findAll();
	}

}
