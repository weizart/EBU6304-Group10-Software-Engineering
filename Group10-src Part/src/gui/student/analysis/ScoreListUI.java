package gui.student.analysis;

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
 * The type Score list ui.
 */
public class ScoreListUI extends JPanel implements ActionListener {

    /**
     * The constant dataPath.
     */
    public static final String dataPath = "C:\\Users\\魏子昂\\Desktop\\bighomework\\src\\";
    private JTabbedPane jTabbedpane;
    // 标签
    private String[] tabNames = { "Grades", "Analysis" };
    private JPanel jpanelFirst, jpanelSecond;
    // 表格
    private JTable scoreListTable;
    private JTable scoreListTable2;

    private List<Score> scoreList = new ArrayList<Score>();
    private List<Score> scoreList2 = new ArrayList<Score>();
    /**
     * The Rb 1.
     */
    JRadioButton rb1,
    /**
     * The Rb 2.
     */
    rb2;
    /**
     * The Min score field.
     */
    JTextField minScoreField,
    /**
     * The Max score field.
     */
    maxScoreField;

    private JButton searchBtn;

    /**
     * Instantiates a new Score list ui.
     */
    public ScoreListUI(){
        this.setLayout(new BorderLayout());
        jTabbedpane = new JTabbedPane();// 存放选项卡的组件
        this.add(jTabbedpane, BorderLayout.CENTER);
        this.initFirstTable();
        this.initSecondTable();
        this.initSearch();
        this.renderData("", "" , "");
        this.renderData2();
    }

    /**
     * Init first table.
     */
    public void initFirstTable(){
        // https://blog.csdn.net/sweetgirl520/article/details/51346263
        // 第一个表格
        scoreListTable = new JTable(0, 3);
        scoreListTable.setRowHeight(50);
        scoreListTable.getTableHeader().setFont(new Font(null, Font.BOLD, 18));  // 设置表头名称字体样式
        scoreListTable.setFont(new Font("宋体",Font.PLAIN,14));

        DefaultTableModel tableModel=(DefaultTableModel) scoreListTable.getModel();
        tableModel.setColumnIdentifiers(new Object[]{"Module Name" , "Grade" , "Rank" });
        scoreListTable.setModel(tableModel);
        JScrollPane wrapper = new JScrollPane(scoreListTable);

        // 设置table内容居中
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
        scoreListTable.setDefaultRenderer(Object.class, tcr);

        // 第一个面板
        jpanelFirst = new JPanel();
        jpanelFirst.setLayout(new BorderLayout());
        jpanelFirst.add(wrapper, BorderLayout.CENTER);
        // 把第一个表格加入第一个面板中
        jTabbedpane.addTab(tabNames[0], null, jpanelFirst, "first");// 加入第一个页面
        jTabbedpane.setMnemonicAt(0, KeyEvent.VK_0);// 设置第一个位置的快捷键为0
    }

    /**
     * Init second table.
     */
    public void initSecondTable(){
        // 第二个表格
        scoreListTable2 = new JTable(0, 5);
        scoreListTable2.setRowHeight(50);
        scoreListTable2.getTableHeader().setFont(new Font(null, Font.BOLD, 18));  // 设置表头名称字体样式
        scoreListTable2.setFont(new Font("宋体",Font.PLAIN,14));
        DefaultTableModel tableModel2=(DefaultTableModel) scoreListTable2.getModel();
        tableModel2.setColumnIdentifiers(new Object[]{" ","Freshman" , "Sopomore" , "Junior","Senior" });
        scoreListTable2.setModel(tableModel2);
        JScrollPane wrapper2 = new JScrollPane(scoreListTable2);

        // 设置table内容居中
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
        scoreListTable2.setDefaultRenderer(Object.class, tcr);

        // 第二个面板
        jpanelSecond = new JPanel();
        jpanelSecond.setLayout(new BorderLayout());
        jpanelSecond.add(wrapper2, BorderLayout.CENTER);

        jTabbedpane.addTab(tabNames[1], null, jpanelSecond, "second");// 加入第二个页面
        jTabbedpane.setMnemonicAt(1, KeyEvent.VK_1);// 设置第一个位置的快捷键为1

        this.add(jTabbedpane, BorderLayout.CENTER);
    }

    /**
     * Init search.
     */
    public void initSearch() {
        JPanel searchWrapper = new JPanel();
        searchWrapper.setLayout(new GridLayout(3,1));
        jpanelFirst.add(searchWrapper, BorderLayout.SOUTH);

        JPanel firstRow = new JPanel();
        firstRow.setLayout(new FlowLayout(FlowLayout.LEFT));
        searchWrapper.add(firstRow);

        JLabel label = new JLabel("Fort:");
        firstRow.add(label);
        rb1=new JRadioButton("High to Low");
        rb2=new JRadioButton("Low to High");
        ButtonGroup group=new ButtonGroup();
        group.add(rb1);
        group.add(rb2);
        firstRow.add(rb1);
        firstRow.add(rb2);

        JPanel secondRow = new JPanel();
        secondRow.setLayout(new FlowLayout(FlowLayout.LEFT));
        label = new JLabel("Period:");
        secondRow.add(label);
        minScoreField = new JTextField(5);
        secondRow.add(minScoreField);
        label = new JLabel("to");
        secondRow.add(label);
        maxScoreField = new JTextField(5);
        secondRow.add(maxScoreField);
        searchWrapper.add(secondRow);

        JPanel thirdRow = new JPanel();
        thirdRow.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.searchBtn = new JButton("Search");
        this.searchBtn.addActionListener(this);
        thirdRow.add(this.searchBtn);
        searchWrapper.add(thirdRow);
    }

    /**
     * Render data.
     *
     * @param orderBy  the order by
     * @param minScore the min score
     * @param maxScore the max score
     */
    public void renderData(String orderBy, String minScore , String maxScore) {
        this.scoreList = ScoreData.readData(orderBy , minScore , maxScore);
        DefaultTableModel tableModel = (DefaultTableModel)this.scoreListTable.getModel();
        tableModel.setRowCount(0); // 初始化，里面有可能是有内容的，所以在这里清空一下
        for(Score score : this.scoreList) {
            tableModel.addRow(new Object[]{ score.getModule() , score.getScore() , score.getRank()});
        }
        this.scoreListTable.setModel(tableModel);
    }

    /**
     * Render data 2.
     */
    public void renderData2() {
        this.scoreList2 = ScoreData.readData2();
        DefaultTableModel tableModel = (DefaultTableModel)this.scoreListTable2.getModel();
        tableModel.setRowCount(0); // 初始化，里面有可能是有内容的，所以在这里清空一下
        for(Score score : this.scoreList2) {
            tableModel.addRow(new Object[]{ score.getModule() , score.getScore() , score.getRank()});
        }
        this.scoreListTable2.setModel(tableModel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.searchBtn){
            String orderBy = "";
            if(rb1.isSelected()){
                // 从高到低
                orderBy = "desc";
            }else if(rb2.isSelected()){
                // 从低到高
                orderBy = "asc";
            }
            String min = this.minScoreField.getText();
            String max = this.maxScoreField.getText();
            this.renderData(orderBy, min, max);
        }
    }
}
