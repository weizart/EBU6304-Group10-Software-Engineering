package function.reviseframe;

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

/**
 * The type Revise student.
 */
public class Revise_Student extends JFrame implements ActionListener {
    /**
     * The T.
     */
    final int t = 25; //输入框的长度
    /**
     * The Fun.
     */
    Function fun = new Function();
    /**
     * The Stu.
     */
    Students stu = new Students();
    /**
     * The Judge.
     */
    judge judge = new judge();
    /**
     * The Slist.
     */
    ArrayList<Students> slist = new ArrayList<Students>();
    /**
     * The Jf.
     */
    JFrame jf ;
    /**
     * The Jl.
     */
    JLabel jl ;
    /**
     * The Add panel.
     */
    JPanel addPanel ,
    /**
     * The Text.
     */
    text;
    /**
     * The Name t.
     */
    JTextField nameT ,
    /**
     * The Id t.
     */
    idT ,
    /**
     * The Pow t.
     */
    powT ,
    /**
     * The Newid t.
     */
    NewidT ,
    /**
     * The Newpow t.
     */
    NewpowT;
    /**
     * The Add button.
     */
    JButton addButton ;

    /**
     * Instantiates a new Revise student.
     */
    public Revise_Student() {
		createtitle();
	}

    /**
     * Createtitle.
     */
    void createtitle() {
		jf = new JFrame();
		jf.setLayout(new BorderLayout());

		jl = new JLabel("Modify Student" , JLabel.CENTER);
		Font f=new Font("新宋体",Font.BOLD,30);
		jl.setFont(f);
		jl.setForeground(Color.blue);
		jf.add(jl, BorderLayout.NORTH);
		jf.setTitle("Student Management");
		jf.setSize(990, 600);
		jf.setLocation(350, 200);
		jf.setLocationRelativeTo(null); //使窗口居中
		jf.setVisible(true);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		JLabel idLabel = new JLabel("Old-ID：");
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
		JLabel powLabel = new JLabel("Old-password：");
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
		JLabel nameLabel = new JLabel("Name:");
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
		JLabel idLabel = new JLabel("New-ID：");
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
		JLabel powLabel = new JLabel("New-password：");
		Font f=new Font("新宋体",Font.BOLD,20);
		powLabel.setFont(f);
		NewpowT = new JTextField(t);
		powPanel.add(powLabel);
		powPanel.add(NewpowT);
		return powPanel;
	}

    /**
     * Add button panel j panel.
     *
     * @return the j panel
     */
    JPanel addButtonPanel() {
		JPanel addButtonPanel = new JPanel();
		addButton = new JButton("Confirm");
		addButton.addActionListener(this);
		addButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String Tname = nameT.getText();
				String Tid = idT.getText();
				String Tpower = powT.getText();
				String Newid = NewidT.getText();
				String Newpow = NewpowT.getText();
				int flag1 =fun.findStudentName(Tname);
				int flag2 = fun.findstudentID(Tid);
				if(Tname.isEmpty()||Tid.isEmpty()||Newid.isEmpty()||Newpow.isEmpty()) {
					JOptionPane.showMessageDialog(null, "输入为空或输入有误！！！\n\n请重新输入");
					return;
				}
				if(flag1 != flag2) {
					JOptionPane.showMessageDialog(null, "未查找到该账号信息！！！\n\n请重新输入");
					return;
				}else {
					stu.setstuName(Tname);
					stu.setstuID(Newid);
					stu.setstuPOW(Newpow);
					fun.update3(stu);       //修改
					Boolean t = fun.write_studentfile();
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
