package phsanet.services;

import java.util.ArrayList;

import phsanet.entitys.Webs;

public interface WebService {
	public boolean save(Webs web);
	public boolean remove(int id);
	public boolean update(Webs web);
	public ArrayList<Webs> findAll();
	public ArrayList<Webs> search(String search);
}
