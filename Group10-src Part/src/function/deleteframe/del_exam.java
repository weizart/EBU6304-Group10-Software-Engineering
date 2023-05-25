package function.deleteframe;

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

import entity.Examwork;
import function.Function;
import function.judge;

/**
 * The type Del exam.
 */
public class del_exam extends JFrame implements ActionListener	{
	/**
	 * The T.
	 */
	final int t = 25; //输入框的长度
	/**
	 * The Fun.
	 */
	Function fun = new Function();
	/**
	 * The Exam.
	 */
	Examwork exam = new Examwork();
	/**
	 * The Judge.
	 */
	judge judge = new judge();
	/**
	 * The Array.
	 */
	ArrayList<Examwork> array = new ArrayList<Examwork>();


	/**
	 * The Jf.
	 */
	JFrame jf ;
	/**
	 * The Jl.
	 */
	JLabel jl ;
	/**
	 * The Del panel.
	 */
	JPanel delPanel ,
	/**
	 * The Text.
	 */
	text;
	/**
	 * The Cmb 1.
	 */
	JComboBox<String> cmb1,
	/**
	 * The Cmb 2.
	 */
	cmb2;
	/**
	 * The Name t.
	 */
//	创建textPanel-窗口
	JTextField nameT ,
	/**
	 * The Class t.
	 */
	classT;
	/**
	 * The Del button.
	 */
	JButton delButton ;

	/**
	 * Instantiates a new Del exam.
	 */
	public del_exam() {
		createtitle();
	}

	/**
	 * Createtitle.
	 */
	void createtitle() {
		jf = new JFrame();
		jf.setLayout(new BorderLayout());

		jl = new JLabel("Delete Score" , JLabel.CENTER);
		Font f=new Font("新宋体",Font.BOLD,30);
		jl.setFont(f);
		jl.setForeground(Color.blue);
		jf.add(jl, BorderLayout.NORTH);
		jf.setTitle("Score Management");
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
		JPanel classT = classPanel();
		delPanel = delButtonPanel();
		text.setLayout(new GridLayout(3,1));
		text.add(nameT);
		text.add(classT);
		text.add(delPanel);
		return text;
	}
	private JPanel namePanel() {
		// TODO Auto-generated method stub
		JPanel namePanel = new JPanel();
		JLabel nameLabel = new JLabel("Curriculum");
		Font f=new Font("新宋体",Font.BOLD,20);
		nameLabel.setFont(f);
		nameT = new JTextField(t);
		namePanel.add(nameLabel);
		namePanel.add(nameT);
		return namePanel;
	}
	private JPanel classPanel() {
		// TODO Auto-generated method stub
		JPanel classPanel = new JPanel();
		JLabel classLabel = new JLabel("Class：");
		Font f=new Font("新宋体",Font.BOLD,20);
		classLabel.setFont(f);
		classT = new JTextField(t);
		classPanel.add(classLabel);
		classPanel.add(classT);
		return classPanel;
	}

	/**
	 * Del button panel j panel.
	 *
	 * @return the j panel
	 */
	JPanel delButtonPanel() {
		JPanel delButtonPanel = new JPanel();
		delButton = new JButton("Confirm");
		delButton.addActionListener(this);
		delButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String ename = nameT.getText();
				String eclass = classT.getText();
				int flag1 =fun.find1(ename);
				int flag2 =fun.find2(eclass);
				if(ename.equals("")||eclass.equals("")) {
					JOptionPane.showMessageDialog(null, "考试信息为空！！！\n\n请重新输入！！！");
					return;
				}else if(flag1==-1||flag2==-1){
					JOptionPane.showMessageDialog(null, "未查找到该考试信息！！！\n\n请重新输入");
					return;
				}else {
					fun.del_Exam(ename,eclass);
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
