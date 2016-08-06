package phsanet.services;

import java.util.ArrayList;

import phsanet.entitys.ProductTemporary;

public interface ProductTemporaryService {
	public boolean save(ProductTemporary product);
	public boolean remove(int id);
	public boolean update(ProductTemporary product);
	public ArrayList<ProductTemporary> findAll();
	public ArrayList<ProductTemporary> search(String search);
}
