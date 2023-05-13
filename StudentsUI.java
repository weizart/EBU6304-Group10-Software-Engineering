package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import gui.student.analysis.ScoreListUI;
import gui.student.modules.ModuleListUI;

public class StudentsUI extends JFrame implements ListSelectionListener {
	private JFrame mainframe ;
	private JList list;
	private JSplitPane splitPane;
	private ArrayList<JPanel> panelList;
	private String[] function = {"Mainpage","Time Table","My Modules","Score Inquiry","Achivement Inquiry","Analysis"};

	public static final String imagePath = "D:\\bighomework\\src\\img\\";
	public static final String dataPath = "D:\\bighomework\\src\\";

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
		JLabel stuphoto = new JLabel(new ImageIcon(imagePath + "wangjie.jpg"));
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
		//��ҳ������
		return mp;
	}

	public JPanel getPaneltimetableSystem() {
		JPanel tt = new JPanel();
		//�γ̱������
		return tt;
	}

	public JPanel getPanelmoduleSystem() {
		JPanel module = new ModuleListUI();
		//�γ�ģ�������
		return module;
	}
	public JPanel getPanelanalysisSystem() {
		JPanel ana = new ScoreListUI();
		ana.setBounds(20, 20, 700, 500);
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
			FileReader f1 = new FileReader(dataPath + "Grades.txt");
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
			FileReader f1 = new FileReader(dataPath + "Achievement.txt");
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