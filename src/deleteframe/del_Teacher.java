package deleteframe;

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

import entity.Examwork;
import entity.Teachers;
import function.Function;
import function.judge;

public class del_Teacher extends JFrame implements ActionListener	{
	final int t = 25; //输入框的长度
	Function fun = new Function();
	Teachers tea = new Teachers();
	judge judge = new judge();
	ArrayList<Examwork> tList = new ArrayList<Examwork>();
	

	JFrame jf ;
	JLabel jl ;
	JPanel delPanel , text;
	JTextField nameT , IDT; 
	JButton delButton ;
	
	public del_Teacher() {
		createtitle();
	}
	 void createtitle() {
		jf = new JFrame();
		jf.setLayout(new BorderLayout());
		
		jl = new JLabel(" 删 除 教 师 信 息 " , JLabel.CENTER);
		Font f=new Font("新宋体",Font.BOLD,30);
		jl.setFont(f);
		jl.setForeground(Color.blue);
		jf.add(jl, BorderLayout.NORTH);
		jf.setTitle("教 师 信 息管理");
		jf.setSize(450, 220);
		jf.setLocation(350, 200);
		jf.setLocationRelativeTo(null); //使窗口居中
		jf.setVisible(true);   
		delPanel = new JPanel();
		delPanel = delpanel();
		jf.add(delPanel, BorderLayout.CENTER);		
	}
	private JPanel delpanel() {
		// TODO Auto-generated method stub
		text = new JPanel();
		
		JPanel nameT = namePanel();
		JPanel IDT = IDPanel();
		delPanel = delButtonPanel();
		text.setLayout(new GridLayout(3,1));
		text.add(nameT);
		text.add(IDT);
		text.add(delPanel);
		return text;
	}
	private JPanel namePanel() {
		// TODO Auto-generated method stub
		JPanel namePanel = new JPanel();
		JLabel nameLabel = new JLabel("教师姓名：");
		Font f=new Font("新宋体",Font.BOLD,20);
		nameLabel.setFont(f);
		nameT = new JTextField(t);
		namePanel.add(nameLabel);
		namePanel.add(nameT);
		return namePanel;
	}
	private JPanel IDPanel() {
		// TODO Auto-generated method stub
		JPanel IDPanel = new JPanel();
		JLabel IDLabel = new JLabel("教师账号：");
		Font f=new Font("新宋体",Font.BOLD,20);
		IDLabel.setFont(f);
		IDT = new JTextField(t);
		IDPanel.add(IDLabel);
		IDPanel.add(IDT);
		return IDPanel;
	}
	JPanel delButtonPanel() {
		JPanel delButtonPanel = new JPanel();
		delButton = new JButton("确认删除教师账号信息");
		delButton.addActionListener(this);
		delButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String tname = nameT.getText();
				String tid = IDT.getText();
				int flag1 =fun.findteacherName(tname);
				int flag2 =fun.findteacherID(tid);
				if(tname.equals("")||tid.equals("")) {
					JOptionPane.showMessageDialog(null, "考试信息为空！！！\n\n请重新输入！！！");
					return;
				}else if(flag1==-1||flag2==-1){
     			   JOptionPane.showMessageDialog(null, "未查找到该考试信息！！！\n\n请重新输入"); 
     			   return;
				}else {
					fun.del_Exam(tname,tid);
					Boolean t = fun.write_examfile();
					if(t==true) {
						JOptionPane.showMessageDialog(null, "删除成功！！！");
						jf.dispose();	
					}
					
				}
				
			}
		});	
		delButtonPanel.add(delButton);
		return delButtonPanel;	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}