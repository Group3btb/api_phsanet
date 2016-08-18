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
}
