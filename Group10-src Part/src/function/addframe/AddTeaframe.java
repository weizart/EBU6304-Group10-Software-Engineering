package function.addframe;

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

import entity.Teachers;
import function.Function;
import function.judge;

/**
 * The type Add teaframe.
 */
public class AddTeaframe extends JFrame implements ActionListener {
    /**
     * The Add panel.
     */
    JPanel addPanel ,
    /**
     * The Text.
     */
    text;
    /**
     * The Tea power t.
     */
    JTextField teaPowerT,
    /**
     * The Tea account t.
     */
    teaAccountT,
    /**
     * The Tea name t.
     */
    teaNameT;
    /**
     * The T.
     */
    final int t = 25; //输入框的长度
    /**
     * The Teaframe.
     */
    JFrame teaframe;
    /**
     * The Fun.
     */
    Function fun = new Function();
    /**
     * The Judge.
     */
    judge judge = new judge();
    /**
     * The Tea.
     */
    Teachers tea = new Teachers();
    /**
     * The Tlist.
     */
    ArrayList<Teachers> tlist = new ArrayList<Teachers>();

    /**
     * Instantiates a new Add teaframe.
     */
    public AddTeaframe() {
		Addteaframe();
	}

    /**
     * Addteaframe.
     */
    void Addteaframe() {
		teaframe = new JFrame();
		JLabel teaLabel = new JLabel();
		teaframe.setLayout(new BorderLayout());

		teaLabel = new JLabel(" 添 加 教 师 信 息 " , JLabel.CENTER);
		Font f=new Font("新宋体",Font.BOLD,30);
		teaLabel.setFont(f);
		teaLabel.setForeground(Color.blue);
		teaframe.add(teaLabel, BorderLayout.NORTH);
		teaframe.setTitle("考试任务管理");
		teaframe.setSize(990, 600);
		teaframe.setLocation(350, 200);
		teaframe.setLocationRelativeTo(null); //使窗口居中
		teaframe.setVisible(true);
		addPanel = new JPanel();
		addPanel = addTeapanel();
		teaframe.add(addPanel, BorderLayout.CENTER);
	}

	private JPanel addTeapanel() {
		// TODO Auto-generated method stub
		JPanel teatext = new JPanel();

		JPanel teaName = teaName();
		JPanel teaAccount = teaAccount();
		JPanel teaPower = teaPower();
		addPanel = addButtonPanel();
		teatext.setLayout(new GridLayout(4,1));
		teatext.add(teaName);
		teatext.add(teaAccount);
		teatext.add(teaPower);
		teatext.add(addPanel);
		return teatext;
	}

	private JPanel teaPower() {
		// TODO Auto-generated method stub
		JPanel teaPowerPanel = new JPanel();
		JLabel teaPowerLabel = new JLabel("密    码：");
		Font f=new Font("新宋体",Font.BOLD,20);
		teaPowerLabel.setFont(f);
		teaPowerT = new JTextField(t);
		teaPowerPanel.add(teaPowerLabel);
		teaPowerPanel.add(teaPowerT);
		return teaPowerPanel;
	}
	private JPanel teaAccount() {
		// TODO Auto-generated method stub
		JPanel teaAccountpanel = new JPanel();
		JLabel teaAccountLabel = new JLabel("账    号：");
		Font f=new Font("新宋体",Font.BOLD,20);
		teaAccountLabel.setFont(f);
		teaAccountT = new JTextField(t);
		teaAccountpanel.add(teaAccountLabel);
		teaAccountpanel.add(teaAccountT);
		return teaAccountpanel;
	}
	private JPanel teaName() {
		// TODO Auto-generated method stub
		JPanel namePanel = new JPanel();
		JLabel nameLabel = new JLabel("教师姓名：");
		Font f=new Font("新宋体",Font.BOLD,20);
		nameLabel.setFont(f);
		teaNameT = new JTextField(t);
		namePanel.add(nameLabel);
		namePanel.add(teaNameT);
		return namePanel;
	}
	private JPanel addButtonPanel() {
		// TODO Auto-generated method stub
		JPanel addButtonPanel = new JPanel();
		JButton addButton = new JButton("确认添加教师信息");
		addButton.addActionListener(this);
		addButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String teaName = teaNameT.getText();
				String teaAccount = teaAccountT.getText();
				String teaPower = teaPowerT.getText();

				if(teaName.equals("") || teaAccount.equals("") || teaPower.equals("")) {
					JOptionPane.showMessageDialog(null, "教师信息有误！！！\n\n请重新输入！！！");
					return;
				}
				if(fun.findteacherID(teaAccount) == fun.findteacherName(teaName)) {
					JOptionPane.showMessageDialog(null,teaName+"该老师已有账号已存在！！！\n\n请重新录入！！！");
					System.out.print(fun.findteacherID(teaAccount)+"~"+fun.findteacherName(teaName));
					return;
				}
				if(fun.findteacherID(teaAccount) != -2 ) {
					JOptionPane.showMessageDialog(null,"该账号已存在！！！\n\n请重新录入！！！");
					System.out.print(fun.findteacherID(teaAccount));
					return;
				}
				tea.setteaName(teaName);
				tea.setteaID(teaAccount);
				tea.setteaPOW(teaPower);


				System.out.println("信息管理员");
				System.out.println(tea.fileTeaString());
				fun.addTeacher(tea);
				fun.write_teacherfile();

				JOptionPane.showMessageDialog(null, "录入成功！！！");
				teaframe.dispose();
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