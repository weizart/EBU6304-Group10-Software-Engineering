package reviseframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.Teachers;
import function.Function;
import function.judge;

/**
 * �޸Ľ�ʦ�˺���Ϣ
 * @author ASUS
 *
 */
public class Revise_Teacher extends JFrame implements ActionListener {
	final int t = 25; //�����ĳ���
	
	Function fun = new Function();
	Teachers tea = new Teachers();
	judge judge = new judge();
	ArrayList<Teachers> tlist = new ArrayList<Teachers>();
	JFrame jf ;
	JLabel jl ;
	JPanel addPanel , text;
	JComboBox<String> cmb1,cmb2;
//	����textPanel-����
	JTextField nameT , idT , powT ,NewidT , NewpowT; 
	JButton addButton ;
	
	public Revise_Teacher() {
		createtitle();
	}
	void createtitle() {
		jf = new JFrame();
		jf.setLayout(new BorderLayout());
		
		jl = new JLabel(" �� �� �� ʦ �� �� �� Ϣ  " , JLabel.CENTER);
		Font f=new Font("������",Font.BOLD,30);
		jl.setFont(f);
		jl.setForeground(Color.blue);
		jf.add(jl, BorderLayout.NORTH);
		jf.setTitle("��ʦ�˺Ź���");
		jf.setSize(990, 600);
		jf.setLocation(350, 200);
		jf.setLocationRelativeTo(null); //ʹ���ھ���
		jf.setVisible(true);   
		addPanel = new JPanel();
		addPanel = addpanel();
		jf.add(addPanel, BorderLayout.CENTER);		
	}
	private JPanel addpanel() {
		text = new JPanel();	
		JPanel nameT = namePanel();
		JPanel idT = idT();
		JPanel powT = powT();
		JPanel newid = NewidT();
		JPanel newpow = NewpowT();
		addPanel = addButtonPanel();
		text.setLayout(new GridLayout(6,1));
		text.add(nameT);
		text.add(idT);
		text.add(newid);
		text.add(newpow);
		text.add(addPanel);
		return text;
	}
	private JPanel idT() {
		// TODO Auto-generated method stub
		JPanel idPanel = new JPanel();
		JLabel idLabel = new JLabel("�ɽ�ʦ�˺ţ�");
		Font f=new Font("������",Font.BOLD,20);
		idLabel.setFont(f);
		idT = new JTextField(t);
		idPanel.add(idLabel);
		idPanel.add(idT);
		return idPanel;
	}
	private JPanel powT() {
		// TODO Auto-generated method stub
		JPanel powPanel = new JPanel();
		JLabel powLabel = new JLabel("���˺����룺");
		Font f=new Font("������",Font.BOLD,20);
		powLabel.setFont(f);
		powT = new JTextField(t);
		powPanel.add(powLabel);
		powPanel.add(powT);
		return powPanel;
	}
	private JPanel namePanel() {
		// TODO Auto-generated method stub
		JPanel namePanel = new JPanel();
		JLabel nameLabel = new JLabel("��ʦ������");
		Font f=new Font("������",Font.BOLD,20);
		nameLabel.setFont(f);
		nameT = new JTextField(t);
		namePanel.add(nameLabel);
		namePanel.add(nameT);
		return namePanel;
	}
	private JPanel NewidT() {
		// TODO Auto-generated method stub
		JPanel idPanel = new JPanel();
		JLabel idLabel = new JLabel("�½�ʦ�˺ţ�");
		Font f=new Font("������",Font.BOLD,20);
		idLabel.setFont(f);
		NewidT = new JTextField(t);
		idPanel.add(idLabel);
		idPanel.add(NewidT);
		return idPanel;
	}
	private JPanel NewpowT() {
		// TODO Auto-generated method stub
		JPanel powPanel = new JPanel();
		JLabel powLabel = new JLabel("���˺����룺");
		Font f=new Font("������",Font.BOLD,20);
		powLabel.setFont(f);
		NewpowT = new JTextField(t);
		powPanel.add(powLabel);
		powPanel.add(NewpowT);
		return powPanel;
	}

	JPanel addButtonPanel() {
		JPanel addButtonPanel = new JPanel();
		addButton = new JButton("ȷ���޸Ŀ���");
		addButton.addActionListener(this);
		addButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String Tname = nameT.getText();
				String Tid = idT.getText();
				String Tpower = powT.getText();
				String Newid = NewidT.getText();
				String Newpow = NewpowT.getText();
				if(Tname.isEmpty()||Tid.isEmpty()||Newid.isEmpty()||Newpow.isEmpty()) {
					JOptionPane.showMessageDialog(null, "����Ϊ�ջ��������󣡣���\n\n����������");
					return;
				}
				int flag1 =fun.findteacherName(Tname);
				int flag2 = fun.findteacherID(Tid);		
				if(flag1 != flag2) {
					JOptionPane.showMessageDialog(null, "δ���ҵ��ÿ�����Ϣ������\n\n����������"); 
					return;
				}else {
					tea.setteaName(Tname);
					tea.setteaID(Newid);
					tea.setteaPOW(Newpow);
					fun.update2(tea);       //�޸�
					Boolean t = fun.write_teacherfile();
					if(t==true) {
						JOptionPane.showMessageDialog(null, "�޸ĳɹ�������");
						jf.dispose();	
					}	
				}			
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