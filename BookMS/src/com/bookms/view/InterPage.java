package com.bookms.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;

public class InterPage extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterPage frame = new InterPage();
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
	public InterPage() {
		
		
		
		setMaximizable(true);
		
		getContentPane().setBackground(new Color(255, 255, 240));
		setIconifiable(true);
		setClosable(true);
		
		
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
		
		setFrameIcon(new ImageIcon(InterPage.class.getResource("/images/me.png")));
		setTitle("\u4F5C\u8005\uFF1A\u5929\u9A6C\u884C\u7A7A");
		setBounds(100, 100, 450, 300);
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(255, 255, 240));
		label.setIcon(new ImageIcon(InterPage.class.getResource("/images/java1234.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(109)
					.addComponent(label)
					.addContainerGap(115, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(98, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(92))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	
}
