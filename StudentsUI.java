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
		mainframe.setLocationRelativeTo(null);//使窗口居中
		mainframe.setVisible(true);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenu menu, submenu,Edit,Import,Export,About;
		
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
		table.getTableHeader().setForeground(Color.red);                // 设置表头名称字体颜色
		table.getTableHeader().setResizingAllowed(false);               // 设置不允许手动改变列宽
		table.getTableHeader().setReorderingAllowed(false);             // 设置不允许拖动重新排序各列
		// 设置行高
		table.setRowHeight(40);
		//数据显示且居中
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);



		// 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
		table.setPreferredScrollableViewportSize(new Dimension(1000, 420));

		//排序器
		RowSorter sorter = new TableRowSorter(model);
		table.setRowSorter(sorter);
		// 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
		scrollPane = new JScrollPane(table);
		// 添加 滚动面板 到 内容面板
		jp.add(scrollPane,BorderLayout.CENTER);

		Label = new JLabel(" Score Management" ,JLabel.CENTER);
		Font f=new Font("Times New Roman",Font.BOLD,30);
		Label.setFont(f);
		Label.setForeground(Color.BLACK);
		jp.add(Label, BorderLayout.NORTH);

		// 设置 内容面板 到 窗口
		return jp;
	}


	//	表格中的数据
	private Vector createTableModelData() {
		Vector data = new Vector();
		String t=null;
		try{
			FileReader f1 = new FileReader("D:\\Group Work\\bighomework\\src\\Grades.txt");
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
	//表头
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

	//	表格中的数据
	private Vector createTableModelData2() {
		Vector data = new Vector();
		String t=null;
		try{
			FileReader f1 = new FileReader("D:\\Group Work\\bighomework\\src\\Achievement.txt");
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
	//表头
	private Vector createColumnNames2() {
		Vector columnNames = new Vector();
		columnNames.add("Index");
		columnNames.add("Name");
		columnNames.add("Achievement");
		columnNames.add("Date");

		return columnNames;
	}
}
