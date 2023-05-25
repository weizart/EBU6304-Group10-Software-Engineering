package function;

import java.io.*;
import java.util.ArrayList;
import entity.Examwork;
import entity.Students;
import entity.Teachers;

/**
 * The type Function.
 */
public class Function {
    /**
     * The Array.
     */
    ArrayList<Examwork> array = new ArrayList<Examwork>();
    /**
     * The Texam.
     */
    ArrayList<Examwork> texam = new ArrayList<Examwork>();
    /**
     * The Tlist.
     */
    ArrayList<Teachers> tlist = new ArrayList<Teachers>();
    /**
     * The Slist.
     */
    ArrayList<Students> slist = new ArrayList<Students>();

    /**
     * Instantiates a new Function.
     */
    public Function() {
		this.read_examfile();
		this.read_teacherfile();
		this.read_studentfile();
	}
	private boolean read_examfile() {
		String t= null;
		try {
			File f = new File("./src/data/","Grades.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			array.clear();
			while((t = br.readLine())!=null) {
				String [] s = t.split("\\s+");
				Examwork exam = new Examwork(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
				array.add(exam);
				System.out.println("读取文件：");
				System.out.println(s[0]);
			}
			fr.close();
			br.close();
			return true;
		}catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

    /**
     * Write examfile boolean.
     *
     * @return the boolean
     */
    public boolean write_examfile() {
		FileWriter fw=null;
		BufferedWriter out=null;
		try {
			File f = new File("./src/data/","Grades.txt");
			fw = new FileWriter(f);
			out = new BufferedWriter(fw);
			for(int i=0;i<array.size();i++){
				String s=array.get(i).exam_fileString();
				System.out.println("写入数据：");
				System.out.println(s);//用来大概测试数据是否写入
				out.write(s);
				out.newLine();
				out.flush();
			}
			out.close();
			fw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

    /**
     * Find 1 int.
     *
     * @param e the e
     * @return the int
     */
//	通过考试名称寻找信息在数组中的位置，找到返回i,找不到返回-1；
	public int find1(String e) {
		for(int i = 0 ; i <array.size(); i++)
			if(array.get(i).geteName().contains(e))
				return i;
		return -1;
	}

    /**
     * Find 2 int.
     *
     * @param k the k
     * @return the int
     */
    public int find2(String k) {
		for(int i = 0 ; i <array.size(); i++)
			if(array.get(i).geteClass().contains(k))
				return i;
		return -2;
	}

    /**
     * Find 3 int.
     *
     * @param e the e
     * @return the int
     */
    public int find3(String e) {
		for(int i = 0 ; i <array.size(); i++)
			if(array.get(i).geteTime().contains(e))
				return i;
		return -3;
	}

    /**
     * Find 4 int.
     *
     * @param k the k
     * @return the int
     */
    public int find4(String k) {
		for(int i = 0 ; i <array.size(); i++)
			if(array.get(i).geteAddress().contains(k))
				return i;
		return -4;
	}

    /**
     * Add boolean.
     *
     * @param e the e
     * @return the boolean
     */
    public boolean add(Examwork e)  {
		System.out.println(e.exam_fileString());
		array.add(e);
		return true;
	}

    /**
     * Del exam boolean.
     *
     * @param s the s
     * @param e the e
     * @return the boolean
     */
    public boolean del_Exam(String s,String e)	{
		int pos1 = find1(s);
		int pos2 = find2(e);
		if (pos1==-1 || pos2==-2 )
			return false;
		if(pos1==pos2) {
			array.remove(pos1);
		}
		return true;
	}

    /**
     * Update.
     *
     * @param e the e
     */
    public void update(Examwork e) {
		int flag1 = find1(e.geteName());
		array.set(flag1, e);
		System.out.print(array.get(flag1).toString());
	}

    /**
     * Add teacher boolean.
     *
     * @param e the e
     * @return the boolean
     */
    public boolean addTeacher(Teachers e)  {
		System.out.println(e.fileTeaString());
		tlist.add(e);
		return true;
	}

    /**
     * Findteacher name int.
     *
     * @param e the e
     * @return the int
     */
    public int findteacherName(String e) {
		for(int i = 0 ; i <tlist.size(); i++)
			if(tlist.get(i).getteaName().contains(e))
				return i;
		return -1;
	}

    /**
     * Findteacher id int.
     *
     * @param e the e
     * @return the int
     */
    public int findteacherID(String e) {
		for(int i = 0 ; i <tlist.size(); i++)
			if(tlist.get(i).getteaID().contains(e))
				return i;
		return -2;
	}

    /**
     * Findteacher pow int.
     *
     * @param e the e
     * @return the int
     */
    public int findteacherPow(String e) {
		for(int i = 0 ; i <tlist.size(); i++)
			if(tlist.get(i).getteaPOW().contains(e))
				return i;
		return -3;
	}

    /**
     * Del tea boolean.
     *
     * @param s the s
     * @param e the e
     * @return the boolean
     */
    public boolean del_Tea(String s,String e)	{
		int pos1 = findteacherName(s);
		int pos2 = findteacherID(e);
		if (pos1==-1 || pos2==-2 )
			return false;
		if(pos1==pos2) {
			tlist.remove(pos1);
		}
		return true;
	}

    /**
     * Update 2.
     *
     * @param e the e
     */
    public void update2(Teachers e) {
		int flag1 = findteacherName(e.getteaName());
		tlist.set(flag1, e);
	}
	private boolean read_teacherfile() {
		String t= null;
		try {
			File f = new File("./src/data/","TeacherID.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			tlist.clear();
			while((t = br.readLine())!=null) {
				String [] s = t.split("\\s+");
				Teachers teachers = new Teachers(s[0],s[1],s[2]);
				tlist.add(teachers);
				System.out.println("读取文件：");
				System.out.println(s[0]);
			}
			fr.close();
			br.close();
			return true;
		}catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

    /**
     * Write teacherfile boolean.
     *
     * @return the boolean
     */
    public boolean write_teacherfile() {
		FileWriter fw=null;
		BufferedWriter out=null;
		try {
			File f = new File("./src/data/","TeacherID.txt");
			fw = new FileWriter(f);
			out = new BufferedWriter(fw);
			for(int i=0;i<tlist.size();i++){
				String s=tlist.get(i).fileTeaString();
				System.out.println("写入数据：");
				System.out.println(s);//用来大概测试数据是否写入
				out.write(s);
				out.newLine();
				out.flush();
			}
			out.close();
			fw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

    /**
     * Add student boolean.
     *
     * @param e the e
     * @return the boolean
     */
    public boolean addStudent(Students e)  {
		System.out.println(e.fileStuString());
		slist.add(e);
		return true;
	}

    /**
     * Find student name int.
     *
     * @param e the e
     * @return the int
     */
    public int findStudentName(String e) {
		for(int i = 0 ; i <slist.size(); i++) {
			if(slist.get(i).getstuName().contains(e))
				return i;
		}
		return -1;
	}

    /**
     * Findstudent id int.
     *
     * @param e the e
     * @return the int
     */
    public int findstudentID(String e) {
		for(int i = 0 ; i <slist.size(); i++) {
			if(slist.get(i).getstuID().contains(e))
				return i;
		}
		return -2;
	}

    /**
     * Findstudent pow int.
     *
     * @param e the e
     * @return the int
     */
    public int findstudentPow(String e) {
		for(int i = 0 ; i <slist.size(); i++)
			if(slist.get(i).getstuPOW().contains(e)) {
				return i;}
		return -3;
	}

    /**
     * Del stu boolean.
     *
     * @param s the s
     * @param e the e
     * @return the boolean
     */
    public boolean del_Stu(String s,String e)	{
		int pos1 = findStudentName(s);
		int pos2 = findstudentID(e);
		if (pos1==-1 || pos2==-2 )
			return false;
		if(pos1==pos2) {
			slist.remove(pos1);
		}
		return true;
	}

    /**
     * Update 3.
     *
     * @param e the e
     */
    public void update3(Students e) {
		int flag1 = findStudentName(e.getstuName());
		slist.set(flag1, e);
		System.out.print(slist.get(flag1).toString());
	}

    /**
     * Write studentfile boolean.
     *
     * @return the boolean
     */
    public boolean write_studentfile() {
		FileWriter fw=null;
		BufferedWriter out=null;
		try {
			File f = new File("./src/data/","StudentID.txt");
			fw = new FileWriter(f);
			out = new BufferedWriter(fw);
			for(int i=0;i<slist.size();i++){
				String s=slist.get(i).fileStuString();
				System.out.println("写入数据：");
				System.out.println(s);//用来大概测试数据是否写入
				out.write(s);
				out.newLine();
				out.flush();
			}
			out.close();
			fw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	private boolean read_studentfile() {
		String t= null;
		try {
			File f = new File("./src/data/","StudentID.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			slist.clear();
			while((t = br.readLine())!=null) {
				String [] s = t.split("\\s+");
				Students stu = new Students(s[0],s[1],s[2]);
				slist.add(stu);
				System.out.println("读取文件：");
				System.out.println(s[0]);
			}
			fr.close();
			br.close();
			return true;
		}catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

//	private boolean read_TIHUANfile() {
//		String t= null;
//		try {
//			FileReader fr = new FileReader("D:\\Java\\Java project\\Exam-system\\src\\申请替换文件.txt");
//			BufferedReader br = new BufferedReader(fr);
//			texam.clear();
//			while((t = br.readLine())!=null) {
//				String [] s = t.split("\\s+");
//				Examwork exam = new Examwork(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]); 
//				texam.add(exam);
//				System.out.println("读取文件：");
//				System.out.println(s[0]);
//			}
//			fr.close();
//			br.close();				     
//			return true;
//		}catch (IOException e) {
//			e.printStackTrace();
//			return false;
//		}	
//	}
//	/**
//	 * 将考试数据储存到txt文件中
//	 * @return true or false
//	 */
//	public boolean write_TIHUANfile() {
//		FileWriter fw=null;
//		BufferedWriter out=null;
//		try {
//			fw = new FileWriter("D:\\Java\\Java project\\Exam-system\\src\\申请替换文件.txt");    
//			out = new BufferedWriter(fw);
//			for(int i=0;i<texam.size();i++){
//				String s=texam.get(i).exam_fileString();
//				System.out.println("新写入数据：");
//				System.out.println(s);//用来大概测试数据是否写入
//				out.write(s);
//				out.newLine();
//				out.flush();
//			}
//			out.close();
//			fw.close();
//			return true;
//		} catch (IOException e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
}



