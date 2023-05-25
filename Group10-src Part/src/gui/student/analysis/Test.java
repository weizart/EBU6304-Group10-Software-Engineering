package gui.student.analysis;

import javax.swing.*;
import java.awt.*;

/**
 * The type Test.
 */
public class Test extends JFrame {
    /**
     * Instantiates a new Test.
     */
    public Test(){
        this.setTitle("");
        this.setSize(700,600);
        // 设置程序启动后窗口居中，没有下面这句，窗口默认在左上角
        this.setLocationRelativeTo(null);
        // 设置点击窗口的关闭按钮，可结束程序
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        // 设置窗口主布局为borderLayout
        this.setLayout(new BorderLayout());
        // 设置窗口不能最大化 改变尺寸
        this.setResizable (false);
        ScoreListUI ui = new ScoreListUI();
        this.add(ui);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        new Test().setVisible(true);
    }
}
