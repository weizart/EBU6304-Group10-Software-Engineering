package function.addframe;

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
 * The type Addframe.
 */
public class Addframe extends JFrame implements ActionListener{

    /**
     * The T.
     */
    final int t = 25; //�����ĳ���

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
     * The Add panel.
     */
    JPanel addPanel ,
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
     * The Day t.
     */
//	����textPanel-����
	JTextField dayT,
    /**
     * The Time t.
     */
    timeT ,
    /**
     * The Name t.
     */
    nameT ,
    /**
     * The Class t.
     */
    classT ,
    /**
     * The Renshu t.
     */
    renshuT ,
    /**
     * The Address t.
     */
    addressT ,
    /**
     * The K crenshu t.
     */
    KCrenshuT ,
    /**
     * The Tea t 1.
     */
    teaT_1 ,
    /**
     * The Tea t 2.
     */
    teaT_2 ,
    /**
     * The Zhukao t.
     */
    zhukaoT;
    /**
     * The Add button.
     */
    JButton addButton ;

    /**
     * Instantiates a new Addframe.
     */
    public Addframe() {
		createtitle();
	}

    /**
     * Createtitle.
     */
    void createtitle() {
		jf = new JFrame();
		jf.setLayout(new BorderLayout());

		jl = new JLabel("Add Score" , JLabel.CENTER);
		Font f=new Font("������",Font.BOLD,30);
		jl.setFont(f);
		jl.setForeground(Color.blue);
		jf.add(jl, BorderLayout.NORTH);
		jf.setTitle("Score Management");
		jf.setSize(990, 600);
		jf.setLocation(350, 200);
		jf.setLocationRelativeTo(null); //ʹ���ھ���
		jf.setVisible(true);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addPanel = new JPanel();
		addPanel = addpanel();
		jf.add(addPanel, BorderLayout.CENTER);
	}

	private JPanel addpanel() {
		text = new JPanel();

		JPanel weekT = weekPanel();
		JPanel weekDayT = weekDayPanel();
		JPanel dayT = dayPanel();
		JPanel timeT = timePanel();
		JPanel nameT = namePanel();
		JPanel classT = classPanel();
		JPanel renshuT = renshuPanel();
		JPanel addressT = addressPanel();
		JPanel KCrenshuT = KCrenshuPanel();
		JPanel tea_1 = tea_1Panel();
		JPanel tea_2 = tea_2Panel();
		JPanel zhukao = zhukaoPanel();
		addPanel = addButtonPanel();
		text.setLayout(new GridLayout(15,1));
		text.add(weekT);
		text.add(weekDayT);
		text.add(dayT);
		text.add(timeT);
		text.add(nameT);
		text.add(classT);
		text.add(renshuT);
		text.add(addressT);
		text.add(KCrenshuT);
		text.add(tea_1);
		text.add(tea_2);
		text.add(zhukao);
		text.add(addPanel);
		return text;
	}


