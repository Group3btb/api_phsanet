package phsanet.services;

import java.util.ArrayList;

import phsanet.entitys.SaveList;

public interface SaveListService {
	public boolean save(SaveList savelist);
	public boolean update(SaveList savelist);
	public boolean remove(int id);
	public ArrayList<SaveList> findAll();
}
