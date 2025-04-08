package bean;

public class Subject implements java.io.Serializable {

	private int shoolCd;
	private int cd;
	private String name;

	public int getShoolCd() {
		return shoolCd;
	}
	public void setShoolCd(int shoolCd) {
		this.shoolCd = shoolCd;
	}
	public int getCd() {
		return cd;
	}
	public void setCd(int cd) {
		this.cd = cd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}
