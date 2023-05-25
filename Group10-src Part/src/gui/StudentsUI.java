package gui;

import gui.student.analysis.ScoreListUI;
import gui.student.modules.ModuleListUI;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
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

/**
 * 学生用户界面
 * studentUserInterface
 *
 * @author Wei Ziang
 * @date 2023 /05/23
 */
public class StudentsUI extends JFrame implements ListSelectionListener {
	private JFrame mainframe ;
	private JList list;
	private JSplitPane splitPane;
	private ArrayList<JPanel> panelList;
	private String[] function = {"Mainpage","TimeTable","Module Report","Module Search","Grade Analysis","Grade Report","Analysis Report","Achievement Report","Portfolio"};

	/**
	 * The Fun.
	 */
	Function fun = new Function();
	/**
	 * The Exam.
	 */
	Examwork exam = new Examwork();
	/**
	 * The Array.
	 */
	ArrayList<Examwork> array = new ArrayList<Examwork>();
	/**
	 * The Function panel.
	 */
	JPanel functionPanel ;
	/**
	 * The Label.
	 */
	JLabel Label,
	/**
	 * The Stuname.
	 */
	stuname;
	/**
	 * The Table.
	 */
	JTable table = null;
	/**
	 * The Model.
	 */
	DefaultTableModel model = null;
	/**
	 * The Scroll pane.
	 */
	JScrollPane scrollPane ;

