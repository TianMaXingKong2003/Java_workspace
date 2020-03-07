
package com.bookms.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;

public class MainPage extends JFrame {

	private JPanel contentPane;
	
	JDesktopPane table = new JDesktopPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					
					frame.setLocationRelativeTo(null);		//在屏幕的中央显示
					
					//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);//窗体最大化
					
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
	public MainPage() {
		
		
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
		

		setIconImage(Toolkit.getDefaultToolkit().getImage(MainPage.class.getResource("/images/logo.png")));
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u9875\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1125, 671);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
		menu.setIcon(new ImageIcon(MainPage.class.getResource("/images/base.png")));
		menu.setBackground(Color.LIGHT_GRAY);
		menuBar.add(menu);
		
		JMenu menu_2 = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		menu_2.setIcon(new ImageIcon(MainPage.class.getResource("/images/bookTypeManager.png")));
		menu.add(menu_2);
		
		JMenuItem menuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		menuItem_1.setIcon(new ImageIcon(MainPage.class.getResource("/images/add.png")));
		menu_2.add(menuItem_1);
		
		JMenuItem menuItem_8 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u4FEE\u6539");
		menuItem_8.setIcon(new ImageIcon(MainPage.class.getResource("/images/edit.png")));
		menu_2.add(menuItem_8);
		
		JMenuItem menuItem_3 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u5220\u9664");
		menuItem_3.setIcon(new ImageIcon(MainPage.class.getResource("/images/delete.png")));
		menu_2.add(menuItem_3);
		
		JMenu menu_3 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		menu_3.setIcon(new ImageIcon(MainPage.class.getResource("/images/bookManager.png")));
		menu.add(menu_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u6DFB\u52A0\u56FE\u4E66");
		menuItem_4.setIcon(new ImageIcon(MainPage.class.getResource("/images/add.png")));
		menu_3.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("\u5220\u9664\u56FE\u4E66");
		menuItem_5.setIcon(new ImageIcon(MainPage.class.getResource("/images/delete.png")));
		menu_3.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("\u4FEE\u6539\u56FE\u4E66");
		menuItem_6.setIcon(new ImageIcon(MainPage.class.getResource("/images/edit.png")));
		menu_3.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("\u67E5\u627E\u56FE\u4E66");
		menuItem_7.setIcon(new ImageIcon(MainPage.class.getResource("/images/search.png")));
		menu_3.add(menuItem_7);
		
		JMenuItem menuItem = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int result = JOptionPane.showConfirmDialog(null, "是否完全退出", "提示", JOptionPane.OK_OPTION);
				
				//System.out.println(result);		0	是		1	否
				
				if (result==0) {
					dispose();	//隐藏并释放登录窗体，当最后一个窗口被释放后，则总程序也随之运行结束
				}
				
				
			}
		});
		menuItem.setIcon(new ImageIcon(MainPage.class.getResource("/images/exit.png")));
		menu.add(menuItem);
		
		JMenu menu_1 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		menu_1.setIcon(new ImageIcon(MainPage.class.getResource("/images/about.png")));
		menu_1.setBackground(Color.LIGHT_GRAY);
		menuBar.add(menu_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u4F5C\u8005\uFF1A\u5929\u9A6C\u884C\u7A7A");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				InterPage interPage = new InterPage();
				
				//interPage.setExtendedState(JFrame.MAXIMIZED_BOTH);//窗体最大化
				
				interPage.setVisible(true);
				
				
				table.add(interPage);			//打开内部窗体
				
				
				//JInternalFrame窗口最大化，需要在添加到JFrame的DesktopPane之后设置
				
				
				try {
					interPage.setMaximum(true);
				} catch (PropertyVetoException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainPage.class.getResource("/images/me.png")));
		menu_1.add(menuItem_2);
		
		JMenuItem menuItem_9 = new JMenuItem("\u7F51\u9875\u67E5\u770B");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		menuItem_9.setIcon(new ImageIcon(MainPage.class.getResource("/images/search.png")));
		menu_1.add(menuItem_9);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		contentPane.add(table, BorderLayout.CENTER);
	}
}
