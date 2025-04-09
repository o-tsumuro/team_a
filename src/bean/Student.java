package bean;

public class Student implements java.io.Serializable {

	private int no;
	private String name;
	private int entYear;
	private int classNum;
	private boolean isAttend;
	private String schoolCd;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEntYear() {
		return entYear;
	}

	public void setEntYear(int entYear) {
		this.entYear = entYear;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}

	public boolean isAttend() {
		return isAttend;
	}

	public void setAttend(boolean isAttend) {
		this.isAttend = isAttend;
	}

	public String getSchoolCd() {
		return schoolCd;
	}

	public void setSchoolCd(String schoolCd) {
		this.schoolCd = schoolCd;
	}

}