	private JPanel weekPanel() {
		// TODO Auto-generated method stub
		JPanel weekPanel = new JPanel();
		JLabel weekLabel = new JLabel("Week:");
		Font f=new Font("������",Font.BOLD,20);
		weekLabel.setFont(f);
		cmb1 = new JComboBox();
		cmb1.addItem("����Select����");
		cmb1.addItem("��1��");
		cmb1.addItem("��2��");
		cmb1.addItem("��3��");
		cmb1.addItem("��4��");
		cmb1.addItem("��5��");
		cmb1.addItem("��6��");
		cmb1.addItem("��7��");
		cmb1.addItem("��8��");
		cmb1.addItem("��9��");
		cmb1.addItem("��10��");
		cmb1.addItem("��11��");
		cmb1.addItem("��12��");
		cmb1.addItem("��13��");
		cmb1.addItem("��14��");
		cmb1.addItem("��15��");
		cmb1.addItem("��16��");
		cmb1.addItem("��17��");
		cmb1.addItem("��18��");
		cmb1.addItem("��19��");
		cmb1.addItem("��20��");
		cmb1.addItem("��21��");
		cmb1.addItem("��22��");
		cmb1.addItem("��23��");
		cmb1.addItem("��24��");
		cmb1.addItem("��25��");
		weekPanel.add(weekLabel);
		weekPanel.add(cmb1);
		return weekPanel;
	}
	private JPanel weekDayPanel() {
		// TODO Auto-generated method stub
		JPanel weekDayPanel = new JPanel();
		JLabel weekDayLabel = new JLabel("Day:");
		Font f=new Font("������",Font.BOLD,20);
		weekDayLabel.setFont(f);
		cmb2 = new JComboBox();
		cmb2.addItem("����Select����");
		cmb2.addItem("��1");
		cmb2.addItem("��2");
		cmb2.addItem("��3");
		cmb2.addItem("��4");
		cmb2.addItem("��5");
		cmb2.addItem("����");
		cmb2.addItem("����");
		weekDayPanel.add(weekDayLabel);
		weekDayPanel.add(cmb2);
		return weekDayPanel;
	}
	private JPanel dayPanel() {
		// TODO Auto-generated method stub
		JPanel dayPanel = new JPanel();
		JLabel dayLabel = new JLabel("Date:");
		Font f=new Font("������",Font.BOLD,20);
		dayLabel.setFont(f);
		dayT = new JTextField(t);
		dayPanel.add(dayLabel);
		dayPanel.add(dayT);
		return dayPanel;
	}
	private JPanel timePanel() {
		// TODO Auto-generated method stub
		JPanel timePanel = new JPanel();
		JLabel timeLabel = new JLabel("Time:");
		Font f=new Font("������",Font.BOLD,20);
		timeLabel.setFont(f);
		timeT = new JTextField(t);
		timePanel.add(timeLabel);
		timePanel.add(timeT);
		return timePanel;
	}
	private JPanel namePanel() {
		// TODO Auto-generated method stub
		JPanel namePanel = new JPanel();
		JLabel nameLabel = new JLabel("Curriculum:");
		Font f=new Font("������",Font.BOLD,20);
		nameLabel.setFont(f);
		nameT = new JTextField(t);
		namePanel.add(nameLabel);
		namePanel.add(nameT);
		return namePanel;
	}
	private JPanel classPanel() {
		// TODO Auto-generated method stub
		JPanel classPanel = new JPanel();
		JLabel classLabel = new JLabel("Class:");
		Font f=new Font("������",Font.BOLD,20);
		classLabel.setFont(f);
		classT = new JTextField(t);
		classPanel.add(classLabel);
		classPanel.add(classT);
		return classPanel;
	}
	private JPanel renshuPanel() {
		// TODO Auto-generated method stub
		JPanel renshuPanel = new JPanel();
		JLabel renshuLabel = new JLabel("ID:");
		Font f=new Font("������",Font.BOLD,20);
		renshuLabel.setFont(f);
		renshuT = new JTextField(t);
		renshuPanel.add(renshuLabel);
		renshuPanel.add(renshuT);
		return renshuPanel;
	}
	private JPanel addressPanel() {
		// TODO Auto-generated method stub
		JPanel addressPanel = new JPanel();
		JLabel addressLabel = new JLabel("Name:");
		Font f=new Font("������",Font.BOLD,20);
		addressLabel.setFont(f);
		addressT = new JTextField(t);
		addressPanel.add(addressLabel);
		addressPanel.add(addressT);
		return addressPanel;
	}
	private JPanel KCrenshuPanel() {
		// TODO Auto-generated method stub
		JPanel KCrenshuPanel = new JPanel();
		JLabel KCrenshuLabel = new JLabel("Grade��");
		Font f=new Font("������",Font.BOLD,20);
		KCrenshuLabel.setFont(f);
		KCrenshuT = new JTextField(t);
		KCrenshuPanel.add(KCrenshuLabel);
		KCrenshuPanel.add(KCrenshuT);
		return KCrenshuPanel;
	}
	private JPanel tea_1Panel() {
		// TODO Auto-generated method stub
		JPanel tea_1Panel = new JPanel();
		JLabel tea_1Label = new JLabel("GPA��");
		Font f=new Font("������",Font.BOLD,20);
		tea_1Label.setFont(f);
		teaT_1 = new JTextField(t);
		tea_1Panel.add(tea_1Label);
		tea_1Panel.add(teaT_1);
		return tea_1Panel;
	}
	private JPanel tea_2Panel() {
		// TODO Auto-generated method stub
		JPanel tea_2Panel = new JPanel();
		JLabel tea_2Label = new JLabel("Credit");
		Font f=new Font("������",Font.BOLD,20);
		tea_2Label.setFont(f);
		teaT_2 = new JTextField(t);
		tea_2Panel.add(tea_2Label);
		tea_2Panel.add(teaT_2);
		return tea_2Panel;	}
	private JPanel zhukaoPanel() {
		// TODO Auto-generated method stub
		JPanel zhukaoPanel = new JPanel();
		JLabel zhukaoLabel = new JLabel("Access");
		Font f=new Font("������",Font.BOLD,20);
		zhukaoLabel.setFont(f);
		zhukaoT = new JTextField(t);
		zhukaoPanel.add(zhukaoLabel);
		zhukaoPanel.add(zhukaoT);
		return zhukaoPanel;
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
				String time1 = cmb1.getSelectedItem().toString();
				String time2 = cmb2.getSelectedItem().toString();
				String time3 = dayT.getText();
				String time4 = timeT.getText();
				String etime = time1+time2+"("+time3+")"+time4;

				String ename = nameT.getText();
				String eclass = classT.getText();
				String erenshu = renshuT.getText();
				String eaddress = addressT.getText();
				String eKCrenshu = KCrenshuT.getText();
				String etea_1 = teaT_1.getText();
				String etea_2 = teaT_2.getText();
				String ezhukao = zhukaoT.getText();


				if(etime.equals("")||ename.equals("")||eclass.equals("")||eKCrenshu.equals("")||eaddress.equals("")||eKCrenshu.equals("")||zhukaoT.equals("")) {
					JOptionPane.showMessageDialog(null, "Wrong Information\n\nPlease chech your input!");
					return;
				}
				if(etea_1.equals("")) {
					etea_1 ="--";
				}
				if(etea_2.equals("")) {
					etea_2 ="--";
				}
				if(judge.JudgeDay(time3)==false) {
					JOptionPane.showMessageDialog(null, "¼��Ŀ����������󣡣���\n\n������¼�룡����");
					return;
				}
				if(judge.JudgeTime(time4)==false) {
					JOptionPane.showMessageDialog(null, "¼��Ŀ���ʱ�����󣡣���\n\n������¼�룡����");
					return;
				}

				exam.seteTime(etime);
				exam.seteName(ename);
				exam.seteClass(eclass);
				exam.seteRenShu(erenshu);
				exam.seteAddress(eaddress);
				exam.setkaochangrenshu(eKCrenshu);
				exam.seteTeacher_1(etea_1);
				exam.seteTeacher_2(etea_2);
				exam.seteZhuKao(ezhukao);

				if(fun.find3(etime) == fun.find4(eaddress)) {
					JOptionPane.showMessageDialog(null, "�ý����ѱ�ռ�ã�����\n\n������¼�룡����");
					return;
				}
				if(fun.find1(ename) == fun.find2(eclass)) {
					JOptionPane.showMessageDialog(null, "¼��Ŀ����Ѵ��ڣ�����\n\n������¼�룡����");
					System.out.print(fun.find1(ename)+"~"+fun.find2(eclass));
					return;
				}


				System.out.println("Admin");
				System.out.println(exam.exam_fileString());
				fun.add(exam);
				fun.write_examfile();

				JOptionPane.showMessageDialog(null, "¼��ɹ�������");
				jf.dispose();
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
