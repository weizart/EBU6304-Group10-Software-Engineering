package entity;

public class Students {
	private String stuName , stuID , stuPOW;
	public Students() {
		
	}
	public Students(String stuName , String stuID , String stuPOW )  {
		this.stuID = stuID;			//ѧ���˺�
		this.stuPOW = stuPOW;		//�˺�����
		this.stuName = stuName;		//ѧ������
		
	}
	public String getstuName() {
		return stuName;
	}
	public void setstuName(String stuName) {
		this.stuName = stuName;
	}
	
	public String getstuID() {
		return stuID;
	}
	public void setstuID(String stuID) { 
		this.stuID = stuID;
	}
	public String getstuPOW() {
		return stuPOW;
	}
	public void setstuPOW(String stuPOW) { 
		this.stuPOW = stuPOW;
	}
	
	public String fileStuString()
	{
		return  stuName + "		" + stuID + "		" + stuPOW; 
	}
}

