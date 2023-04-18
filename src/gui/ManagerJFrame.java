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
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.BorderFactory;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import addframe.AddStudentframe;
import addframe.AddTeaframe;
import addframe.Addframe;
import deleteframe.del_Stu;
import deleteframe.del_Teacher;
import deleteframe.del_exam;
import entity.Examwork;
import function.Function;
import function.judge;
import reviseframe.Revise_Student;
import reviseframe.Revise_Teacher;
import reviseframe.Revise_exam;

public class ManagerJFrame extends JFrame implements ListSelectionListener ,ActionListener {
	private JFrame mainframe ;
	private JList list;
	private JSplitPane splitPane;
	private ArrayList<JPanel> panelList;
	private String[] function = {"About us","Score Management","Search","Teacher ID Management","Student ID Management"};
	
	Function fun = new Function();
	Examwork exam = new Examwork();
	judge judge = new judge();
	ArrayList<Examwork> array = new ArrayList<Examwork>();
	JPanel functionPanel ;
	JButton addButton, delButton , revButton , retButton , exitButton ;
	JLabel Label;
	JTable table = null;
	DefaultTableModel model = null;
	JScrollPane scrollPane ;
	public ManagerJFrame() {
		mainframe = new JFrame();
		mainframe.setTitle("Admin page");
		mainframe.setSize(1480, 700);
		mainframe.setLocation(350, 200);	
		mainframe.setLocationRelativeTo(null);//使窗口居中
		mainframe.setVisible(true);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		list = new JList(function);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(this);
		list.setBorder(BorderFactory.createRaisedBevelBorder());
		list.setFont(new Font("粗体",Font.BOLD,15));
		
		panelList = new ArrayList<JPanel>();
		panelList.add(getPanelAboutSystem());
		panelList.add(getPanelExamInformation());
		panelList.add(getPanelJianKao());
		panelList.add(getPanelTeacherInformation());
		panelList.add(getPanelStudentInformation());
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,list,panelList.get(1));
		splitPane.setLeftComponent(list);	
		mainframe.add(splitPane);		
	}
	
	public JPanel getPanelJianKao() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		JList list = (JList) e.getSource();
		splitPane.setRightComponent(panelList.get(list.getSelectedIndex()));	
	}
	/**
	 * 关于系统说明
	 * @return JPanel
	 */
	public JPanel getPanelAboutSystem() {
		JPanel mainPanel = new JPanel();
		
		JTextPane explain = new JTextPane();
		JLabel headline = new JLabel("About us");
		headline.setFont(new Font("粗体",Font.PLAIN,20));//设置字体
		
		explain.setText("EBU6304 \r\n" + 
				"Software Engineering\r\n" + 
				"Group10\r\n" );
		StyledDocument doc = explain.getStyledDocument();//------model---把属性集、文本内容结合起来
		SimpleAttributeSet setSize = new SimpleAttributeSet();//---属性集---把要加的属性先放一起---再加入文本内容
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
	 *考试信息的表格 
	 * @return
	 */
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
    	JScrollPane tablePanel = new JScrollPane(table);
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
        table.getColumnModel().getColumn(1).setPreferredWidth(110);
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
       
        //排序器	 （排序过程中有时会出现问题因为它是按字符排序的）       
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
        functionPanel = new JPanel();
        JPanel addButtonPanel = addButtonPanel();
		JPanel delButtonPanel = delButtonPanel();
		JPanel revButtonPanel = revButtonPanel();
		JPanel retButtonPanel = retButtonPanel();
		JPanel exitButtonPanel = exitButtonPanel();
		functionPanel.add(addButtonPanel);
		functionPanel.add(delButtonPanel);
		functionPanel.add(revButtonPanel);
		functionPanel.add(retButtonPanel);
		functionPanel.add(exitButtonPanel);
		jp.add(functionPanel, BorderLayout.SOUTH);	
		return jp;
    }
	
