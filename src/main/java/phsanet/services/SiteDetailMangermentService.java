package phsanet.services;

import java.util.ArrayList;

import phsanet.entitys.Site_Detail_Managerment;

public interface SiteDetailMangermentService {
	public ArrayList<Site_Detail_Managerment> findAll();
	public boolean save(Site_Detail_Managerment scrap);
	public boolean remove(int id);
	public boolean update(Site_Detail_Managerment scrap);
	public ArrayList<Site_Detail_Managerment> search(int id);
	public boolean update_status(Site_Detail_Managerment scrap);
}
