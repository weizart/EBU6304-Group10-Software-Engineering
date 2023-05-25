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
        // ���ó��������󴰿ھ��У�û��������䣬����Ĭ�������Ͻ�
        this.setLocationRelativeTo(null);
        // ���õ�����ڵĹرհ�ť���ɽ�������
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        // ���ô���������ΪborderLayout
        this.setLayout(new BorderLayout());
        // ���ô��ڲ������ �ı�ߴ�
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
