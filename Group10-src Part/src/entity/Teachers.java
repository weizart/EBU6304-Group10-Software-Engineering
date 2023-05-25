package entity;

/**
 * The type Teachers.
 */
/*
 *	��ʦ���Եķ�װ
 *	1.��ʦ����
 *	2.��ʦID
 *	3.��ʦPOWER
 */
public class Teachers {
    /**
     * The Tea name.
     */
    public String teaName;	//��ʦ����
    /**
     * The Tea id.
     */
    public String teaID;	//��ʦID
    /**
     * The Tea pow.
     */
    public String teaPOW;	//��ʦPOWER

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
