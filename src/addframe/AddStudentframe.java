package addframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.Students;
import function.Function;
import function.judge;

public class AddStudentframe extends JFrame implements ActionListener {
	JPanel addPanel , text;
	JTextField stuPowerT,stuAccountT,stuNameT;
	final int t = 25; //输入框的长度
	JFrame stuframe;
	Function fun = new Function();
	judge judge = new judge();
	Students stu = new Students();
	ArrayList<Students> slist = new ArrayList<Students>();
	public AddStudentframe() {
		AddStudent();
	}
	void AddStudent() {
		stuframe = new JFrame();
		JLabel stuLabel = new JLabel();
		stuframe.setLayout(new BorderLayout());
		
		stuLabel = new JLabel("Add Student" , JLabel.CENTER);
		Font f=new Font("新宋体",Font.BOLD,30);
		stuLabel.setFont(f);
		stuLabel.setForeground(Color.blue);
		stuframe.add(stuLabel, BorderLayout.NORTH);
		stuframe.setTitle("Student Management");
		stuframe.setSize(990, 600);
		stuframe.setLocation(350, 200);
		stuframe.setLocationRelativeTo(null); //使窗口居中
		stuframe.setVisible(true);   
		addPanel = new JPanel();
		addPanel = addTeapanel();
		stuframe.add(addPanel, BorderLayout.CENTER);		
	}
	
	private JPanel addTeapanel() {
		// TODO Auto-generated method stub
		JPanel stutext = new JPanel();
		
		JPanel stuName = stuName();
		JPanel stuAccount = stuAccount();
		JPanel stuPower = stuPower();
		addPanel = addButtonPanel();
		stutext.setLayout(new GridLayout(4,1));
		stutext.add(stuName);
		stutext.add(stuAccount);
		stutext.add(stuPower);
		stutext.add(addPanel);
		return stutext;
	}
	
	private JPanel stuPower() {
		// TODO Auto-generated method stub
		JPanel stuPowerPanel = new JPanel();
		JLabel stuPowerLabel = new JLabel("Password:");
		Font f=new Font("新宋体",Font.BOLD,20);
		stuPowerLabel.setFont(f);
		stuPowerT = new JTextField(t);
		stuPowerPanel.add(stuPowerLabel);
		stuPowerPanel.add(stuPowerT);
		return stuPowerPanel;
	}
	private JPanel stuAccount() {
		// TODO Auto-generated method stub
		JPanel stuAccountpanel = new JPanel();
		JLabel stuAccountLabel = new JLabel("ID:");
		Font f=new Font("新宋体",Font.BOLD,20);
		stuAccountLabel.setFont(f);
		stuAccountT = new JTextField(t);
		stuAccountpanel.add(stuAccountLabel);
		stuAccountpanel.add(stuAccountT);
		return stuAccountpanel;
	}
	private JPanel stuName() {
		// TODO Auto-generated method stub
		JPanel namePanel = new JPanel();
		JLabel nameLabel = new JLabel("Name:");
		Font f=new Font("新宋体",Font.BOLD,20);
		nameLabel.setFont(f);
		stuNameT = new JTextField(t);
		namePanel.add(nameLabel);
		namePanel.add(stuNameT);
		return namePanel;
	}
	private JPanel addButtonPanel() {
		// TODO Auto-generated method stub
		JPanel addButtonPanel = new JPanel();
		JButton addButton = new JButton("Confirm");
		addButton.addActionListener(this);
		addButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String stuName = stuNameT.getText();
				String stuAccount = stuAccountT.getText();
				String stuPower = stuPowerT.getText(); 

				if(stuName.equals("") || stuAccount.equals("") || stuPower.equals("")) {
					JOptionPane.showMessageDialog(null, "学生信息有误！！！\n\n请重新输入！！！");
					return;
				}
				if(fun.findstudentID(stuAccount) == fun.findStudentName(stuName)) {
					JOptionPane.showMessageDialog(null,stuName+"该学生已有账号已存在！！！\n\n请重新录入！！！");
					System.out.print(fun.findteacherID(stuAccount)+"~"+fun.findteacherName(stuName));
					return;
				}
				if(fun.findstudentID(stuAccount) != -2 ) {
					JOptionPane.showMessageDialog(null,"该账号已存在！！！\n\n请重新录入！！！");
					System.out.print(fun.findteacherID(stuAccount));
					return;
				}
				stu.setstuName(stuName);
				stu.setstuID(stuAccount);
				stu.setstuPOW(stuPower);
				
				
				System.out.println("Admin");
				System.out.println(stu.fileStuString());
				fun.addStudent(stu);
				fun.write_studentfile();
	      		 
				JOptionPane.showMessageDialog(null, "录入成功！！！");
				stuframe.dispose();
			}
		});	
		addButtonPanel.add(addButton);
		return addButtonPanel;	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
	}
}
