package gui;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import entity.Examwork;
import function.Function;


public class StudentsUI extends JFrame implements ListSelectionListener {
	private JFrame mainframe ;
	private JList list;
	private JSplitPane splitPane;
	private ArrayList<JPanel> panelList;
	private String[] function = {"Mainpage","Time Table","My Modules","Score Inquiry","Achivement Inquiry","Analysis"};

	Function fun = new Function();
	Examwork exam = new Examwork();
	ArrayList<Examwork> array = new ArrayList<Examwork>();
	JPanel functionPanel ;
	JLabel Label,stuname;
	JTable table = null;
	DefaultTableModel model = null;
	JScrollPane scrollPane ;
	public StudentsUI() {
		mainframe = new JFrame();
		mainframe.setTitle("Student page");
		mainframe.setSize(1480, 700);
		mainframe.setLocation(350, 200);
		mainframe.setLocationRelativeTo(null);//ʹ���ھ���
		mainframe.setVisible(true);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenu menu, submenu,Edit,Import,Export,About;
		JMenuItem i1, i2, i3, i4, i5;


		JMenuBar mb=new JMenuBar();
		menu=new JMenu("Menu");
		Edit=new JMenu("Edit");
		Import=new JMenu("Import");
		Export=new JMenu("Export");
		About=new JMenu("About");
		submenu=new JMenu("Sub Menu");
		i1=new JMenuItem("Item 1");
		i2=new JMenuItem("Item 2");
		i3=new JMenuItem("Item 3");
		i4=new JMenuItem("Item 4");
		i5=new JMenuItem("Item 5");
		menu.add(i1); menu.add(i2); menu.add(i3);
		submenu.add(i4); submenu.add(i5);
		menu.add(submenu);
		mb.add(menu);mb.add(Edit);mb.add(Import);mb.add(Export);mb.add(About);
		mainframe.setJMenuBar(mb);
		mainframe.setVisible(true);

		panelList = new ArrayList<JPanel>();
		list = new JList(function);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.addListSelectionListener(this);
		list.setFont(new Font("����",Font.BOLD,15));
		//ҳ���б�
//		panelList.add(getPanelAboutSystem());
		panelList.add(getPanelmainpageSystem());
		panelList.add(getPaneltimetableSystem());
		panelList.add(getPanelmoduleSystem());
		panelList.add(getPanelExamInformation());
		panelList.add(getPanelanalysisSystem());
		panelList.add(getAchievementInformation());



		JPanel photo = new JPanel();
		JLabel stuphoto = new JLabel(new ImageIcon("D:\\Group Work\\bighomework\\src\\img\\wangjie.jpg"));
		stuname = new JLabel("Wang Jie 2020213039");
		photo.add(stuphoto);
		photo.add(stuname);

		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,list,panelList.get(0));
		splitPane.setDividerLocation(150);
		splitPane.setEnabled(false);
		getContentPane().add(splitPane, BorderLayout.CENTER);
		// ����һ����ֱ����ķָ����
		final JSplitPane vSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		vSplitPane.setDividerLocation(200);
		vSplitPane.setEnabled(false);
		vSplitPane.setDividerSize(8);// �ָ����Ŀ��Ϊ8����
		vSplitPane.setOneTouchExpandable(true);// �ṩUIС����
		// �ڵ����ָ���λ��ʱ�����ػ淽ʽΪ��������
		vSplitPane.setContinuousLayout(true);
		splitPane.setLeftComponent(vSplitPane);
		vSplitPane.setLeftComponent(photo);
		vSplitPane.setRightComponent(list);
		mainframe.add(splitPane);
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		JList list = (JList) e.getSource();
		splitPane.setRightComponent(panelList.get(list.getSelectedIndex()));

	}
	public JPanel getPanelmainpageSystem() {
		JPanel mp = new JPanel();
		//�ָ����������
		mp.setLayout(new GridLayout(2,1));
		//��һ���зֳ�����panel
		Panel p1=new Panel(new GridLayout(1,2));
		//���õ�һ�е�������Panel
		Panel p1_1=new Panel(new BorderLayout());
		Panel p1_2=new Panel(new BorderLayout());
		Panel p1_2_2 = new Panel (new GridLayout(2,2));
		//�ڶ����зֳ�����panel
		Panel p2=new Panel(new GridLayout(1,3));
		//���õڶ��е�����panel
		Panel p2_1=new Panel(new BorderLayout());
		Panel p2_2=new Panel(new BorderLayout());
		Panel p2_3=new Panel(new BorderLayout());
//		p1_1.setBackground(Color.BLACK);
//		p1_2.setBackground(Color.BLUE);
//		p2_1.setBackground(Color.GREEN);
//		p2_2.setBackground(Color.RED);
//		p2_3.setBackground(Color.PINK);

		Font f=new Font("Times New Roman",Font.BOLD,30);

		JTextArea jta1=new JTextArea("Class Schedule");
//		jta1.setSize(p1_1.getWidth(),1/5*p1_1.getHeight());
		jta1.setEnabled(false);
		jta1.setForeground(Color.black);
		jta1.setFont(f);
		p1_1.add(jta1,BorderLayout.NORTH);

		String[] ColumnNames={"Week/Time Period","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		String[][] TableValues={{"08:00-08:45","","","","","","",""},
								{"08:50-09:35","","","","","","",""},
								{"09:50-10:35","","","","","","",""},
								{"10:40-11:25","","","","","","",""},
								{"11:30-12:15","","","","","","",""},
								{"13:00-13:45","","","","","","",""},
								{"13:50-14:35","","","","","","",""},
								{"14:45-15:30","","","","","","",""},
								{"15:40-16:25","","","","","","",""},
								{"16:35-17:20","","","","","","",""},
								{"17:25-18:10","","","","","","",""}};


		JTable jtb=new JTable(TableValues,ColumnNames);
		JScrollPane js=new JScrollPane(jtb);
		js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jtb.setEnabled(false);
		jtb.setFillsViewportHeight(true);
//		jtb.setSize(p1_1.getWidth(),p1_1.getHeight());
		p1_1.add(jtb);




		JButton jb1=new JButton("Check Grades");
		JButton jb2=new JButton("Online Diploma");
		JButton jb3=new JButton("Select Courses");
		JButton jb4=new JButton("Application for Deferred Exam");
		p1_2_2.add(jb1);
		p1_2_2.add(jb2);
		p1_2_2.add(jb3);
		p1_2_2.add(jb4);
		p1_2.add(p1_2_2);

		JTextArea jta2=new JTextArea("Useful Options");
//		jta1.setSize(p1_1.getWidth(),1/5*p1_1.getHeight());
		jta2.setEnabled(false);
		jta2.setForeground(Color.black);
		jta2.setFont(f);
		p1_2.add(jta2,BorderLayout.NORTH);

		JTextArea jta3=new JTextArea("Online Q&A");
//		jta1.setSize(p1_1.getWidth(),1/5*p1_1.getHeight());
		jta3.setEnabled(false);
		jta3.setForeground(Color.black);
		jta3.setFont(f);
		p2_1.add(jta3,BorderLayout.NORTH);
		jta3.setBackground(Color.LIGHT_GRAY);


		JTextArea jta4=new JTextArea("Announcement");
//		jta1.setSize(p1_1.getWidth(),1/5*p1_1.getHeight());
		jta4.setForeground(Color.black);
		jta4.setFont(f);
		jta4.setEnabled(false);
		p2_2.add(jta4,BorderLayout.NORTH);
		jta4.setBackground(Color.LIGHT_GRAY);

		JTextArea jta4_1=new JTextArea("The educational administration system will be updated in the near future");
//		jta1.setSize(p1_1.getWidth(),1/5*p1_1.getHeight());
		jta4_1.setEnabled(false);
		jta4_1.setForeground(Color.black);
		p2_2.add(jta4_1,BorderLayout.CENTER);

		JTextArea jta5=new JTextArea("Semester Schedule");
//		jta1.setSize(p1_1.getWidth(),1/5*p1_1.getHeight());
		jta5.setEnabled(false);
		jta5.setForeground(Color.black);
		jta5.setFont(f);
		p2_3.add(jta5,BorderLayout.NORTH);
		jta5.setBackground(Color.LIGHT_GRAY);

		//���ε���panel
		mp.add(p1);
		mp.add(p2);
		p1.add(p1_1);
		p1.add(p1_2);
		p2.add(p2_1);
		p2.add(p2_2);
		p2.add(p2_3);

		return mp;
	}

	public JPanel getPaneltimetableSystem() {
		JPanel tt = new JPanel();
		//�γ̱������
		return tt;
	}

	public JPanel getPanelmoduleSystem() {
		JPanel module = new JPanel();
		//�γ�ģ�������
		return module;
	}
	public JPanel getPanelanalysisSystem() {
		JPanel ana = new JPanel();
		//�ɼ�����
		return ana;
	}

	public JPanel getPanelAboutSystem() {
		JPanel mainPanel = new JPanel();

		JTextPane explain = new JTextPane();
		JLabel headline = new JLabel("About us");
		headline.setFont(new Font("����",Font.PLAIN,20));//��������

		explain.setText("EBU6304 \r\n" +
				"Software Engineering\r\n" +
				"Group10\r\n" );
		StyledDocument doc = explain.getStyledDocument();//------model---�����Լ����ı����ݽ������
		SimpleAttributeSet setSize = new SimpleAttributeSet();//---���Լ�---��Ҫ�ӵ������ȷ�һ��---�ټ����ı�����
		StyleConstants.setFontSize(setSize,15);
		doc.setCharacterAttributes(0,144,setSize,true);
		explain.setBackground(null);
		explain.setEditable(false);
		mainPanel.add(headline);
		mainPanel.add(explain);
		mainPanel.setLayout(null);
		headline.setBounds(250,20,200,20);
		explain.setBounds(70, 50, 600, 500);
		return mainPanel;
	}

	public JPanel getPanelExamInformation() {
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());

		//���� ��ͷ �� ����
		Vector columnNames=createColumnNames();
		Vector data=createTableModelData();
		model = new DefaultTableModel(data,columnNames);

		//��Ʊ�񲻿ɱ༭
		table = new JTable(model){
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		JScrollPane tablePanel = new JScrollPane(table);
		table.setForeground(Color.BLACK);                   // ������ɫ
		table.setFont(new Font(null, Font.PLAIN, 15));      // ������ʽ
		table.setSelectionForeground(Color.DARK_GRAY);      // ѡ�к�������ɫ
		table.setSelectionBackground(Color.LIGHT_GRAY);     // ѡ�к����屳��
		table.setGridColor(Color.GRAY);

		// ���ñ�ͷ
		table.getTableHeader().setFont(new Font(null, Font.BOLD, 20));  // ���ñ�ͷ����������ʽ
		table.getTableHeader().setForeground(Color.red);                // ���ñ�ͷ����������ɫ
		table.getTableHeader().setResizingAllowed(false);               // ���ò������ֶ��ı��п�
		table.getTableHeader().setReorderingAllowed(false);             // ���ò������϶������������
		// �����и�
		table.setRowHeight(40);
		//������ʾ�Ҿ���
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);
		// ����ÿһ���п�
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(1).setPreferredWidth(280);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(110);
		table.getColumnModel().getColumn(4).setPreferredWidth(25);
		table.getColumnModel().getColumn(5).setPreferredWidth(35);
		table.getColumnModel().getColumn(6).setPreferredWidth(30);
		table.getColumnModel().getColumn(7).setPreferredWidth(45);
		table.getColumnModel().getColumn(8).setPreferredWidth(45);
		table.getColumnModel().getColumn(9).setPreferredWidth(50);


		// ���ù�������ӿڴ�С�������ô�С�������ݣ���Ҫ�϶����������ܿ�����
		table.setPreferredScrollableViewportSize(new Dimension(1000, 420));

		//������
		RowSorter sorter = new TableRowSorter(model);
		table.setRowSorter(sorter);
		// �� ��� �ŵ� ������� �У���ͷ���Զ���ӵ�������嶥����
		scrollPane = new JScrollPane(table);
		// ��� ������� �� �������
		jp.add(scrollPane,BorderLayout.CENTER);

		Label = new JLabel(" Score Management" ,JLabel.CENTER);
		Font f=new Font("Times New Roman",Font.BOLD,30);
		Label.setFont(f);
		Label.setForeground(Color.BLACK);
		jp.add(Label, BorderLayout.NORTH);

		// ���� ������� �� ����
		return jp;
	}


	//	����е�����
	private Vector createTableModelData() {
		Vector data = new Vector();
		String t=null;
		try{
			FileReader f1 = new FileReader("D:\\Group Work\\bighomework\\src\\Grades.txt");
			BufferedReader br=new BufferedReader(f1);
			int i=0 ,k=1;
			while ((t= br.readLine())!= null)
			{
				String [] s=t.split("\\s+");		//ͨ���ո�ָ��ַ�������
				Vector rowData = new Vector();

				rowData.add(k);
				rowData.add(s[0]);
				rowData.add(s[1]);
				rowData.add(s[2]);
				rowData.add(s[3]);
				rowData.add(s[4]);
				rowData.add(s[5]);
				rowData.add(s[6]);
				rowData.add(s[7]);
				rowData.add(s[8]);

				data.add(rowData);
				i++;
				k++;
			}
			f1.close();
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	//��ͷ
	private Vector createColumnNames() {
		Vector columnNames = new Vector();
		columnNames.add("Order");
		columnNames.add("Semester");
		columnNames.add("Curriculum");
		columnNames.add("Class");
		columnNames.add("Name");
		columnNames.add("Score");
		columnNames.add("GPA");
		columnNames.add("Credit");
		columnNames.add("Make-up score");
		columnNames.add("retake score");
		return columnNames;
	}

	public JPanel getAchievementInformation() {
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		DefaultTableModel model = null;
		JLabel Label;
		JTable table = null;
		JScrollPane scrollPane ;

		//���� ��ͷ �� ����
		Vector columnNames=createColumnNames2();
		Vector data=createTableModelData2();
		model = new DefaultTableModel(data,columnNames);

		//��Ʊ�񲻿ɱ༭
		table = new JTable(model){
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		JScrollPane tablePanel = new JScrollPane(table);
		table.setForeground(Color.BLACK);                   // ������ɫ
		table.setFont(new Font(null, Font.PLAIN, 15));      // ������ʽ
		table.setSelectionForeground(Color.DARK_GRAY);      // ѡ�к�������ɫ
		table.setSelectionBackground(Color.LIGHT_GRAY);     // ѡ�к����屳��
		table.setGridColor(Color.GRAY);

		// ���ñ�ͷ
		table.getTableHeader().setFont(new Font(null, Font.BOLD, 20));  // ���ñ�ͷ����������ʽ
		table.getTableHeader().setForeground(Color.RED);                // ���ñ�ͷ����������ɫ
		table.getTableHeader().setResizingAllowed(false);               // ���ò������ֶ��ı��п�
		table.getTableHeader().setReorderingAllowed(false);             // ���ò������϶������������
		// �����и�
		table.setRowHeight(40);
		//������ʾ�Ҿ���
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);
		// ����ÿһ���п�
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(1).setPreferredWidth(280);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(110);

		// ���ù�������ӿڴ�С�������ô�С�������ݣ���Ҫ�϶����������ܿ�����
		table.setPreferredScrollableViewportSize(new Dimension(1000, 420));

		//������
		RowSorter sorter = new TableRowSorter(model);
		table.setRowSorter(sorter);
		// �� ��� �ŵ� ������� �У���ͷ���Զ���ӵ�������嶥����
		scrollPane = new JScrollPane(table);
		// ��� ������� �� �������
		jp.add(scrollPane,BorderLayout.CENTER);

		Label = new JLabel("Achievement Inquiry" ,JLabel.CENTER);
		Font f=new Font("Times New Roman",Font.BOLD,30);
		Label.setFont(f);
		Label.setForeground(Color.BLACK);
		jp.add(Label, BorderLayout.NORTH);

		// ���� ������� �� ����
		return jp;
	}

	//	����е�����
	private Vector createTableModelData2() {
		Vector data = new Vector();
		String t=null;
		try{
			FileReader f1 = new FileReader("D:\\Group Work\\bighomework\\src\\Achievement.txt");
			BufferedReader br=new BufferedReader(f1);
			int i=0 ,k=1;
			while ((t= br.readLine())!= null)
			{
				String [] s=t.split("\\s+");		//ͨ���ո�ָ��ַ�������
				Vector rowData = new Vector();
				rowData.add(k);
				rowData.add(s[0]);
				rowData.add(s[1]);
				rowData.add(s[2]);
				data.add(rowData);
				i++;
				k++;
			}
			f1.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	//��ͷ
	private Vector createColumnNames2() {
		Vector columnNames = new Vector();
		columnNames.add("Index");
		columnNames.add("Name");
		columnNames.add("Achievement");
		columnNames.add("Date");

		return columnNames;
	}
}