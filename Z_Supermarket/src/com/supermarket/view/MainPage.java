
package com.supermarket.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.supermarket.view.GoodsAddInterFrm;
import com.supermarket.view.GoodsManageInterFrm;
import com.supermarket.view.GoodsTypeManageInterFrm;

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
		
		UserManageInterFrm userManageInterFrm=new UserManageInterFrm();
		userManageInterFrm.setLocation(301, 34);
		userManageInterFrm.setVisible(true);
		table.add(userManageInterFrm);
		

		setIconImage(Toolkit.getDefaultToolkit().getImage(MainPage.class.getResource("/images/logo.png")));
		setTitle("\u8D85\u5E02\u7BA1\u7406\u7CFB\u7EDF\uFF08\u7BA1\u7406\u5458\u6A21\u5F0F\uFF09");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1125, 671);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//基本数据维护
		JMenu menu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
		menu.setIcon(new ImageIcon(MainPage.class.getResource("/images/base.png")));
		menu.setBackground(Color.LIGHT_GRAY);
		menuBar.add(menu);
		
			//用户管理
		JMenuItem menuItem_2 = new JMenuItem("\u7528\u6237\u7BA1\u7406");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				UserManageInterFrm userManageInterFrm=new UserManageInterFrm();
				
				
				userManageInterFrm.setVisible(true);
				
				
				table.add(userManageInterFrm);			//打开内部窗体
				
				
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainPage.class.getResource("/images/userName.png")));
		menu.add(menuItem_2);
		
			//商品类别
		JMenu menu_2 = new JMenu("\u5546\u54C1\u7C7B\u522B");
		menu_2.setIcon(new ImageIcon(MainPage.class.getResource("/images/bookTypeManager.png")));
		menu.add(menu_2);
		
				//商品类别添加
		JMenuItem menuItem_1 = new JMenuItem("\u5546\u54C1\u7C7B\u522B\u6DFB\u52A0");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//InterPage interPage = new InterPage();
				GoodsTypeAddInterFrm btainterpage = new GoodsTypeAddInterFrm();
				
				//interPage.setExtendedState(JFrame.MAXIMIZED_BOTH);//窗体最大化
				
				btainterpage.setVisible(true);
				
				
				table.add(btainterpage);			//打开内部窗体
				
				
				//JInternalFrame窗口最大化，需要在添加到JFrame的DesktopPane之后设置
				
				
				try {
					btainterpage.setMaximum(false);
				} catch (PropertyVetoException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainPage.class.getResource("/images/add.png")));
		menu_2.add(menuItem_1);
		
		
				//商品类别管理
		JMenuItem menuItem_3 = new JMenuItem("\u5546\u54C1\u7C7B\u522B\u7BA1\u7406");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				GoodsTypeManageInterFrm goodsTypeManageInterFrm=new GoodsTypeManageInterFrm();
				goodsTypeManageInterFrm.setVisible(true);
				table.add(goodsTypeManageInterFrm);
				
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainPage.class.getResource("/images/edit.png")));
		menu_2.add(menuItem_3);
		
			//商品
		JMenu menu_3 = new JMenu("\u5546\u54C1");
		menu_3.setIcon(new ImageIcon(MainPage.class.getResource("/images/bookManager.png")));
		menu.add(menu_3);
		
				//商品添加
		JMenuItem menuItem_4 = new JMenuItem("\u5546\u54C1\u6DFB\u52A0");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GoodsAddInterFrm goodsAddInterFrm=new GoodsAddInterFrm();
				goodsAddInterFrm.setVisible(true);
				table.add(goodsAddInterFrm);
				
			}
		});
		menuItem_4.setIcon(new ImageIcon(MainPage.class.getResource("/images/add.png")));
		menu_3.add(menuItem_4);
		
				//商品管理
		JMenuItem menuItem_5 = new JMenuItem("\u5546\u54C1\u7BA1\u7406");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GoodsManageInterFrm goodsManageInterFrm=new GoodsManageInterFrm();
				goodsManageInterFrm.setVisible(true);
				table.add(goodsManageInterFrm);
			}
		});
		menuItem_5.setIcon(new ImageIcon(MainPage.class.getResource("/images/edit.png")));
		menu_3.add(menuItem_5);
		
			//安全退出
		JMenuItem menuItem = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		contentPane.add(table, BorderLayout.CENTER);
	}
}