	/**
	 * studentUserInterface
	 */
	public StudentsUI() throws IOException {
		mainframe = new JFrame();
		mainframe.setTitle("Student page");
		mainframe.setSize(1480, 700);
		mainframe.setLocation(350, 200);
		mainframe.setLocationRelativeTo(null);//makeWindowInMiddle
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
		list.setFont(new Font("粗体",Font.BOLD,15));
		//pageLists
//		panelList.add(getPanelAboutSystem());
		panelList.add(getPanelmainpageSystem());
		panelList.add(getPaneltimetableSystem());
		panelList.add(getModuleSystem());
		panelList.add(module());
		panelList.add(ana());
		panelList.add(getPanelExamInformation());

		panelList.add(getPanelanalysisSystem());

		panelList.add(getAchievementInformation());
		panelList.add(portfolioSystem());



		JPanel photo = new JPanel();
		photo.setLayout(new BorderLayout());
		JLabel stuphoto = new JLabel(new ImageIcon(ImageIO.read(new File("./src/img/wangjie.jpg"))));
		JTextPane explain = new JTextPane();
		explain.setText("Wang Jie\r\n" +
				"2020213039\r\n" +
				"IS of BUPT&QMUL\r\n" +
				"Telecom&Manage\r\n" );
		Font f=new Font("Times New Roman",Font.BOLD,15);
		explain.setFont(f);
		explain.setBackground(null);
		explain.setAlignmentX(Component.CENTER_ALIGNMENT);
		explain.setAlignmentY(Component.CENTER_ALIGNMENT);
		explain.setEditable(false);
		photo.add(stuphoto,BorderLayout.NORTH);
		photo.add(explain,BorderLayout.CENTER);

		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,list,panelList.get(0));
		splitPane.setDividerLocation(220);
		splitPane.setEnabled(false);
		getContentPane().add(splitPane, BorderLayout.CENTER);
		// createAVerticalPartitionPanel
		final JSplitPane vSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		vSplitPane.setDividerLocation(250);
		vSplitPane.setEnabled(false);
		vSplitPane.setDividerSize(8);// forWidthOfSplitter8pixel
		vSplitPane.setOneTouchExpandable(true);// provideUIwidget
		// articleInAdjustingSpacePositionOfPanelToRedrawWayForContinuousMapping
		vSplitPane.setContinuousLayout(true);
		splitPane.setLeftComponent(vSplitPane);
		vSplitPane.setLeftComponent(photo);
		vSplitPane.setRightComponent(list);
		mainframe.add(splitPane);
	}

	/**
	 *
	 * @param e e
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		JList list = (JList) e.getSource();
		splitPane.setRightComponent(panelList.get(list.getSelectedIndex()));

	}

	/**
	 * get panelmainpage system
	 *
	 * @return {@link JPanel}
	 */
	public JPanel getPanelmainpageSystem() {
		JPanel mp = new JPanel();
		//splitOutTwoLinesUpAndDown
		mp.setLayout(new GridLayout(2,1));
		//inFirstLineToSeparateTwopanel
		Panel p1=new Panel(new GridLayout(1,2));
		//setFirstLineOfTwoPointsPanel
		Panel p1_1=new Panel(new BorderLayout());
		Panel p1_2=new Panel(new BorderLayout());
		Panel p1_2_2 = new Panel (new GridLayout(2,2));
		//inSecondRowGivesThreepanel
		Panel p2=new Panel(new GridLayout(1,3));

		//setUpSecondLineThreepanel
		JPanel p2_1=new JPanel(new BorderLayout());
		p2_1.setBorder(BorderFactory.createRaisedBevelBorder());
		JPanel p2_2=new JPanel(new BorderLayout());
		p2_2.setBorder(BorderFactory.createRaisedBevelBorder());
		JPanel p2_3=new JPanel(new BorderLayout());
		p2_3.setBorder(BorderFactory.createRaisedBevelBorder());
//		p1_1.setBackground(Color.BLACK);
//		p1_2.setBackground(Color.BLUE);
//		p2_1.setBackground(Color.GREEN);
//		p2_2.setBackground(Color.RED);
//		p2_3.setBackground(Color.PINK);

		Font f=new Font("Times New Roman",Font.BOLD,30);

		JLabel jta1= new JLabel("Class Schedule");
		jta1.setBorder(BorderFactory.createRaisedBevelBorder());
//		jta1.setSize(p1_1.getWidth(),1/5*p1_1.getHeight());
		jta1.setForeground(Color.black);
		jta1.setFont(f);
		p1_1.add(jta1,BorderLayout.NORTH);

		String[] CN={"Week/Time Period","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		String[][] TableValues={{"08:00-08:45","","","","","","",""},
				{"08:50-09:35","AdvancedMathmetics","Datastructure","","","","",""},
				{"09:50-10:35","","","","","","",""},
				{"10:40-11:25"," ProgrammingLanguage","","","","AdvancedMathmetics","",""},
				{"11:30-12:15","","","","","","",""},
				{"13:00-13:45","","","","Swimming","","",""},
				{"13:50-14:35","","","","","","",""},
				{"14:45-15:30","","English","","","","",""},
				{"15:40-16:25","","","","","","History",""},
				{"16:35-17:20","","","","","","",""},
				{"17:25-18:10","","","","","","",""}};


		JTable jtb = new JTable(TableValues,CN);

		JScrollPane js=new JScrollPane(jtb);
		js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		jtb.setSelectionForeground(Color.BLUE);//setYourForegroundColor
		jtb.setSelectionBackground(Color.yellow);//setBackgroundColor
		jtb.setRowHeight(30);//lineHighPixel
		jtb.setEnabled(false);
//		jtb.setFillsViewportHeight(true);

		jtb.setSize(p1_1.getWidth(),p1_1.getHeight());

		p1_1.add(js,BorderLayout.CENTER);


		JButton jb1=new JButton("Check Grades");
		JButton jb2=new JButton("Online Diploma");
		JButton jb3=new JButton("Select Courses");
		JButton jb4=new JButton("Application for Deferred Exam");
		p1_2_2.add(jb1);
		p1_2_2.add(jb2);
		p1_2_2.add(jb3);
		p1_2_2.add(jb4);
		p1_2.add(p1_2_2);

		JLabel jta2= new JLabel("Useful Options");
//		jta1.setSize(p1_1.getWidth(),1/5*p1_1.getHeight());
		jta2.setBorder(BorderFactory.createRaisedBevelBorder());
		jta2.setForeground(Color.black);
		jta2.setFont(f);
		p1_2.add(jta2,BorderLayout.NORTH);

		JLabel jta3=new JLabel("Online Q&A");
//		jta1.setSize(p1_1.getWidth(),1/5*p1_1.getHeight());
		jta3.setBorder(BorderFactory.createRaisedBevelBorder());
		jta3.setForeground(Color.black);
		jta3.setFont(f);
		p2_1.add(jta3,BorderLayout.NORTH);


		JLabel jta4=new JLabel("Announcement");
//		jta1.setSize(p1_1.getWidth(),1/5*p1_1.getHeight());
		jta4.setBorder(BorderFactory.createRaisedBevelBorder());
		jta4.setForeground(Color.black);
		jta4.setFont(f);
		p2_2.add(jta4,BorderLayout.NORTH);

		Font e=new Font("Times New Roman",Font.BOLD,30);
		JLabel jta4_1 = new JLabel("<html><body><p><br/><br/>The educational administration system will be updated in the near future.</p></body></html>",JLabel.LEFT);
//		jta1.setSize(p1_1.getWidth(),1/5*p1_1.getHeight());
		jta4_1.setFont(e);
		jta4_1.setEnabled(false);
		jta4_1.setForeground(Color.BLUE);
		p2_2.add(jta4_1,BorderLayout.CENTER);

		JLabel jta5=new JLabel("Semester Schedule");
//		jta1.setSize(p1_1.getWidth(),1/5*p1_1.getHeight());
		jta5.setBorder(BorderFactory.createRaisedBevelBorder());
		jta5.setForeground(Color.black);
		jta5.setFont(f);
		p2_3.add(jta5,BorderLayout.NORTH);

		//inTurnSuperposition panel
		mp.add(p1);
		mp.add(p2);
		p1.add(p1_1);
		p1.add(p1_2);
		p2.add(p2_1);
		p2.add(p2_2);
		p2.add(p2_3);
		return mp;
	}

	/**
	 * acquisitionModuleSystem
	 *
	 * @return {@link JPanel}
	 */
	public JPanel getModuleSystem() {
		JPanel md = new JPanel();
		//分割出上下两行
		md.setLayout(new GridLayout(2,1));
		//第一行中分出两个panel
		Panel p1=new Panel(new BorderLayout());
		//第二行中分出三个panel
		Panel p2=new Panel(new GridLayout(1,3));

		//设置第二行的三个panel
		JPanel p2_1=new JPanel(new GridLayout(4,1));
		p2_1.setBorder(BorderFactory.createRaisedBevelBorder());
		JPanel p2_2=new JPanel(new GridLayout(4,1));
		p2_2.setBorder(BorderFactory.createRaisedBevelBorder());
		JPanel p2_3=new JPanel(new GridLayout(4,1));
		p2_3.setBorder(BorderFactory.createRaisedBevelBorder());

		JLabel p11 = new JLabel("My Modules" ,JLabel.CENTER);
		Font f=new Font("Times New Roman",Font.BOLD,30);
		Font ff=new Font("Times New Roman",Font.PLAIN,35);
		p11.setFont(f);
		p11.setForeground(Color.BLACK);
		p1.add(p11, BorderLayout.NORTH);
		JLabel p12 = new JLabel("<html><body><p align=\"Center\">Year 2023---Sixth Semester<br/><br/>Current Weeks:   <font color=\"RED\">WEEK12</font><br/>Next course:   <font color=\"RED\">Software Engineering</font><br/><br/></p></body></html>",JLabel.CENTER);
		p12.setFont(ff);
		p1.add(p12, BorderLayout.CENTER);

		Font f1=new Font("Times New Roman",Font.BOLD,30);
		Font f2=new Font("Times New Roman",Font.BOLD,20);
		Font f3=new Font("Times New Roman",Font.ITALIC,15);

		JLabel L1_1 = new JLabel("Software Engineering",JLabel.CENTER);
		L1_1.setFont(f1);
		p2_1.add(L1_1);
		JProgressBar b1 = new JProgressBar();
		b1.setStringPainted(true);
		b1.setBorderPainted(false);
		b1.setForeground(new Color(0, 179, 255));
		b1.setBackground(new Color(168, 200, 198));
		b1.setValue(20);
		p2_1.add(b1);
		JLabel L1_2 = new JLabel("Week2: TDD",JLabel.CENTER);
		L1_2.setFont(f2);
		p2_1.add(L1_2);
		JLabel L1_3 = new JLabel("Next DDL: April 20",JLabel.CENTER);
		L1_3.setFont(f3);
		p2_1.add(L1_3);

		JLabel L2_1 = new JLabel("Advanced Mathmetics",JLabel.CENTER);
		L2_1.setFont(f1);
		p2_2.add(L2_1);
		JProgressBar b2 = new JProgressBar();
		b2.setStringPainted(true);
		b2.setBorderPainted(false);
		b2.setForeground(new Color(0, 179, 255));
		b2.setBackground(new Color(168, 200, 198));
		b2.setValue(70);
		p2_2.add(b2);
		JLabel L2_2 = new JLabel("Week12: Derivatives",JLabel.CENTER);
		L2_2.setFont(f2);
		p2_2.add(L2_2);
		JLabel L2_3 = new JLabel("Next DDL: May 15",JLabel.CENTER);
		L2_3.setFont(f3);
		p2_2.add(L2_3);

		JLabel L3_1 = new JLabel("Communication Principles",JLabel.CENTER);
		L3_1.setFont(f1);
		p2_3.add(L3_1);
		JProgressBar b3 = new JProgressBar();
		b3.setStringPainted(true);
		b3.setBorderPainted(false);
		b3.setForeground(new Color(0, 179, 255));
		b3.setBackground(new Color(168, 200, 198));
		b3.setValue(50);
		p2_3.add(b3);
		JLabel L3_2 = new JLabel("Week10: Demodulation",JLabel.CENTER);
		L3_2.setFont(f2);
		p2_3.add(L3_2);
		JLabel L3_3 = new JLabel("Next DDL: May 20",JLabel.CENTER);
		L3_3.setFont(f3);
		p2_3.add(L3_3);

		md.add(p1);
		md.add(p2);
		p2.add(p2_1);
		p2.add(p2_2);
		p2.add(p2_3);
		return md;
	}

	/**
	 * paneltimetable
	 *
	 * @return {@link JPanel}
	 */
	public JPanel getPaneltimetableSystem() {
		JPanel tt = new JPanel();
		tt.setLayout(new BorderLayout());
		JLabel label1=new JLabel("Select："); //createALabel
		JComboBox year=new JComboBox(); //JComboBox
		year.addItem("--Year--"); //addADownList
		year.addItem("2020-2021");
		year.addItem("2021-2022");
		year.addItem("2022-2023");
		JComboBox week=new JComboBox(); //createJComboBox
		week.addItem("--Week--"); //addADownList
		week.addItem("1");
		week.addItem("2");
		week.addItem("3");
		JButton button=new JButton("Search");
		JPanel p = new JPanel(new GridLayout(1,3));
		p.add(year);
		p.add(week);
		p.add(button);
		tt.add(p,BorderLayout.NORTH);


		//addHeadersAndData
		Vector columnNames=createColumnNames3();
		Vector data=createTableModelData3();
		model = new DefaultTableModel(data,columnNames);

		//doNotEditDesignForm
		table = new JTable(model){
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		JScrollPane tablePanel = new JScrollPane(table);
		table.setForeground(Color.BLACK);                   // fontColor
		table.setFont(new Font(null, Font.PLAIN, 15));      // fontStyle
		table.setSelectionForeground(Color.DARK_GRAY);      // afterSelectedFontColor
		table.setSelectionBackground(Color.LIGHT_GRAY);     // afterSelectedFontBackground
		table.setGridColor(Color.GRAY);

		// setHeader
		table.getTableHeader().setFont(new Font(null, Font.BOLD, 20));  // setNameOfHeaderFontStyle
		table.getTableHeader().setForeground(Color.RED);                // setNameOfHeaderFontColor
		table.getTableHeader().setResizingAllowed(false);               // settingsAreNotAllowedToChangeColumnWidthManually
		table.getTableHeader().setReorderingAllowed(false);             // settingsDoNotAllowDragReorderColumns
		// setLineHeight
		table.setRowHeight(60);
		//accordingToDataAndCentered
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);
		// setEachRowsWide
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(110);
		table.getColumnModel().getColumn(4).setPreferredWidth(110);
		table.getColumnModel().getColumn(5).setPreferredWidth(110);


		// setViewportScrollingPanelSize（moreThanSizeOfRowsOfData,needToDragScrollBarToSee）
		table.setPreferredScrollableViewportSize(new Dimension(1000, 420));

		// putTableInRollingPanel(headerWillBeAutomaticallyAddedToRollingPanelAtTop)
		scrollPane = new JScrollPane(table);
		// scrollingPanelIsAddedToContentPane
		tt.add(scrollPane,BorderLayout.CENTER);
		return tt;
	}

	/**
	 * portfolioSystem
	 *
	 * @return {@link JPanel}
	 */
	public JPanel portfolioSystem() throws IOException {

		JPanel pf = new JPanel();
		pf.setLayout(new BorderLayout());

		Panel p1 = new Panel(new GridLayout(2,3));
		JLabel label = new JLabel("Honors received in college");
		Font f=new Font("Times New Roman",Font.BOLD,30);
		label.setFont(f);
		pf.add(label,BorderLayout.NORTH);
		label.setHorizontalAlignment(SwingConstants.CENTER);
//		pf.add(new Button(),BorderLayout.EAST);
//		pf.add(new Button(),BorderLayout.WEST);
//		pf.add(new Button(),BorderLayout.SOUTH);

		JLabel t1 = new JLabel(new ImageIcon(ImageIO.read(new File("./src/img/1.jpg"))));
		p1.add(t1);
		JLabel t2 = new JLabel(new ImageIcon(ImageIO.read(new File("./src/img/2.jpg"))));
		p1.add(t2);
		JLabel t3 = new JLabel(new ImageIcon(ImageIO.read(new File("./src/img/3.jpg"))));
		p1.add(t3);
		JLabel t4 = new JLabel(new ImageIcon(ImageIO.read(new File("./src/img/4.jpg"))));
		p1.add(t4);
		JLabel t5 = new JLabel(new ImageIcon(ImageIO.read(new File("./src/img/5.jpg"))));
		p1.add(t5);
		JLabel t6 = new JLabel(new ImageIcon(ImageIO.read(new File("./src/img/6.jpg"))));
		p1.add(t6);

		pf.add(p1);

		return pf;
	}

	/**
	 * panelanalysis
	 *
	 * @return {@link JPanel}
	 */
	public JPanel getPanelanalysisSystem() {
		JPanel ana = new JPanel();
		JPanel p1 = new JPanel(new GridLayout(2,1));
		ana.setLayout(new BorderLayout());

		DrawTu d = new DrawTu();
		Label = new JLabel("Grade Analysis" ,JLabel.CENTER);
		Font f=new Font("Times New Roman",Font.BOLD,30);
		Label.setFont(f);
		Label.setForeground(Color.BLACK);
		ana.add(Label, BorderLayout.NORTH);
//		JLabel headline = new JLabel("Grade Analysis");
//		headline.setFont(new Font("粗体",Font.PLAIN,20));//设置字体
//		ana.add(headline,BorderLayout.WEST);
		ana.add(d,BorderLayout.CENTER);

//		JTextPane explain = new JTextPane();
//		explain.setText("Your Grade:\r\n" +
//				"3.9/4.0\r\n" +
//				"GPA:90.0\r\n" );
//		StyledDocument doc = explain.getStyledDocument();//------model---把属性集、文本内容结合起来
//		SimpleAttributeSet setSize = new SimpleAttributeSet();//---属性集---把要加的属性先放一起---再加入文本内容
//		StyleConstants.setFontSize(setSize,55);
//		doc.setCharacterAttributes(0,144,setSize,true);
//		explain.setBackground(null);
//		explain.setAlignmentX(CENTER_ALIGNMENT);
//		explain.setAlignmentY(CENTER_ALIGNMENT);
//		explain.setEditable(false);
		JLabel l1 = new JLabel("<html><body><p align=\"Center\">Your Grade:<br/><br/><font color=\"RED\">3.9</font>/4.0<br/><br/>GPA:<font color=\"RED\">95.4</font><br/><br/></p></body></html>",JLabel.CENTER);
		l1.setFont(f);
		p1.add(l1);
		ana.add(p1,BorderLayout.WEST);

		return ana;
	}

	/**
	 * module
	 *
	 * @return {@link JPanel}
	 */
	public JPanel module() {
		JPanel module = new ModuleListUI();
		//contentOfCourseModule
		return module;
	}

	/**
	 * Ana j panel.
	 *
	 * @return {@link JPanel}
	 */
	public JPanel ana() {
		JPanel ana = new ScoreListUI();
		ana.setBounds(20, 20, 700, 500);
		//performanceAnalysis
		return ana;
	}

	/**
	 * aboutSystemPanel
	 *
	 * @return {@link JPanel}
	 */
	public JPanel getPanelAboutSystem() {
		JPanel mainPanel = new JPanel();

		JTextPane explain = new JTextPane();
		JLabel headline = new JLabel("About us");
		headline.setFont(new Font("粗体",Font.PLAIN,20));//setFont

		explain.setText("EBU6304 \r\n" +
				"Software Engineering\r\n" +
				"Group10\r\n" );
		StyledDocument doc = explain.getStyledDocument();//------model---setOfPropertiescombinedTextContent
		SimpleAttributeSet setSize = new SimpleAttributeSet();//---setOfProperties---toAddAttributesToPutTogetherFirst---addTextContent
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

	/**
	 * testInformationForGroup
	 *
	 * @return {@link JPanel}
	 */
	public JPanel getPanelExamInformation() {
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());

		//addHeadersAndData
		Vector columnNames=createColumnNames();
		Vector data=createTableModelData();
		model = new DefaultTableModel(data,columnNames);

		//doNotEditDesignForm
		table = new JTable(model){
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		JScrollPane tablePanel = new JScrollPane(table);
		table.setForeground(Color.BLACK);                   // fontColor
		table.setFont(new Font(null, Font.PLAIN, 15));      // fontStyle
		table.setSelectionForeground(Color.DARK_GRAY);      // afterSelectedFontColor
		table.setSelectionBackground(Color.LIGHT_GRAY);     // afterSelectedFontBackground
		table.setGridColor(Color.GRAY);

		// setHeader
		table.getTableHeader().setFont(new Font(null, Font.BOLD, 20));  // setNameOfHeaderFontStyle
		table.getTableHeader().setForeground(Color.red);                // setNameOfHeaderFontColor
		table.getTableHeader().setResizingAllowed(false);               // settingsAreNotAllowedToChangeColumnWidthManually
		table.getTableHeader().setReorderingAllowed(false);             // settingsDoNotAllowDragReorderColumns
		// setLineHeight
		table.setRowHeight(40);
		//accordingToDataAndCentered
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);
		// setEachRowsWide
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


		// setViewportScrollingPanelSize（moreThanSizeOfRowsOfData，needToDragScrollBarToSee）
		table.setPreferredScrollableViewportSize(new Dimension(1000, 420));

		//collator
		RowSorter sorter = new TableRowSorter(model);
		table.setRowSorter(sorter);
		// 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
		scrollPane = new JScrollPane(table);
		// 添加 滚动面板 到 内容面板
		jp.add(scrollPane,BorderLayout.CENTER);

		Label = new JLabel(" Score Inquiry" ,JLabel.CENTER);
		Font f=new Font("Times New Roman",Font.BOLD,30);
		Label.setFont(f);
		Label.setForeground(Color.BLACK);
		jp.add(Label, BorderLayout.NORTH);

		// 设置 内容面板 到 窗口
		return jp;
	}


	/**
	 * 创建表格模型数据
	 *
	 * @return {@link Vector}
	 *///	表格中的数据
	private Vector createTableModelData() {
		Vector data = new Vector();
		String t=null;
		try{
			File f = new File("./src/data/","Grades.txt");
			FileReader f1 = new FileReader(f);
			BufferedReader br=new BufferedReader(f1);
			int i=0 ,k=1;
			while ((t= br.readLine())!= null)
			{
				String [] s=t.split("\\s+");		//通过空格分割字符串数组
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

	/**
	 * 创建列名
	 *
	 * @return {@link Vector}
	 *///表头
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

	/**
	 * 获得成就信息
	 *
	 * @return {@link JPanel}
	 */
	public JPanel getAchievementInformation() {
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		DefaultTableModel model = null;
		JLabel Label;
		JTable table = null;
		JScrollPane scrollPane ;

		//加入 表头 及 数据
		Vector columnNames=createColumnNames2();
		Vector data=createTableModelData2();
		model = new DefaultTableModel(data,columnNames);

		//设计表格不可编辑
		table = new JTable(model){
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		JScrollPane tablePanel = new JScrollPane(table);
		table.setForeground(Color.BLACK);                   // 字体颜色
		table.setFont(new Font(null, Font.PLAIN, 15));      // 字体样式
		table.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
		table.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
		table.setGridColor(Color.GRAY);

		// 设置表头
		table.getTableHeader().setFont(new Font(null, Font.BOLD, 20));  // 设置表头名称字体样式
		table.getTableHeader().setForeground(Color.RED);                // 设置表头名称字体颜色
		table.getTableHeader().setResizingAllowed(false);               // 设置不允许手动改变列宽
		table.getTableHeader().setReorderingAllowed(false);             // 设置不允许拖动重新排序各列
		// 设置行高
		table.setRowHeight(40);
		//数据显示且居中
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);
		// 设置每一列列宽
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(1).setPreferredWidth(280);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(110);

		// 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
		table.setPreferredScrollableViewportSize(new Dimension(1000, 420));

		//排序器
		RowSorter sorter = new TableRowSorter(model);
		table.setRowSorter(sorter);
		// 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
		scrollPane = new JScrollPane(table);
		// 添加 滚动面板 到 内容面板
		jp.add(scrollPane,BorderLayout.CENTER);

		Label = new JLabel("Achievement Inquiry" ,JLabel.CENTER);
		Font f=new Font("Times New Roman",Font.BOLD,30);
		Label.setFont(f);
		Label.setForeground(Color.BLACK);
		jp.add(Label, BorderLayout.NORTH);

		// 设置 内容面板 到 窗口
		return jp;
	}

	/**
	 * 创建表模型data2
	 *
	 * @return {@link Vector}
	 *///	表格中的数据
	private Vector createTableModelData2() {
		Vector data = new Vector();
		String t=null;
		try{
			File f = new File("./src/data/","Achievement.txt");
			FileReader f1 = new FileReader(f);
			BufferedReader br=new BufferedReader(f1);
			int i=0 ,k=1;
			while ((t= br.readLine())!= null)
			{
				String [] s=t.split("\\s+");		//通过空格分割字符串数组
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

	/**
	 * 创建列names2
	 *
	 * @return {@link Vector}
	 *///表头
	private Vector createColumnNames2() {
		Vector columnNames = new Vector();
		columnNames.add("Index");
		columnNames.add("Name");
		columnNames.add("Achievement");
		columnNames.add("Date");

		return columnNames;
	}

	/**
	 * 创建表模型data3
	 *
	 * @return {@link Vector}
	 */
	private Vector createTableModelData3() {
		Vector data = new Vector();
		String t=null;
		try{
			File f = new File("./src/data/","Timetable.txt");
			FileReader f1 = new FileReader(f);
			BufferedReader br=new BufferedReader(f1);
			int i=0 ,k=1;
			while ((t= br.readLine())!= null)
			{
				String [] s=t.split("\\s+");		//通过空格分割字符串数组
				Vector rowData = new Vector();
				rowData.add(s[0]);
				rowData.add(s[1]);
				rowData.add(s[2]);
				rowData.add(s[3]);
				rowData.add(s[4]);
				rowData.add(s[5]);
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

	/**
	 * 创建列names3
	 *
	 * @return {@link Vector}
	 *///表头
	private Vector createColumnNames3() {
		Vector columnNames = new Vector();
		columnNames.add("");
		columnNames.add("Monday");
		columnNames.add("Tuesday");
		columnNames.add("Wednesday");
		columnNames.add("Thursday");
		columnNames.add("Friday");

		return columnNames;
	}

	/**
	 * The type Draw tu.
	 */
//画图模块
	class DrawTu extends JPanel {

		@Override
		public void paintComponent(Graphics g) {
			int x = 0, y = 0, x1 = 0, y1 = 10;
			g.drawLine(240, 30, 240, 300); //输出坐标轴(x,y)
			g.drawLine(240, 300, 580, 300);
			for (int i = 0; i <= 9; i++) { //输出x、y坐标的刻度及数值
				g.setColor(Color.red);
				g.drawLine(240 + x, 298, 240 + x, 302);
				g.drawString(String.valueOf(y), 238 + x, 315);
				g.drawLine(238, 280 - x1, 241, 280 - x1);
				g.drawString(String.valueOf(y1), 220, 285 - x1);
				x = x + 30;//每刻度的间隔
				y = y + 10;
				x1 = x1 + 25;
				y1 = y1 + 10;
			}
			Vector data=createTableModelData();
			int[] dt = {0,98,65,88,90,82,85,1000,1000,1000,1000};
			String[] st = {"0","A","B","C","D","E","F","0","0","0","0","0"};
			g.drawString("Curriculum", 605, 310);
			g.drawString("Score", 220, 25);
			for (int i = 1; i <= 10; i++) {
				g.setColor(Color.blue);//填充外图
				g.fillRect(250 + (i - 1) * 30, (int) (300-2.5 * dt[i]), 15, 15);
				g.setColor(Color.blue);//写百分比
				g.drawString(st[i], 250 + (i - 1) * 30, 300);
				g.drawString(String.valueOf(dt[i]),250 + (i - 1) * 30, (int) (290-2.5 * dt[i]));
			}
		}
	}
}