package gui.student.modules;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Module list ui.
 */
public class ModuleListUI extends JPanel implements ActionListener {

    private JTabbedPane jTabbedpane;
    // ��ǩ
    private String[] tabNames = { "Recent Module", "All" };
    private JPanel jpanelFirst, jpanelSecond;
    // ���
    private JTable moduleListTable1;
    private JTable moduleListTable2;





    private List<Module> moduleList = new ArrayList<Module>();
    private JTextField nameField, teacherField, termField;

    private JButton searchBtn, clearBtn;

    /**
     * Instantiates a new Module list ui.
     */
    public ModuleListUI(){
        this.setLayout(new BorderLayout());
        jTabbedpane = new JTabbedPane();// ���ѡ������
        this.add(jTabbedpane, BorderLayout.CENTER);
        this.initFirstTable();
        this.initSecondTable();
        this.initBottomBtns();
        this.renderCarData("", "", "");
        this.renderCarData2("", "", "");
    }

    /**
     * Init first table.
     */
    public void initFirstTable(){

        JPanel topPancel1 = new JPanel();
        topPancel1.setLayout(new FlowLayout());

        JLabel titleLabel = new JLabel("Modules Management");
        titleLabel.setFont(new Font("Times New Roman",Font.BOLD,30));
        topPancel1.add(titleLabel);
        this.add(topPancel1, BorderLayout.NORTH);

        moduleListTable1 = new JTable(0, 7);
        moduleListTable1.setRowHeight(50);
        moduleListTable1.getTableHeader().setFont(new Font(null, Font.BOLD, 18));  // ���ñ�ͷ����������ʽ
        moduleListTable1.setFont(new Font("����",Font.PLAIN,14));
        DefaultTableModel tableModel=(DefaultTableModel) moduleListTable1.getModel();
        tableModel.setColumnIdentifiers(new Object[]{"Module ID" ,"Module ����" , "�ο���ʦ" , "����ѧ��" , "�ȼ�" , "ѧ��" , "Module ����" });
        moduleListTable1.setModel(tableModel);

        // ����table���ݾ���
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);// �����Ͼ�����һ��
        moduleListTable1.setDefaultRenderer(Object.class, tcr);

        jpanelFirst = new JPanel();
        jpanelFirst.setLayout(new BorderLayout());
        jpanelFirst.add(moduleListTable1, BorderLayout.CENTER);

