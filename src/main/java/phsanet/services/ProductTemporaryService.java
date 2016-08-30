package phsanet.services;

import java.util.ArrayList;

import phsanet.entitys.Products;
import phsanet.util.Paging;
import phsanet.util.ProductFilter;


public interface ProductTemporaryService {
	public boolean save(ArrayList<Products> products);
	public boolean remove(int id);
	public boolean update(Products product);
	public ArrayList<Products> findAll(ProductFilter filter,Paging pagin);
	public ArrayList<Products> search(String search);
	public Products find_into_product(int id);
	public boolean update_status(String  status , int id);
	public boolean removeall();
}