//	表格中的数据
	private Vector createTableModelData() {
		Vector data = new Vector();
		String t=null;
		try{
			FileReader f1 = new FileReader("C:\\Users\\魏子昂\\Desktop\\bighomework\\src\\Grades.txt");
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
	public JPanel getPanelTeacherInformation() {
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		DefaultTableModel model = null;
		JLabel Label;
		JTable table = null;
		JScrollPane scrollPane ;
		JPanel functionPanel1 ;
		//加入 表头 及 数据
		Vector columnNames=createColumnNames1();
		Vector data=createTableModelData1();
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

        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
        table.setPreferredScrollableViewportSize(new Dimension(1000, 420));
        
        //排序器	        
        RowSorter sorter = new TableRowSorter(model);
        table.setRowSorter(sorter);   
        // 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
        scrollPane = new JScrollPane(table);
        // 添加 滚动面板 到 内容面板
        jp.add(scrollPane,BorderLayout.CENTER);
        
        Label = new JLabel("Teacher ID Management" ,JLabel.CENTER);
        Font f=new Font("Times New Roman",Font.BOLD,30);
        Label.setFont(f);
        Label.setForeground(Color.BLACK);
        jp.add(Label, BorderLayout.NORTH);
  
        // 设置 内容面板 到 窗口
        functionPanel1 = new JPanel();
        JPanel addTeaB = addButtonPanel2();
        JPanel delTeaB = delButtonPanel2();
        JPanel revTeaB = revButtonPanel2();
        functionPanel1.add(addTeaB);
        functionPanel1.add(revTeaB);
        functionPanel1.add(delTeaB);
        
		jp.add(functionPanel1, BorderLayout.SOUTH);	
		return jp;
    }
	
//	表格中的数据
	private Vector createTableModelData1() {
		Vector data = new Vector();
		String t=null;
		try{
			FileReader f1 = new FileReader("C:\\Users\\魏子昂\\Desktop\\bighomework\\src\\教师账号和密码.txt");
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
	private Vector createColumnNames1() {
		Vector columnNames = new Vector();
		columnNames.add("Index");
		columnNames.add("Name");
		columnNames.add("ID");
		columnNames.add("Password");
		 
		return columnNames;
	}
	
	
	public JPanel getPanelStudentInformation() {
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
         
        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
        table.setPreferredScrollableViewportSize(new Dimension(1000, 420));
        
        //排序器	        
        RowSorter sorter = new TableRowSorter(model);
        table.setRowSorter(sorter);   
        // 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
        scrollPane = new JScrollPane(table);
        // 添加 滚动面板 到 内容面板
        jp.add(scrollPane,BorderLayout.CENTER);

		Label = new JLabel("Teacher ID Management" ,JLabel.CENTER);
		Font f=new Font("Times New Roman",Font.BOLD,30);
        Label.setFont(f);
        Label.setForeground(Color.BLACK);
        jp.add(Label, BorderLayout.NORTH);
  
        // 设置 内容面板 到 窗口
        JPanel functionPanel3 = new JPanel();
        JPanel addStuB = addButtonPanel3();
        JPanel delStuB = delButtonPanel3();
        JPanel revStuB = revButtonPanel3();
        functionPanel3.add(addStuB);
        functionPanel3.add(revStuB);
        functionPanel3.add(delStuB);
		jp.add(functionPanel3, BorderLayout.SOUTH);
				
		return jp;
    }
	
//	表格中的数据
	private Vector createTableModelData2() {
		Vector data = new Vector();
		String t=null;
		try{
			FileReader f1 = new FileReader("C:\\Users\\魏子昂\\Desktop\\bighomework\\src\\学生账号和密码.txt");
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
		columnNames.add("ID");
		columnNames.add("Password");
		 
		return columnNames;
	}
		
    JPanel addButtonPanel() {
		JPanel addButtonPanel = new JPanel();
		addButton = new JButton("Add Score");
		addButton.addActionListener(this);
		addButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				methodA();
			}
			private void methodA() {
				new Addframe();
				
			};
		});
		addButtonPanel.add(addButton);
		return addButtonPanel;
	}
    JPanel addButtonPanel2() {
		JPanel addButtonPanel = new JPanel();
		addButton = new JButton("Add Teacher");
		addButton.addActionListener(this);
		addButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				methodA();
			}
			private void methodA() {
				new AddTeaframe();
			};
		});
		addButtonPanel.add(addButton);
		return addButtonPanel;
	}
    JPanel addButtonPanel3() {
		JPanel addButtonPanel = new JPanel();
		addButton = new JButton("Add Student");
		addButton.addActionListener(this);
		addButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				methodA();
			}
			private void methodA() {
				new AddStudentframe();	
			};
		});
		addButtonPanel.add(addButton);
		return addButtonPanel;
	}
    
    
    
    
    JPanel revButtonPanel() {
		JPanel revButtonPanel = new JPanel();
		revButton = new JButton("Modify Score");
		revButton.addActionListener(this);
		revButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				methodA();
			}
			private void methodA() {
				new Revise_exam();
				
			};
		});
		revButtonPanel.add(revButton);
		return revButtonPanel;
	}
    JPanel revButtonPanel2() {
		JPanel revButtonPanel = new JPanel();
		revButton = new JButton("Modify teacher");
		revButton.addActionListener(this);
		revButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				methodA();
			}
			private void methodA() {
				new Revise_Teacher();
				
			};
		});
		revButtonPanel.add(revButton);
		return revButtonPanel;
	}
    JPanel revButtonPanel3() {
		JPanel revButtonPanel = new JPanel();
		revButton = new JButton("Modify Student");
		revButton.addActionListener(this);
		revButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				methodA();
			}
			private void methodA() {
				new Revise_Student();
			};
		});
		revButtonPanel.add(revButton);
		return revButtonPanel;
	}
    
    
    
    
	JPanel delButtonPanel() {
		JPanel delButtonPanel = new JPanel();
		delButton = new JButton("Delete Score");
		delButton.addActionListener(this);
		delButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				methodA();
			}
			private void methodA() {
				new del_exam();
			}
		});
		delButtonPanel.add(delButton);
		return delButtonPanel;
	}
	JPanel delButtonPanel2() {
		JPanel delButtonPanel = new JPanel();
		delButton = new JButton("Delete Teacher");
		delButton.addActionListener(this);
		delButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				methodA();
			}
			private void methodA() {

				new del_Teacher();
				
			}
		});
		delButtonPanel.add(delButton);
		return delButtonPanel;
	}
	JPanel delButtonPanel3() {
		JPanel delButtonPanel = new JPanel();
		delButton = new JButton("Delete Student");
		delButton.addActionListener(this);
		delButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				methodA();
			}
			private void methodA() {

				new del_Stu();
				
			}
		});
		delButtonPanel.add(delButton);
		return delButtonPanel;
	}
	JPanel retButtonPanel() {
		JPanel retButtonPanel = new JPanel();
		retButton = new JButton("Refresh");
		retButton.addActionListener(this);
		retButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				methodA(); 
			}
			private void methodA() {
				mainframe.dispose();
				new ManagerJFrame();
			};
		});
		retButtonPanel.add(retButton);
		return retButtonPanel;
	}
	
	JPanel exitButtonPanel() {
		JPanel exitButtonPanel = new JPanel();
		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		exitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				methodA(); 
			}
			private void methodA() {
				System.exit(0);
			};
		});
		exitButtonPanel.add(exitButton);
		return exitButtonPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
	}
}
