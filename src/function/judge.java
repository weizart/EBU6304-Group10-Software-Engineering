package function;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Pattern;

import entity.Examwork;

//�ж���

public class judge {
	ArrayList<Examwork> array = new ArrayList<Examwork>();
	/**
	 * �����ڵĸ�ʽ�����ж�
	 * 
	 * @param Day
	 * @return convertSuccess
	 */
	public boolean JudgeDay(String Day) {
		boolean convertSuccess=true;
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format3 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format4 = new SimpleDateFormat("yyyy-MM-dd");
        try {
        	format1.setLenient(false);
        	format1.parse(Day);
        	format2.setLenient(false);
        	format2.parse(Day);
        	format3.setLenient(false);
        	format3.parse(Day);
        	format4.setLenient(false);
        	format4.parse(Day);
        }catch (ParseException e) {
        	// TODO: handle exception
        	// e.printStackTrace();
        	// ���throw java.text.ParseException����NullPointerException����˵����ʽ����
        	convertSuccess=false;
		}
		return convertSuccess;	
		
	}
	
	/**
	 * ��������ʽ�ж�ʱ���ʽ�Ƿ���ȷ
	 * @param time
	 * @return	isTime
	 */
	public boolean JudgeTime(String time) {
		String pattern ="([01]?[0-9]|2[0-3])(\\:|\\��)[0-5][0-9](\\-|\\-)([01]?[0-9]|2[0-3])(\\:|\\��)[0-5][0-9]";
		boolean isTime = Pattern.matches(pattern,time);
		return isTime;	
	}
}