        jTabbedpane.addTab(tabNames[0], null, jpanelFirst, "first");// �����һ��ҳ��
        jTabbedpane.setMnemonicAt(0, KeyEvent.VK_0);// ���õ�һ��λ�õĿ�ݼ�Ϊ0

    }

    /**
     * Init second table.
     */
    public void initSecondTable(){

        JPanel topPancel2 = new JPanel();
        topPancel2.setLayout(new FlowLayout());

        JLabel titleLabel = new JLabel("Modules Management");
        titleLabel.setFont(new Font("����", Font.BOLD, 40));
        topPancel2.add(titleLabel);
        this.add(topPancel2, BorderLayout.NORTH);

        moduleListTable2 = new JTable(0, 7);
        moduleListTable2.setRowHeight(50);
        moduleListTable2.getTableHeader().setFont(new Font(null, Font.BOLD, 18));  // ���ñ�ͷ����������ʽ
        moduleListTable2.setFont(new Font("����",Font.PLAIN,14));
        DefaultTableModel tableModel2=(DefaultTableModel) moduleListTable2.getModel();
        tableModel2.setColumnIdentifiers(new Object[]{"Module ID" ,"Module Name" , "MO" , "Semester" , "Level" , "Credit" , "Module Process" });
        moduleListTable2.setModel(tableModel2);

        // ����table���ݾ���
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);// �����Ͼ�����һ��
        moduleListTable2.setDefaultRenderer(Object.class, tcr);


        jpanelSecond = new JPanel();
        jpanelSecond.setLayout(new BorderLayout());
        jpanelSecond.add(moduleListTable2, BorderLayout.CENTER);

        jTabbedpane.addTab(tabNames[0], null, jpanelFirst, "first");// �����һ��ҳ��
        jTabbedpane.setMnemonicAt(0, KeyEvent.VK_0);// ���õ�һ��λ�õĿ�ݼ�Ϊ0
    }

    /**
     * Init bottom btns.
     */
    public void initBottomBtns() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        this.add(bottomPanel , BorderLayout.SOUTH);

        JLabel label = new JLabel("Module Name��");
        bottomPanel.add(label);
        this.nameField = new JTextField(12);
        bottomPanel.add(this.nameField);
        label = new JLabel("MO��");
        bottomPanel.add(label);
        this.teacherField = new JTextField(12);
        bottomPanel.add(this.teacherField);
        label = new JLabel("Semester��");
        bottomPanel.add(label);
        this.termField = new JTextField(12);
        bottomPanel.add(this.termField);

        this.searchBtn = new JButton("Search");
        this.searchBtn.addActionListener(this);
        bottomPanel.add(this.searchBtn);

        this.clearBtn = new JButton("Clear");
        this.clearBtn.addActionListener(this);
        bottomPanel.add(this.clearBtn);
    }

    /**
     * Render car data.
     *
     * @param name        the name
     * @param teacherName the teacher name
     * @param termName    the term name
     */
    public void renderCarData(String name, String teacherName, String termName) {
        this.moduleList = ModuleData.readData(name, teacherName, termName);
        DefaultTableModel tableModel = (DefaultTableModel)this.moduleListTable1.getModel();
        DefaultTableModel tableModel2 = (DefaultTableModel)this.moduleListTable2.getModel();
        tableModel.setRowCount(0); // ��ʼ���������п����������ݵģ��������������һ��
//        "Module ID" ,"Module ����" , "�ο���ʦ" , "����ѧ��" , "�ȼ�" , "ѧ��" , "Module ����"
        tableModel2.setRowCount(0);
        for(Module module : this.moduleList) {
            tableModel.addRow(new Object[]{ module.getId() , module.getName() ,
            module.getTeacher(), module.getTerm(), module.getLevel(), module.getScore(), module.getProgress()});
            tableModel2.addRow(new Object[]{ module.getId() , module.getName() ,
                    module.getTeacher(), module.getTerm(), module.getLevel(), module.getScore(), module.getProgress()});
        }
        this.moduleListTable1.setModel(tableModel);
        this.moduleListTable2.setModel(tableModel2);
    }

    /**
     * Render car data 2.
     *
     * @param name        the name
     * @param teacherName the teacher name
     * @param termName    the term name
     */
    public void renderCarData2(String name, String teacherName, String termName) {
        this.moduleList = ModuleData.readData(name, teacherName, termName);
        DefaultTableModel tableModel2 = (DefaultTableModel)this.moduleListTable1.getModel();
         // ��ʼ���������п����������ݵģ��������������һ��
//        "Module ID" ,"Module ����" , "�ο���ʦ" , "����ѧ��" , "�ȼ�" , "ѧ��" , "Module ����"
        tableModel2.setRowCount(0);
        for(Module module : this.moduleList) {
            tableModel2.addRow(new Object[]{ module.getId() , module.getName() ,
                    module.getTeacher(), module.getTerm(), module.getLevel(), module.getScore(), module.getProgress()});
        }
        this.moduleListTable2.setModel(tableModel2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.searchBtn){
            String name = this.nameField.getText();
            String teacherName = this.teacherField.getText();
            String termName = this.termField.getText();
            this.renderCarData(name, teacherName, termName);
            this.renderCarData2(name, teacherName, termName);
        }else if(e.getSource() == this.clearBtn){
            this.nameField.setText("");
            this.teacherField.setText("");
            this.termField.setText("");
            this.renderCarData2("", "", "");
            this.renderCarData("", "", "");
        }
    }
}
