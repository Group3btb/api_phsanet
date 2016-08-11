package phsanet.services;

import java.util.ArrayList;

import phsanet.entitys.Scrap_Managerment;

public interface ScrapMangermentService {
	public ArrayList<Scrap_Managerment> findAll();
	public boolean save(Scrap_Managerment scrap);
	public boolean remove(int id);
	public boolean update(Scrap_Managerment scrap);
	public ArrayList<Scrap_Managerment> search(String search);
}
