package entity;
public class Examwork {
	private String eTime;  
	private String eName;
	private String eClass;
	private String eRenShu;
	private String eAddress;
	private String eKCRenShu;
	private String eTeacher_1;
	private String eTeacher_2;
	private String eZhuKao;
	
	/*无参构造方法 */
	public Examwork() {	
	}
	
	/*有参构造方法 */
	public Examwork( String examTime , String examName ,
			String examClass , String examRenShu , String examAddress , 
			String examKCRenShu ,String examTeacher_1 , String examTeacher_2 , String examZhuKao) {

		this.eTime = examTime;
		this.eName = examName;
		this.eClass = examClass;
		this.eKCRenShu = examRenShu;
		this.eAddress = examAddress;
		this.eRenShu = examKCRenShu;
		this.eTeacher_1 = examTeacher_1;
		this.eTeacher_2 = examTeacher_2;
		this.eZhuKao = examZhuKao;
	}
	
	//考试时间
	public String geteTime () {
		return eTime ;
	}
	public void seteTime(String examTime) {
		this.eTime = examTime;
	}
	
	//课程名称
	public String geteName () {
		return eName;
	}
	public void seteName(String examName) {
		this.eName = examName;
	}
	
	//考试班级
	public String geteClass () {
		return eClass;
	}
	public void seteClass(String examClass) {
		this.eClass = examClass;
	}
	
	//考试人数
	public String geteRenShu() {
		return eRenShu;
	}
	public void seteRenShu(String examRenShu) {
		this.eRenShu = examRenShu;
	}
	
	//考试地点
	public String geteAddress () {
		return eAddress;
	}
	public void seteAddress(String examAddress) {
		this.eAddress = examAddress;
	}
	
	//考场人数
	public String geteKCRenShu() {
		return eKCRenShu;
	}
	public void setkaochangrenshu(String examKCRenShu) {
		this.eKCRenShu = examKCRenShu;
	}
	//监考1
	public String geteTeacher_1 () {
		return eTeacher_1;
	}
	public void seteTeacher_1(String examTeacher_1) {
		this.eTeacher_1 = examTeacher_1;
	}
	
	//监考2
	public String geteTeacher_2 () {
		return eTeacher_2;
	}
	public void seteTeacher_2(String examTeacher_2) {
		this.eTeacher_2 = examTeacher_2;
	}
	
	//主考
	public String geteZhuKao () {
		return eZhuKao ;
	}
	public void seteZhuKao(String examZhuKao) {
		this.eZhuKao = examZhuKao;
	}
	
	//从文件中录入的数据格式	考试序号， 考试时间，考试名称，考试班级，考试人数，考试地点，考场人数，监考官1，监考2，主考官  
    public String exam_fileString()
	{
		return eTime+"		"+eName+"		"+eClass+"		"+eKCRenShu+"		"+eAddress
				+"		"+eRenShu+"		"+eTeacher_1+"		"+eTeacher_2+"		"+eZhuKao;
	}

}




