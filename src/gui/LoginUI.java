package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

import entity.Examwork;
import entity.Students;
import entity.Teachers;
import function.Function;

public class LoginUI extends JFrame implements ActionListener	{
	private JLabel TestnameLabel, LoginLabel_ID , LoginLabel_POW,bg;
	private JTextField Logintext_ID; 
	private JPasswordField Logintext_POW;
	private JButton Button_Login , Button_Reset ,Button_Quit;
	private JRadioButton ManRadio , TeaRadio , StuRadio;

	ArrayList<Examwork> array = new ArrayList<Examwork>();
	ArrayList<Teachers> tlist = new ArrayList<Teachers>();
	ArrayList<Students> slist = new ArrayList<Students>();
	
	Function fun = new Function();
	// 管理员账号：admin和密码：123456
    final String MANAGER_ID = "admin" ;
   	final String MANAGER_POW = "123456";

   	public LoginUI() {
   		TestnameLabel = new JLabel("<html><body><p align=\"Center\">Student<br/>Learning<br/>System<br/>______________________<br/></p><h2 align=\"Center\">EBU6304 Group10</h2></body></html>" , JLabel.CENTER);
    	Font f=new Font("Times New Roman",Font.BOLD,55);
    	TestnameLabel.setFont(f);
    	TestnameLabel.setForeground(Color.BLACK);

		//图片控件
		ImageIcon background = new ImageIcon("C:\\Users\\魏子昂\\Desktop\\bighomework\\src\\img\\Login.png");
		JLabel backImage = new JLabel(background);
		backImage.setBounds(0, 0, background.getIconWidth(),background.getIconHeight());
		JPanel backPanel = (JPanel) this.getContentPane();
		backPanel.setOpaque(false);
		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(backImage, new Integer(Integer.MIN_VALUE));

        this.setLayout(new BorderLayout());
        this.add(TestnameLabel, BorderLayout.WEST);

        JPanel controlPanel = createControlPanel();
        this.add(controlPanel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("SLS-Group10");
        this.setSize(1000, 500);
        this.setLocation(350, 200);
        this.setVisible(true);
        //禁止最大化
        this.setResizable(false);
        //使窗口居中显示
        this.setLocationRelativeTo(null);
    }
    JPanel createControlPanel() {
        JPanel controlPanel = new JPanel();
        JPanel textPanel_1 = createTextControl_1();
        JPanel textPanel_2 = createTextControl_2();
        JPanel radioPanel = createRadioControl();
        JPanel buttonPanel = createButtonControl();
        // 设置布局
//		this.setContentPane(new background());
        controlPanel.setLayout(new GridLayout(4, 1));
		controlPanel.add(radioPanel);
		controlPanel.add(textPanel_1);
        controlPanel.add(textPanel_2);

        controlPanel.add(buttonPanel);
        // 添加边框
        controlPanel.setBorder(new EtchedBorder());
        return controlPanel;
    }   
	JPanel createButtonControl() {
        JPanel LoginPanel_3 = new JPanel();
        Button_Login = new JButton("Login");
    	Button_Reset = new JButton("Reset");
    	Button_Quit = new JButton("Exit");
    	LoginPanel_3.add(Button_Login);
    	LoginPanel_3.add(Button_Reset);
    	LoginPanel_3.add(Button_Quit);
    	
    	//实现对按钮的事件监控
    	Button_Login.addActionListener(this);
    	Button_Reset.addActionListener(this);
    	Button_Quit.addActionListener(this);
        return LoginPanel_3;
    }
    JPanel createRadioControl() {
    	JPanel LoginPanel_2 = new JPanel();
    	ManRadio = new JRadioButton("Admin");
    	TeaRadio = new JRadioButton("Teacher");
    	StuRadio = new JRadioButton("Student");
    	StuRadio.setSelected(true);
    	ButtonGroup group = new ButtonGroup();
        group.add(ManRadio);
        group.add(TeaRadio);
        group.add(StuRadio);
        LoginPanel_2.add(ManRadio);
        LoginPanel_2.add(TeaRadio);
        LoginPanel_2.add(StuRadio);
        
        ManRadio.addActionListener(this);
        TeaRadio.addActionListener(this);
        StuRadio.addActionListener(this);
    	return	LoginPanel_2;	
    } 
    JPanel createTextControl_1() {
    	JPanel LoginPanel_1 = new JPanel();
    	LoginLabel_ID = new JLabel("ID number：" );
    	Logintext_ID = new JTextField(20); 
    	LoginPanel_1.add(LoginLabel_ID);
    	LoginPanel_1.add(Logintext_ID);	
    	return LoginPanel_1;
    }
    JPanel createTextControl_2() {
    	JPanel LoginPanel_1 = new JPanel();
    	LoginLabel_POW = new JLabel("password：" );
    	Logintext_POW = new JPasswordField(20);
    	
    	LoginPanel_1.add(LoginLabel_POW);
    	LoginPanel_1.add(Logintext_POW);
    	return LoginPanel_1;
    }
   	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="Login") {
    		if(ManRadio.isSelected()) {  
    			manLogin();  							
    		}
    		else if(TeaRadio.isSelected()) {  
    			teaLogin();  								
    		}
    		else if(StuRadio.isSelected()) {  
    			stuLogin();  								
    		}    
    	}
    	else if(e.getActionCommand()=="Reset") {
    		clearText();  
    	} 
    	else if(e.getActionCommand()=="Exit") {
    		System.exit(0);
    	}
    }
   	
   	private void manLogin() {
   		String ID =Logintext_ID.getText();
   	    String POWER = String.valueOf(Logintext_POW.getPassword());
    	if(MANAGER_ID.equals(ID) && MANAGER_POW.equals(POWER)) {
    		dispose(); 
            new ManagerJFrame();     
    	}
    	else if (ID.isEmpty() && POWER.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Input ID and password","Attention",JOptionPane.WARNING_MESSAGE);
    	}
    	else if (ID.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Input ID","Attention",JOptionPane.WARNING_MESSAGE);  
    	}
    	else if (POWER.isEmpty()) {
    		JOptionPane.showMessageDialog(null,"Input password.","Attention",JOptionPane.WARNING_MESSAGE);  
        }
    	else  {  
            JOptionPane.showMessageDialog(null,"Wrong ID/password.\nTry again!","Attention",JOptionPane.ERROR_MESSAGE);  
            clearText();  
        }  	
	}

	private void teaLogin() {
		String ID =Logintext_ID.getText();
   	    String POWER = String.valueOf(Logintext_POW.getPassword());
   	    if (ID.isEmpty() && POWER.isEmpty()) {
   	    	JOptionPane.showMessageDialog(null,"Input ID and password","Attention",JOptionPane.WARNING_MESSAGE);  
   	    }else if (ID.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Input ID","Attention",JOptionPane.WARNING_MESSAGE);  
    	}else if (POWER.isEmpty()) {
    		JOptionPane.showMessageDialog(null,"Input password.","Attention",JOptionPane.WARNING_MESSAGE);  
        }else if(fun.findteacherID(ID) == fun.findteacherPow(POWER)) {
        	dispose(); 
            new TeacherUI();
    	}else  {  
            JOptionPane.showMessageDialog(null,"Wrong ID/password.\nTry again!","Attention",JOptionPane.ERROR_MESSAGE);   
            clearText();  
        }  
	}

	private void stuLogin() {
   		String ID =Logintext_ID.getText();
   	    String POWER = String.valueOf(Logintext_POW.getPassword());
   	    if (ID.isEmpty() && POWER.isEmpty()) {
   	    	JOptionPane.showMessageDialog(null,"Input ID and password","Attention",JOptionPane.WARNING_MESSAGE);  
   	    }else if (ID.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Input ID","Attention",JOptionPane.WARNING_MESSAGE);  
    	}else if (POWER.isEmpty()) {
    		JOptionPane.showMessageDialog(null,"Input password.","Attention",JOptionPane.WARNING_MESSAGE);  
        }else if(fun.findstudentID(ID) == fun.findstudentPow(POWER)) {
        	dispose(); 
            new StudentsUI();
    	}else  {  
            JOptionPane.showMessageDialog(null,"Wrong ID/password.\nTry again!","Attention",JOptionPane.ERROR_MESSAGE);   
            clearText();  
        }  
	}
	public void clearText() {
    	Logintext_ID.getText();
    	Logintext_ID.setText(null);
    	Logintext_POW.getPassword();
    	Logintext_POW.setText(null);	
	}
	static class background extends JPanel{
		ImageIcon img = new ImageIcon("C:\\Users\\魏子昂\\Desktop\\bighomework\\src\\img\\login.png");

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(img.getImage(),0,0,this.getWidth(),this.getHeight(),this);
			//g.drawImage(图片,x坐标,y坐标,宽,长,null);
		}
	}
	static class LoginBG extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			ImageIcon img = new ImageIcon("C:\\Users\\魏子昂\\Desktop\\bighomework\\src\\img\\login.png");
			g.drawImage(img.getImage(),0,0,this.getWidth(),this.getHeight(),this);
		}
	}

}
