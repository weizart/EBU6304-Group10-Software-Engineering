package reviseframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.Teachers;
import function.Function;
import function.judge;

/**
 * 修改教师账号信息
 * @author ASUS
 *
 */
public class Revise_Teacher extends JFrame implements ActionListener {
	final int t = 25; //输入框的长度
	
	Function fun = new Function();
	Teachers tea = new Teachers();
	judge judge = new judge();
	ArrayList<Teachers> tlist = new ArrayList<Teachers>();
	JFrame jf ;
	JLabel jl ;
	JPanel addPanel , text;
	JComboBox<String> cmb1,cmb2;
//	创建textPanel-窗口
	JTextField nameT , idT , powT ,NewidT , NewpowT; 
	JButton addButton ;
	
	public Revise_Teacher() {
		createtitle();
	}
	void createtitle() {
		jf = new JFrame();
		jf.setLayout(new BorderLayout());
		
		jl = new JLabel(" 修 改 教 师 账 号 信 息  " , JLabel.CENTER);
		Font f=new Font("新宋体",Font.BOLD,30);
		jl.setFont(f);
		jl.setForeground(Color.blue);
		jf.add(jl, BorderLayout.NORTH);
		jf.setTitle("教师账号管理");
		jf.setSize(990, 600);
		jf.setLocation(350, 200);
		jf.setLocationRelativeTo(null); //使窗口居中
		jf.setVisible(true);   
		addPanel = new JPanel();
		addPanel = addpanel();
		jf.add(addPanel, BorderLayout.CENTER);		
	}
	private JPanel addpanel() {
		text = new JPanel();	
		JPanel nameT = namePanel();
		JPanel idT = idT();
		JPanel powT = powT();
		JPanel newid = NewidT();
		JPanel newpow = NewpowT();
		addPanel = addButtonPanel();
		text.setLayout(new GridLayout(6,1));
		text.add(nameT);
		text.add(idT);
		text.add(newid);
		text.add(newpow);
		text.add(addPanel);
		return text;
	}
	private JPanel idT() {
		// TODO Auto-generated method stub
		JPanel idPanel = new JPanel();
		JLabel idLabel = new JLabel("旧教师账号：");
		Font f=new Font("新宋体",Font.BOLD,20);
		idLabel.setFont(f);
		idT = new JTextField(t);
		idPanel.add(idLabel);
		idPanel.add(idT);
		return idPanel;
	}
	private JPanel powT() {
		// TODO Auto-generated method stub
		JPanel powPanel = new JPanel();
		JLabel powLabel = new JLabel("旧账号密码：");
		Font f=new Font("新宋体",Font.BOLD,20);
		powLabel.setFont(f);
		powT = new JTextField(t);
		powPanel.add(powLabel);
		powPanel.add(powT);
		return powPanel;
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
	private JPanel NewidT() {
		// TODO Auto-generated method stub
		JPanel idPanel = new JPanel();
		JLabel idLabel = new JLabel("新教师账号：");
		Font f=new Font("新宋体",Font.BOLD,20);
		idLabel.setFont(f);
		NewidT = new JTextField(t);
		idPanel.add(idLabel);
		idPanel.add(NewidT);
		return idPanel;
	}
	private JPanel NewpowT() {
		// TODO Auto-generated method stub
		JPanel powPanel = new JPanel();
		JLabel powLabel = new JLabel("新账号密码：");
		Font f=new Font("新宋体",Font.BOLD,20);
		powLabel.setFont(f);
		NewpowT = new JTextField(t);
		powPanel.add(powLabel);
		powPanel.add(NewpowT);
		return powPanel;
	}

	JPanel addButtonPanel() {
		JPanel addButtonPanel = new JPanel();
		addButton = new JButton("确认修改考试");
		addButton.addActionListener(this);
		addButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String Tname = nameT.getText();
				String Tid = idT.getText();
				String Tpower = powT.getText();
				String Newid = NewidT.getText();
				String Newpow = NewpowT.getText();
				if(Tname.isEmpty()||Tid.isEmpty()||Newid.isEmpty()||Newpow.isEmpty()) {
					JOptionPane.showMessageDialog(null, "输入为空或输入有误！！！\n\n请重新输入");
					return;
				}
				int flag1 =fun.findteacherName(Tname);
				int flag2 = fun.findteacherID(Tid);		
				if(flag1 != flag2) {
					JOptionPane.showMessageDialog(null, "未查找到该考试信息！！！\n\n请重新输入"); 
					return;
				}else {
					tea.setteaName(Tname);
					tea.setteaID(Newid);
					tea.setteaPOW(Newpow);
					fun.update2(tea);       //修改
					Boolean t = fun.write_teacherfile();
					if(t==true) {
						JOptionPane.showMessageDialog(null, "修改成功！！！");
						jf.dispose();	
					}	
				}			
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