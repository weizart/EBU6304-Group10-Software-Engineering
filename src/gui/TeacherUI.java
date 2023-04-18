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
	private String[] function = {"��ʦ�鿴���԰���","�����滻�࿼����"};
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
		mainframe.setTitle("���Թ���ϵͳ������ʦҳ��");
		mainframe.setSize(1480, 700);
		mainframe.setLocation(350, 200);	
		mainframe.setLocationRelativeTo(null);//ʹ���ھ���
		mainframe.setVisible(true);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelList = new ArrayList<JPanel>();
		
		list = new JList(function);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(this);
		list.setFont(new Font("����",Font.BOLD,15));

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
    	
    	tablePanel = new JScrollPane(table);
    	table.setForeground(Color.BLACK);                   // ������ɫ
    	table.setFont(new Font(null, Font.PLAIN, 15));      // ������ʽ
    	table.setSelectionForeground(Color.DARK_GRAY);      // ѡ�к�������ɫ
    	table.setSelectionBackground(Color.LIGHT_GRAY);     // ѡ�к����屳��
    	table.setGridColor(Color.GRAY);  
    	
        // ���ñ�ͷ
        table.getTableHeader().setFont(new Font(null, Font.BOLD, 20));  // ���ñ�ͷ����������ʽ
        table.getTableHeader().setForeground(Color.blue);                // ���ñ�ͷ����������ɫ
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
        
        Label = new JLabel(" �� �� �� Ϣ �� �� �� �� " ,JLabel.CENTER);
        Font f=new Font("������",Font.BOLD,30);
        Label.setFont(f);
        Label.setForeground(Color.BLACK);
        jp.add(Label, BorderLayout.NORTH);
        // ���� ������� �� ����
        JPanel functionPanel = new JPanel();
		return jp;
    }

//	����е�����
	private Vector createTableModelData() {
		Vector data = new Vector();
		String t=null;
		try{
			FileReader f1 = new FileReader("C:\\Users\\κ�Ӱ�\\Desktop\\bighomework\\src\\������Ϣ.txt");
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
		columnNames.add("���");
		columnNames.add("����ʱ��");
		columnNames.add("�γ�����");
		columnNames.add("���԰༶");
		columnNames.add("����");
		columnNames.add("�ص�");
		columnNames.add("��������");
		columnNames.add("�࿼1");
		columnNames.add("�࿼2");
		columnNames.add("����");   
		return columnNames;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
	}
}





