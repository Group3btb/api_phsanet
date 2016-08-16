package phsanet.service.implement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import phsanet.entitys.Products;
import phsanet.repositorys.ProductRepository;
import phsanet.services.ProductService;
import phsanet.util.Paging;
import phsanet.util.ProductFilter;

@Service
@Qualifier("productserviceimplement")
public class ProductServiceImplement implements ProductService {
	@Autowired
	@Qualifier("productrepository")
	private ProductRepository productrepository;
	@Override
	public ArrayList<Products> findAll(ProductFilter filter , Paging paging) {
		// TODO Auto-generated method stub
		paging.setTotalCount(productrepository.count(filter));
		return productrepository.findAll(filter,paging);
	}

	@Override
	public ArrayList<Products> search(String search) {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}

	@Override
	public boolean save(ArrayList<Products> product) {
		// TODO Auto-generated method stub
		return productrepository.save(product);
	}

	@Override
	public boolean update(Products product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return productrepository.remove(id);
	}

}
