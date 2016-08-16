package phsanet.service.implement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import phsanet.entitys.Products;
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
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Products product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Products> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public boolean save(ArrayList<Products> products) {
		// TODO Auto-generated method stub
		return producttemporaryrepository.save(products);
	}

	@Override
	public ArrayList<Products> search(String search) {
		// TODO Auto-generated method stub
		return null;
	}

}
