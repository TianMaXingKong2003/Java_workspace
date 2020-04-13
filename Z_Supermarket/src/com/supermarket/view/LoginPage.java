package com.supermarket.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.supermarket.dao.UserDao_Implement;
import com.supermarket.model.User;
import com.supermarket.util.StringUtils;

import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField usernamefield;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
					
				try {
					LoginPage frame = new LoginPage();
					
					frame.setLocationRelativeTo(null);		//在屏幕的中央显示
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		
		
		// 风格有：Nimbus	（推荐）	Windows		Metal
		
		//设置窗口风格
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(Exception e) {
        	System.out.println(e);
        }
		
		
		//改变系统默认字体
		
		
		Font font = new Font("Dialog", Font.PLAIN, 12);
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginPage.class.getResource("/images/logo.png")));
		setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setTitle("\u8D85\u5E02\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u8D85\u5E02\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setIcon(new ImageIcon(LoginPage.class.getResource("/images/logo.png")));
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 36));
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setFont(new Font("楷体", Font.PLAIN, 20));
		label.setIcon(new ImageIcon(LoginPage.class.getResource("/images/userName.png")));
		
		JLabel label_1 = new JLabel("\u5BC6 \u7801\uFF1A");
		label_1.setFont(new Font("楷体", Font.PLAIN, 20));
		label_1.setIcon(new ImageIcon(LoginPage.class.getResource("/images/password.png")));
		
		usernamefield = new JTextField();
		usernamefield.setFont(new Font("楷体", Font.PLAIN, 20));
		usernamefield.setColumns(10);
		
		JButton button = new JButton("\u6E05\u7A7A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				resetValueActionPerformd(e);
				
			}
		});
		button.setIcon(new ImageIcon(LoginPage.class.getResource("/images/reset.png")));
		button.setFont(new Font("楷体", Font.PLAIN, 30));
		
		////登录按钮点击
		JButton button_1 = new JButton("\u767B\u5F55");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loginActionPerformd(e);
			}
		});
		button_1.setIcon(new ImageIcon(LoginPage.class.getResource("/images/login.png")));
		button_1.setFont(new Font("楷体", Font.PLAIN, 30));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 20));
		
		
		//注册按钮点击
		JButton button_1_1 = new JButton("\u6CE8\u518C");
		button_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				registerActionPerformd(arg0);
				
			}

		});
		button_1_1.setIcon(new ImageIcon(LoginPage.class.getResource("/images/add.png")));
		button_1_1.setFont(new Font("楷体", Font.PLAIN, 30));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(123, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(label)
										.addComponent(label_1))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(passwordField, 258, 258, 258)
										.addComponent(usernamefield, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(button_1_1)
									.addGap(18)
									.addComponent(button_1)
									.addGap(20)
									.addComponent(button)))
							.addGap(106))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
							.addGap(135))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(51)
					.addComponent(lblNewLabel)
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(usernamefield, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1)
						.addComponent(button_1_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	

	//登录按钮的事件处理
	protected void registerActionPerformd(ActionEvent e) {
		// TODO 自动生成的方法存根
		
		String username = this.usernamefield.getText();
		
		String password = new String(this.passwordField.getPassword());
		
		if(StringUtils.isEmpty(username)) {
			
			JOptionPane.showMessageDialog(null, "用户名不不可以为空");
			
			return;
		}
		
		if(StringUtils.isEmpty(password)) {
			
			JOptionPane.showMessageDialog(null, "密码不能为空");
			
			return;
		}
		
		UserDao_Implement udi=new UserDao_Implement();
		
		User user= new User(username,password);
		
		boolean login_return=udi.insert(user);
			
		System.out.println(login_return);
		
		if (login_return) {
			
			JOptionPane.showMessageDialog(null, "注册成功");
			
		}else {
			JOptionPane.showMessageDialog(null, "用户名已存在");
		}
		
		
		
		
	}
	
	//登录按钮的事件处理
	protected void loginActionPerformd(ActionEvent e) {
		// TODO 自动生成的方法存根
		
		String username = this.usernamefield.getText();
		
		String password = new String(this.passwordField.getPassword());
		
		if(StringUtils.isEmpty(username)) {
			
			JOptionPane.showMessageDialog(null, "用户名不不可以为空");
			
			return;
		}
		
		if(StringUtils.isEmpty(password)) {
			
			JOptionPane.showMessageDialog(null, "密码不能为空");
			
			return;
		}
		
		UserDao_Implement udi=new UserDao_Implement();
		
		User user= new User(username,password);
		
		int login_return=udi.login(user);
			
		System.out.println(login_return);
		
		
		switch (login_return) {
		case -2:
			JOptionPane.showMessageDialog(null, "输入的密码有误");
			return;
			
		case -1:
			JOptionPane.showMessageDialog(null, "此账号不存在");
			return;
			
		case 0:
			JOptionPane.showMessageDialog(null, "登录异常，请检查数据库连接");
			return;
			
		case 1:
			dispose();			//隐藏并释放登录窗体，当最后一个窗口被释放后，则总程序也随之运行结束
			MainPage mainpage=new MainPage();		//管理员MainPage页面
				
			
			mainpage.setLocationRelativeTo(null);	//在屏幕的中央显示
			
			//mainpage.setExtendedState(JFrame.MAXIMIZED_BOTH);//窗体最大化
			
			mainpage.setVisible(true);
			
			break;
		
		case 2:
			dispose();			//隐藏并释放登录窗体，当最后一个窗口被释放后，则总程序也随之运行结束
			
			MainPage_user mainPage_user=new MainPage_user();		//用户MainPage_user页面
	
			mainPage_user.setLocationRelativeTo(null);	//在屏幕的中央显示
			
			//mainpage.setExtendedState(JFrame.MAXIMIZED_BOTH);//窗体最大化
			
			mainPage_user.setVisible(true);
				
			break;
		 
		default:
			JOptionPane.showMessageDialog(null, "登录异常，请检查数据库连接");
			return;
		}
		
		
		
		//Java JFrame窗口关闭方法总结
		//之前写窗口时每次都是直接copy关闭的方法，没有想过其它的，最近写的窗口比较多，就总结了一些窗口关闭的方法有哪些，方便以后自己查阅。
		//public void setDefaultCloseOperation(int operation): 
		//默认关闭状态：JFrame.class中: private int defaultCloseOperation =HIDE_ON_CLOSE; 
		//因此，默认情况下，关闭窗口，只隐藏界面，不释放占用的内存。 
		//
		//点击窗口右上角关闭，四种关闭方式： 
		//1.this.setDefaultCloseOperation(0);// DO_NOTHING_ON_CLOSE，不执行任何操作。 
		//2.this.setDefaultCloseOperation(1);//HIDE_ON_CLOSE，只隐藏界面，setVisible(false)。 
		//3.this.setDefaultCloseOperation(2);//DISPOSE_ON_CLOSE,隐藏并释放窗体，dispose()，当最后一个窗口被释放后，则程序也随之运行结束。 
		//4.this.setDefaultCloseOperation(3);//EXIT_ON_CLOSE,直接关闭应用程序，System.exit(0)。一个main函数对应一整个程序。 
		
		
	}
	

	//重置按钮的事件处理
	protected void resetValueActionPerformd(ActionEvent evt) {
		// TODO 自动生成的方法存根
		
		this.usernamefield.setText("");
		
		this.passwordField.setText("");
		
	}
}
