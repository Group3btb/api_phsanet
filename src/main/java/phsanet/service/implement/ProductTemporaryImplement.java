package phsanet.service.implement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import phsanet.entitys.Products;
import phsanet.repositorys.ProductTemporaryRepository;
import phsanet.services.ProductTemporaryService;
import phsanet.util.Paging;
import phsanet.util.ProductFilter;

@Service
@Qualifier("producttemporaryimplement")
public class ProductTemporaryImplement implements ProductTemporaryService {

	@Autowired
	@Qualifier("proudcttemporaryrepository")
	private ProductTemporaryRepository producttemporaryrepository;
	
	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return producttemporaryrepository.remove(id);
	}

	@Override
	public boolean update(Products product) {
		// TODO Auto-generated method stub
		return producttemporaryrepository.update(product);
	}

	@Override
	public ArrayList<Products> findAll(ProductFilter filter,Paging paging) {
		// TODO Auto-generated method stub
		paging.setLimit((int) producttemporaryrepository.count(filter));
		return producttemporaryrepository.findAll(filter,paging);
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

	@Override
	public Products find_into_product(int id) {
		// TODO Auto-generated method stub
		//System.out.println(producttemporaryrepository.find_into_product(id));
		return producttemporaryrepository.find_into_product(id);
	}

	@Override
	public boolean update_status( String status,int id) {
		// TODO Auto-generated method stub
		return producttemporaryrepository.update_status(status,id);
	}

}
