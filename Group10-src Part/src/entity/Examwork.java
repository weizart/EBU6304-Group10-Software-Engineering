package entity;

/**
 * The type Examwork.
 */
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

    /**
     * Instantiates a new Examwork.
     */
    /*无参构造方法 */
	public Examwork() {
	}

    /**
     * Instantiates a new Examwork.
     *
     * @param examTime      the exam time
     * @param examName      the exam name
     * @param examClass     the exam class
     * @param examRenShu    the exam ren shu
     * @param examAddress   the exam address
     * @param examKCRenShu  the exam kc ren shu
     * @param examTeacher_1 the exam teacher 1
     * @param examTeacher_2 the exam teacher 2
     * @param examZhuKao    the exam zhu kao
     */
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

    /**
     * Gets time.
     *
     * @return the time
     */
//考试时间
	public String geteTime () {
		return eTime ;
	}

    /**
     * Sets time.
     *
     * @param examTime the exam time
     */
    public void seteTime(String examTime) {
		this.eTime = examTime;
	}

    /**
     * Gets name.
     *
     * @return the name
     */
//课程名称
	public String geteName () {
		return eName;
	}

    /**
     * Sets name.
     *
     * @param examName the exam name
     */
    public void seteName(String examName) {
		this.eName = examName;
	}

    /**
     * Gets class.
     *
     * @return the class
     */
//考试班级
	public String geteClass () {
		return eClass;
	}

    /**
     * Sets class.
     *
     * @param examClass the exam class
     */
    public void seteClass(String examClass) {
		this.eClass = examClass;
	}

    /**
     * Gets ren shu.
     *
     * @return the ren shu
     */
//考试人数
	public String geteRenShu() {
		return eRenShu;
	}

    /**
     * Sets ren shu.
     *
     * @param examRenShu the exam ren shu
     */
    public void seteRenShu(String examRenShu) {
		this.eRenShu = examRenShu;
	}

    /**
     * Gets address.
     *
     * @return the address
     */
//考试地点
	public String geteAddress () {
		return eAddress;
	}

    /**
     * Sets address.
     *
     * @param examAddress the exam address
     */
    public void seteAddress(String examAddress) {
		this.eAddress = examAddress;
	}

    /**
     * Gets kc ren shu.
     *
     * @return the kc ren shu
     */
//考场人数
	public String geteKCRenShu() {
		return eKCRenShu;
	}

    /**
     * Sets .
     *
     * @param examKCRenShu the exam kc ren shu
     */
    public void setkaochangrenshu(String examKCRenShu) {
		this.eKCRenShu = examKCRenShu;
	}

    /**
     * Gets teacher 1.
     *
     * @return the teacher 1
     */
//监考1
	public String geteTeacher_1 () {
		return eTeacher_1;
	}

    /**
     * Sets teacher 1.
     *
     * @param examTeacher_1 the exam teacher 1
     */
    public void seteTeacher_1(String examTeacher_1) {
		this.eTeacher_1 = examTeacher_1;
	}

    /**
     * Gets teacher 2.
     *
     * @return the teacher 2
     */
//监考2
	public String geteTeacher_2 () {
		return eTeacher_2;
	}

    /**
     * Sets teacher 2.
     *
     * @param examTeacher_2 the exam teacher 2
     */
    public void seteTeacher_2(String examTeacher_2) {
		this.eTeacher_2 = examTeacher_2;
	}

    /**
     * Gets zhu kao.
     *
     * @return the zhu kao
     */
//主考
	public String geteZhuKao () {
		return eZhuKao ;
	}

    /**
     * Sets zhu kao.
     *
     * @param examZhuKao the exam zhu kao
     */
    public void seteZhuKao(String examZhuKao) {
		this.eZhuKao = examZhuKao;
	}

    /**
     * Exam file string string.
     *
     * @return the string
     */
//从文件中录入的数据格式	考试序号， 考试时间，考试名称，考试班级，考试人数，考试地点，考场人数，监考官1，监考2，主考官
	public String exam_fileString()
	{
		return eTime+"		"+eName+"		"+eClass+"		"+eKCRenShu+"		"+eAddress
				+"		"+eRenShu+"		"+eTeacher_1+"		"+eTeacher_2+"		"+eZhuKao;
	}

}




