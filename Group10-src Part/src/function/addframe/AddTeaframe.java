package function.addframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.Teachers;
import function.Function;
import function.judge;

/**
 * The type Add teaframe.
 */
public class AddTeaframe extends JFrame implements ActionListener {
    /**
     * The Add panel.
     */
    JPanel addPanel ,
    /**
     * The Text.
     */
    text;
    /**
     * The Tea power t.
     */
    JTextField teaPowerT,
    /**
     * The Tea account t.
     */
    teaAccountT,
    /**
     * The Tea name t.
     */
    teaNameT;
    /**
     * The T.
     */
    final int t = 25; //�����ĳ���
    /**
     * The Teaframe.
     */
    JFrame teaframe;
    /**
     * The Fun.
     */
    Function fun = new Function();
    /**
     * The Judge.
     */
    judge judge = new judge();
    /**
     * The Tea.
     */
    Teachers tea = new Teachers();
    /**
     * The Tlist.
     */
    ArrayList<Teachers> tlist = new ArrayList<Teachers>();

    /**
     * Instantiates a new Add teaframe.
     */
    public AddTeaframe() {
		Addteaframe();
	}

    /**
     * Addteaframe.
     */
    void Addteaframe() {
		teaframe = new JFrame();
		JLabel teaLabel = new JLabel();
		teaframe.setLayout(new BorderLayout());

		teaLabel = new JLabel(" �� �� �� ʦ �� Ϣ " , JLabel.CENTER);
		Font f=new Font("������",Font.BOLD,30);
		teaLabel.setFont(f);
		teaLabel.setForeground(Color.blue);
		teaframe.add(teaLabel, BorderLayout.NORTH);
		teaframe.setTitle("�����������");
		teaframe.setSize(990, 600);
		teaframe.setLocation(350, 200);
		teaframe.setLocationRelativeTo(null); //ʹ���ھ���
		teaframe.setVisible(true);
		addPanel = new JPanel();
		addPanel = addTeapanel();
		teaframe.add(addPanel, BorderLayout.CENTER);
	}

	private JPanel addTeapanel() {
		// TODO Auto-generated method stub
		JPanel teatext = new JPanel();

		JPanel teaName = teaName();
		JPanel teaAccount = teaAccount();
		JPanel teaPower = teaPower();
		addPanel = addButtonPanel();
		teatext.setLayout(new GridLayout(4,1));
		teatext.add(teaName);
		teatext.add(teaAccount);
		teatext.add(teaPower);
		teatext.add(addPanel);
		return teatext;
	}

	private JPanel teaPower() {
		// TODO Auto-generated method stub
		JPanel teaPowerPanel = new JPanel();
		JLabel teaPowerLabel = new JLabel("��    �룺");
		Font f=new Font("������",Font.BOLD,20);
		teaPowerLabel.setFont(f);
		teaPowerT = new JTextField(t);
		teaPowerPanel.add(teaPowerLabel);
		teaPowerPanel.add(teaPowerT);
		return teaPowerPanel;
	}
	private JPanel teaAccount() {
		// TODO Auto-generated method stub
		JPanel teaAccountpanel = new JPanel();
		JLabel teaAccountLabel = new JLabel("��    �ţ�");
		Font f=new Font("������",Font.BOLD,20);
		teaAccountLabel.setFont(f);
		teaAccountT = new JTextField(t);
		teaAccountpanel.add(teaAccountLabel);
		teaAccountpanel.add(teaAccountT);
		return teaAccountpanel;
	}
	private JPanel teaName() {
		// TODO Auto-generated method stub
		JPanel namePanel = new JPanel();
		JLabel nameLabel = new JLabel("��ʦ������");
		Font f=new Font("������",Font.BOLD,20);
		nameLabel.setFont(f);
		teaNameT = new JTextField(t);
		namePanel.add(nameLabel);
		namePanel.add(teaNameT);
		return namePanel;
	}
	private JPanel addButtonPanel() {
		// TODO Auto-generated method stub
		JPanel addButtonPanel = new JPanel();
		JButton addButton = new JButton("ȷ����ӽ�ʦ��Ϣ");
		addButton.addActionListener(this);
		addButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String teaName = teaNameT.getText();
				String teaAccount = teaAccountT.getText();
				String teaPower = teaPowerT.getText();

				if(teaName.equals("") || teaAccount.equals("") || teaPower.equals("")) {
					JOptionPane.showMessageDialog(null, "��ʦ��Ϣ���󣡣���\n\n���������룡����");
					return;
				}
				if(fun.findteacherID(teaAccount) == fun.findteacherName(teaName)) {
					JOptionPane.showMessageDialog(null,teaName+"����ʦ�����˺��Ѵ��ڣ�����\n\n������¼�룡����");
					System.out.print(fun.findteacherID(teaAccount)+"~"+fun.findteacherName(teaName));
					return;
				}
				if(fun.findteacherID(teaAccount) != -2 ) {
					JOptionPane.showMessageDialog(null,"���˺��Ѵ��ڣ�����\n\n������¼�룡����");
					System.out.print(fun.findteacherID(teaAccount));
					return;
				}
				tea.setteaName(teaName);
				tea.setteaID(teaAccount);
				tea.setteaPOW(teaPower);


				System.out.println("��Ϣ����Ա");
				System.out.println(tea.fileTeaString());
				fun.addTeacher(tea);
				fun.write_teacherfile();

				JOptionPane.showMessageDialog(null, "¼��ɹ�������");
				teaframe.dispose();
			}
		});
		addButtonPanel.add(addButton);
		return addButtonPanel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
	}
}