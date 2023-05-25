package entity;

/**
 * The type Students.
 */
public class Students {
	private String stuName , stuID , stuPOW;

    /**
     * Instantiates a new Students.
     */
    public Students() {

	}

    /**
     * Instantiates a new Students.
     *
     * @param stuName the stu name
     * @param stuID   the stu id
     * @param stuPOW  the stu pow
     */
    public Students(String stuName , String stuID , String stuPOW )  {
		this.stuID = stuID;			//学生账号
		this.stuPOW = stuPOW;		//账号密码
		this.stuName = stuName;		//学生姓名

	}

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getstuName() {
		return stuName;
	}

    /**
     * Sets name.
     *
     * @param stuName the stu name
     */
    public void setstuName(String stuName) {
		this.stuName = stuName;
	}

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getstuID() {
		return stuID;
	}

    /**
     * Sets id.
     *
     * @param stuID the stu id
     */
    public void setstuID(String stuID) {
		this.stuID = stuID;
	}

    /**
     * Gets pow.
     *
     * @return the pow
     */
    public String getstuPOW() {
		return stuPOW;
	}

    /**
     * Sets pow.
     *
     * @param stuPOW the stu pow
     */
    public void setstuPOW(String stuPOW) {
		this.stuPOW = stuPOW;
	}

    /**
     * File stu string string.
     *
     * @return the string
     */
    public String fileStuString()
	{
		return  stuName + "		" + stuID + "		" + stuPOW;
	}
}

