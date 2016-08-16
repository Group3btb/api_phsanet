package phsanet.services;

import java.util.ArrayList;

import phsanet.entitys.Products;


public interface ProductTemporaryService {
	public boolean save(ArrayList<Products> products);
	public boolean remove(int id);
	public boolean update(Products product);
	public ArrayList<Products> findAll();
	public ArrayList<Products> search(String search);
}
