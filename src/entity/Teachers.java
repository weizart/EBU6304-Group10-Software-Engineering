package entity;

/*
*	��ʦ���Եķ�װ
*	1.��ʦ����
*	2.��ʦID
*	3.��ʦPOWER
*/
public class Teachers {
	public String teaName;	//��ʦ����
	public String teaID;	//��ʦID	
	public String teaPOW;	//��ʦPOWER
	
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
