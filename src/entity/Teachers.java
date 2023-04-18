package entity;

/*
*	教师属性的封装
*	1.教师姓名
*	2.教师ID
*	3.教师POWER
*/
public class Teachers {
	public String teaName;	//教师姓名
	public String teaID;	//教师ID	
	public String teaPOW;	//教师POWER
	
	public Teachers() {
		
	}
	public Teachers(String teaName , String teaID , String teaPOW)  {
		this.teaID = teaID;
		this.teaPOW = teaPOW;
		this.teaName = teaName;
	}

	public String getteaName() {
		return teaName;
	}
	public void setteaName(String teaName) { 
		this.teaName = teaName;
	}
	public String getteaID() {
		return teaID;
	}
	public void setteaID(String teaID) { 
		this.teaID = teaID;
	}
	public String getteaPOW() {
		return teaPOW;
	}
	public void setteaPOW(String teaPOW) { 
		this.teaPOW = teaPOW;
	}
	public String fileTeaString()
	{
		return teaName + "		" + teaID + "		" + teaPOW; 
	}
}
