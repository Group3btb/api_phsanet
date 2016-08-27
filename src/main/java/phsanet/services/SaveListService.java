package phsanet.services;

import java.util.ArrayList;

import phsanet.entitys.Save_List;

public interface SaveListService {
	public boolean save(Save_List savelist);
	public boolean update(Save_List savelist);
	public boolean remove(int id);
	public ArrayList<Save_List> findAll(int user_id);
}
