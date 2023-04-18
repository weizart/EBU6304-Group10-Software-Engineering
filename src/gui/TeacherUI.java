package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import entity.Examwork;
import function.Function;

public class TeacherUI extends JFrame implements ListSelectionListener ,ActionListener {
	private JFrame mainframe ;
	private JList list;
	private JSplitPane splitPane ;
	private JScrollPane tablePanel;
	private ArrayList<JPanel> panelList;
	private String[] function = {"老师查看考试安排","申请替换监考任务"};
	Function fun = new Function();
	Examwork exam = new Examwork();
	ArrayList<Examwork> array = new ArrayList<Examwork>();
	JLabel Label;
	JTable table = null;
	DefaultTableModel model = null;
	JScrollPane scrollPane ;
	JPanel TiHuanPanel;
	JButton reviewButton;
	public TeacherUI() {
		mainframe = new JFrame();
		mainframe.setTitle("考试管理系统——老师页面");
		mainframe.setSize(1480, 700);
		mainframe.setLocation(350, 200);	
		mainframe.setLocationRelativeTo(null);//使窗口居中
		mainframe.setVisible(true);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelList = new ArrayList<JPanel>();
		
		list = new JList(function);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(this);
		list.setFont(new Font("粗体",Font.BOLD,15));

		panelList.add(getPanelExamInformation());
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,list,panelList.get(0));
		splitPane.setLeftComponent(list);	
		mainframe.add(splitPane);
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		JList list = (JList) e.getSource();
		splitPane.setRightComponent(panelList.get(list.getSelectedIndex()));
		
	}
	public JPanel getPanelExamInformation() {
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		
		//加入 表头 及 数据
		Vector columnNames=createColumnNames();
		Vector data=createTableModelData();
		model = new DefaultTableModel(data,columnNames);	
		
		//设计表格不可编辑
    	table = new JTable(model){
    		public boolean isCellEditable(int row, int column) { 
    			return false; 
    		}
    	};
    	
    	tablePanel = new JScrollPane(table);
    	table.setForeground(Color.BLACK);                   // 字体颜色
    	table.setFont(new Font(null, Font.PLAIN, 15));      // 字体样式
    	table.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
    	table.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
    	table.setGridColor(Color.GRAY);  
    	
        // 设置表头
        table.getTableHeader().setFont(new Font(null, Font.BOLD, 20));  // 设置表头名称字体样式
        table.getTableHeader().setForeground(Color.blue);                // 设置表头名称字体颜色
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
        table.getColumnModel().getColumn(4).setPreferredWidth(25);
        table.getColumnModel().getColumn(5).setPreferredWidth(35);
        table.getColumnModel().getColumn(6).setPreferredWidth(30);
        table.getColumnModel().getColumn(7).setPreferredWidth(45);
        table.getColumnModel().getColumn(8).setPreferredWidth(45);
        table.getColumnModel().getColumn(9).setPreferredWidth(50);
       
        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
        table.setPreferredScrollableViewportSize(new Dimension(1000, 420));
        
        //排序器	        
        RowSorter sorter = new TableRowSorter(model);
        table.setRowSorter(sorter);   
        // 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
        scrollPane = new JScrollPane(table);
        // 添加 滚动面板 到 内容面板
        jp.add(scrollPane,BorderLayout.CENTER);
        
        Label = new JLabel(" 考 试 信 息 任 务 管 理 " ,JLabel.CENTER);
        Font f=new Font("新宋体",Font.BOLD,30);
        Label.setFont(f);
        Label.setForeground(Color.BLACK);
        jp.add(Label, BorderLayout.NORTH);
        // 设置 内容面板 到 窗口
        JPanel functionPanel = new JPanel();
		return jp;
    }

//	表格中的数据
	private Vector createTableModelData() {
		Vector data = new Vector();
		String t=null;
		try{
			FileReader f1 = new FileReader("C:\\Users\\魏子昂\\Desktop\\bighomework\\src\\考试信息.txt");
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
		columnNames.add("序号");
		columnNames.add("考试时间");
		columnNames.add("课程名称");
		columnNames.add("考试班级");
		columnNames.add("人数");
		columnNames.add("地点");
		columnNames.add("考场人数");
		columnNames.add("监考1");
		columnNames.add("监考2");
		columnNames.add("主考");   
		return columnNames;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
	}
}





