package phsanet.services;

import java.util.ArrayList;

import phsanet.entitys.Products;
import phsanet.util.Paging;
import phsanet.util.ProductFilter;

public interface ProductService {
	public ArrayList<Products> findAll(ProductFilter filter , Paging pagin);
	public ArrayList<Products> search(String search);
	public boolean save(Products product);
	public boolean update(Products product);
	public boolean remove(int id);
}
