package phsanet.entitys;

public class MainCategory {
	private int maincateid;
	private String maincatename;
	private String describe;
	public MainCategory(){
		
	}
	public MainCategory(int maincateid,String maincatename,String describe){
		this.maincateid = maincateid;
		this.maincatename = maincatename;
		this.describe = describe;
	}
	public int getMaincateid() {
		return maincateid;
	}
	public void setMaincateid(int maincateid) {
		this.maincateid = maincateid;
	}
	public String getMaincatename() {
		return maincatename;
	}
	public void setMaincatename(String maincatename) {
		this.maincatename = maincatename;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
}
