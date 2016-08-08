package phsanet.service.implement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import phsanet.entitys.Temporary_Item;
import phsanet.repositorys.ProductTemporaryRepository;
import phsanet.services.ProductTemporaryService;

@Service
@Qualifier("producttemporaryimplement")
public class ProductTemporaryImplement implements ProductTemporaryService {

	@Autowired
	@Qualifier("proudcttemporaryrepository")
	private ProductTemporaryRepository producttemporaryrepository;
	@Override
	public boolean save(Temporary_Item product) {
		// TODO Auto-generated method stub
		return producttemporaryrepository.save(product);
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return producttemporaryrepository.remove(id);
	}

	@Override
	public boolean update(Temporary_Item product) {
		// TODO Auto-generated method stub
		return producttemporaryrepository.update(product);
	}

	@Override
	public ArrayList<Temporary_Item> findAll() {
		// TODO Auto-generated method stub
		return producttemporaryrepository.findAll();
	}

	@Override
	public ArrayList<Temporary_Item> search(String search) {
		return producttemporaryrepository.search(search);
	}

}
