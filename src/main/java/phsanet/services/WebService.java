package phsanet.services;

import java.util.ArrayList;

import phsanet.entitys.Web_Source;

public interface WebService {
	public boolean save(Web_Source web);
	public boolean remove(int id);
	public boolean update(Web_Source web);
	public ArrayList<Web_Source> findAll();
	public ArrayList<Web_Source> search(String search);
}
