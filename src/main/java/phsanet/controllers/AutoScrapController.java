package phsanet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import phsanet.entitys.Site_Detail_Managerment;
import phsanet.service.implement.ProductServiceImplement;
import phsanet.service.implement.SiteDetailManagermenetImplement;

@EnableScheduling
@Component
public class AutoScrapController {
	
	@Autowired
	@Qualifier("scrapmanagermenetimplement")
	private SiteDetailManagermenetImplement scrapmanagermenetimplement;
	
	@Autowired
	@Qualifier("productserviceimplement")
	private ProductServiceImplement productserviceimplement;
	
	//  It will run every hour of every day
	//@Scheduled(cron = "0 0 * * * *")
	//@Scheduled(cron="*/10 * * * * *")
	public void autoscrap(){
		System.out.println("RUNNING....");
		
		try{	
			for(Site_Detail_Managerment scrap :scrapmanagermenetimplement.findAll()){
				if(scrap.getStatus().toLowerCase().trim().compareTo("yes")==0){
					productserviceimplement.save(new ScrapingManagermentController()._scraping(scrap));
					//System.out.println("Product");
				}
			}	
		}catch(Exception ex){
			
			System.out.println("Error auto scrap "+ex.getMessage());
		}
	}
	
}
