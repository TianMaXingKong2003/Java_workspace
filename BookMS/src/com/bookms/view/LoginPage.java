package com.bookms.view;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.bookms.dao.UserDao_Implement;
import com.bookms.model.User;
import com.bookms.util.StringUtils;

import javax.swing.JPasswordField;

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
					
					frame.setLocationRelativeTo(null);		//����Ļ��������ʾ
					
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
		
		
		// ����У�Nimbus	���Ƽ���	Windows		Metal
		
		//���ô��ڷ��
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
		
		
		//�ı�ϵͳĬ������
		
		
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
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setIcon(new ImageIcon(LoginPage.class.getResource("/images/logo.png")));
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 36));
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setFont(new Font("����", Font.PLAIN, 20));
		label.setIcon(new ImageIcon(LoginPage.class.getResource("/images/userName.png")));
		
		JLabel label_1 = new JLabel("\u5BC6 \u7801\uFF1A");
		label_1.setFont(new Font("����", Font.PLAIN, 20));
		label_1.setIcon(new ImageIcon(LoginPage.class.getResource("/images/password.png")));
		
		usernamefield = new JTextField();
		usernamefield.setFont(new Font("����", Font.PLAIN, 20));
		usernamefield.setColumns(10);
		
		JButton button = new JButton("\u6E05\u7A7A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				resetValueActionPerformd(e);
				
			}
		});
		button.setIcon(new ImageIcon(LoginPage.class.getResource("/images/reset.png")));
		button.setFont(new Font("����", Font.PLAIN, 30));
		
		JButton button_1 = new JButton("\u767B\u5F55");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loginActionPerformd(e);
			}
		});
		button_1.setIcon(new ImageIcon(LoginPage.class.getResource("/images/login.png")));
		button_1.setFont(new Font("����", Font.PLAIN, 30));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("����", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(123)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(label_1))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(passwordField)
								.addComponent(usernamefield, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
							.addGap(13))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(button)
							.addGap(99)
							.addComponent(button_1)
							.addGap(44)))
					.addContainerGap(104, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(153, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
					.addGap(146))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addComponent(lblNewLabel)
					.addGap(38)
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
						.addComponent(button_1))
					.addGap(49))
		);
		contentPane.setLayout(gl_contentPane);
	}

	
	//��¼��ť���¼�����
	protected void loginActionPerformd(ActionEvent e) {
		// TODO �Զ����ɵķ������
		
		String username = this.usernamefield.getText();
		
		String password = new String(this.passwordField.getPassword());
		
		if(StringUtils.isEmpty(username)) {
			
			JOptionPane.showMessageDialog(null, "�û�����������Ϊ��");
			
			return;
		}
		
		if(StringUtils.isEmpty(password)) {
			
			JOptionPane.showMessageDialog(null, "���벻��Ϊ��");
			
			return;
		}
		
		UserDao_Implement udi=new UserDao_Implement();
		
		User user= new User(username,password);
		
		int login_return=udi.login(user);
			
		System.out.println(login_return);
		
		
		switch (login_return) {
		case -2:
			JOptionPane.showMessageDialog(null, "�������������");
			return;
			
		case -1:
			JOptionPane.showMessageDialog(null, "���˺Ų�����");
			return;
			
		case 0:
			JOptionPane.showMessageDialog(null, "��¼�쳣���������ݿ�����");
			return;
			
		default:
			dispose();			//���ز��ͷŵ�¼���壬�����һ�����ڱ��ͷź����ܳ���Ҳ��֮���н���
			
			MainPage mainpage=new MainPage();		//��MainPageҳ��
			
			mainpage.setLocationRelativeTo(null);	//����Ļ��������ʾ
			
			//mainpage.setExtendedState(JFrame.MAXIMIZED_BOTH);//�������
			
			mainpage.setVisible(true);
		}
		
		
		
		//Java JFrame���ڹرշ����ܽ�
		//֮ǰд����ʱÿ�ζ���ֱ��copy�رյķ�����û����������ģ����д�Ĵ��ڱȽ϶࣬���ܽ���һЩ���ڹرյķ�������Щ�������Ժ��Լ����ġ�
		//public void setDefaultCloseOperation(int operation): 
		//Ĭ�Ϲر�״̬��JFrame.class��: private int defaultCloseOperation =HIDE_ON_CLOSE; 
		//��ˣ�Ĭ������£��رմ��ڣ�ֻ���ؽ��棬���ͷ�ռ�õ��ڴ档 
		//
		//����������Ͻǹرգ����ֹرշ�ʽ�� 
		//1.this.setDefaultCloseOperation(0);// DO_NOTHING_ON_CLOSE����ִ���κβ����� 
		//2.this.setDefaultCloseOperation(1);//HIDE_ON_CLOSE��ֻ���ؽ��棬setVisible(false)�� 
		//3.this.setDefaultCloseOperation(2);//DISPOSE_ON_CLOSE,���ز��ͷŴ��壬dispose()�������һ�����ڱ��ͷź������Ҳ��֮���н����� 
		//4.this.setDefaultCloseOperation(3);//EXIT_ON_CLOSE,ֱ�ӹر�Ӧ�ó���System.exit(0)��һ��main������Ӧһ�������� 
		
		
	}

	//���ð�ť���¼�����
	protected void resetValueActionPerformd(ActionEvent evt) {
		// TODO �Զ����ɵķ������
		
		this.usernamefield.setText("");
		
		this.passwordField.setText("");
		
	}
}
