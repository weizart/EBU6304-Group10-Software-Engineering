package entity;

/**
 * The type Teachers.
 */
/*
 *	教师属性的封装
 *	1.教师姓名
 *	2.教师ID
 *	3.教师POWER
 */
public class Teachers {
    /**
     * The Tea name.
     */
    public String teaName;	//教师姓名
    /**
     * The Tea id.
     */
    public String teaID;	//教师ID
    /**
     * The Tea pow.
     */
    public String teaPOW;	//教师POWER

    /**
     * Instantiates a new Teachers.
     */
    public Teachers() {

	}

    /**
     * Instantiates a new Teachers.
     *
     * @param teaName the tea name
     * @param teaID   the tea id
     * @param teaPOW  the tea pow
     */
    public Teachers(String teaName , String teaID , String teaPOW)  {
		this.teaID = teaID;
		this.teaPOW = teaPOW;
		this.teaName = teaName;
	}

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getteaName() {
		return teaName;
	}

    /**
     * Sets name.
     *
     * @param teaName the tea name
     */
    public void setteaName(String teaName) {
		this.teaName = teaName;
	}

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getteaID() {
		return teaID;
	}

    /**
     * Sets id.
     *
     * @param teaID the tea id
     */
    public void setteaID(String teaID) {
		this.teaID = teaID;
	}

    /**
     * Gets pow.
     *
     * @return the pow
     */
    public String getteaPOW() {
		return teaPOW;
	}

    /**
     * Sets pow.
     *
     * @param teaPOW the tea pow
     */
    public void setteaPOW(String teaPOW) {
		this.teaPOW = teaPOW;
	}

    /**
     * File tea string string.
     *
     * @return the string
     */
    public String fileTeaString()
	{
		return teaName + "		" + teaID + "		" + teaPOW;
	}
}
