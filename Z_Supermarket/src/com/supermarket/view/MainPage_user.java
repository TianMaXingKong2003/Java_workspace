
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

public class MainPage_user extends JFrame {

	private JPanel contentPane;
	
	static JDesktopPane table = new JDesktopPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage_user frame = new MainPage_user();
					
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
	public MainPage_user() {
		
		
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
		
		GoodsManageInterFrm_user goodsManageInterFrm_user=new GoodsManageInterFrm_user();
		goodsManageInterFrm_user.setLocation(197, 23);
		goodsManageInterFrm_user.setLocale(null);
		goodsManageInterFrm_user.setVisible(true);
		table.add(goodsManageInterFrm_user);
		

		setIconImage(Toolkit.getDefaultToolkit().getImage(MainPage_user.class.getResource("/images/logo.png")));
		setTitle("\u8D85\u5E02\u7BA1\u7406\u7CFB\u7EDF\uFF08\u666E\u901A\u7528\u6237\u6A21\u5F0F\uFF09");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1125, 671);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//基本数据维护
		JMenu menu = new JMenu("\u57FA\u672C\u529F\u80FD");
		menu.setIcon(new ImageIcon(MainPage_user.class.getResource("/images/base.png")));
		menu.setBackground(Color.LIGHT_GRAY);
		menuBar.add(menu);
		
				//商品管理
		JMenuItem menuItem_5 = new JMenuItem("\u8D2D\u4E70\u5546\u54C1");
		menu.add(menuItem_5);
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GoodsManageInterFrm_user goodsManageInterFrm_user=new GoodsManageInterFrm_user();
				goodsManageInterFrm_user.setLocation(14, 13);
				goodsManageInterFrm_user.setLocale(null);
				goodsManageInterFrm_user.setVisible(true);
				table.add(goodsManageInterFrm_user);
			}
		});
		menuItem_5.setIcon(new ImageIcon(MainPage_user.class.getResource("/images/edit.png")));
		
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
		menuItem.setIcon(new ImageIcon(MainPage_user.class.getResource("/images/exit.png")));
		menu.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		contentPane.add(table, BorderLayout.CENTER);
	}
}
