package phsanet.services;

import java.util.ArrayList;

import phsanet.entitys.Temporary_Item;

public interface ProductTemporaryService {
	public boolean save(Temporary_Item product);
	public boolean remove(int id);
	public boolean update(Temporary_Item product);
	public ArrayList<Temporary_Item> findAll();
	public ArrayList<Temporary_Item> search(String search);
}
