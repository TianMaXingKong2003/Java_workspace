package com.supermarket.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.supermarket.dao.GoodsDao;
import com.supermarket.dao.GoodsTypeDao;
import com.supermarket.dao.UserDao_Implement;
import com.supermarket.model.GoodsType;
import com.supermarket.model.User;
import com.supermarket.util.DbUtil;
import com.supermarket.util.StringUtil;
import javax.swing.JCheckBox;
import java.awt.Font;

public class UserManageInterFrm extends JInternalFrame {
	private JTable goodsTypeTable;
	private JTextArea goodsTypeDescTxt ;
	
	private DbUtil dbUtil=new DbUtil();
	private GoodsTypeDao goodsTypeDao=new GoodsTypeDao();
	private UserDao_Implement userDao_Implement=new UserDao_Implement();
	
	private GoodsDao goodsDao=new GoodsDao();
	private UserDao_Implement userDao_Implement2=new UserDao_Implement();
	private JTextField s_goodsTypeNameTxt;
	private JTextField idTxt;
	private JTextField userNameTxt;
	private JTextField typeTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManageInterFrm frame = new UserManageInterFrm();
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
	public UserManageInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u7528\u6237\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 526, 518);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		
		s_goodsTypeNameTxt = new JTextField();
		s_goodsTypeNameTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userTypeSearchActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(UserManageInterFrm.class.getResource("/images/search.png")));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(label)
							.addGap(18)
							.addComponent(s_goodsTypeNameTxt, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button))
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
					.addGap(48))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(s_goodsTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(39)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		
		goodsTypeDescTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userTypeUpdateActionEvent(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(UserManageInterFrm.class.getResource("/images/modify.png")));
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeDeleteActionEvent(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(UserManageInterFrm.class.getResource("/images/delete.png")));
		
		JLabel label_2 = new JLabel("\u6743\u9650\uFF1A");
		
		typeTxt = new JTextField();
		typeTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("1->\u7BA1\u7406\u5458   2->\u666E\u901A\u7528\u6237");
		label_3.setFont(new Font("宋体", Font.PLAIN, 8));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(66)
							.addComponent(btnNewButton)
							.addGap(80)
							.addComponent(btnNewButton_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(typeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(31)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1)
								.addComponent(lblNewLabel_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(goodsTypeDescTxt)
								.addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)))
						.addComponent(label_3))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(goodsTypeDescTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(typeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_3)
					.addGap(35)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		goodsTypeTable = new JTable();
		goodsTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				userTypeTableMousePressed(e);
			}
		});
		goodsTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u7528\u6237\u540D", "\u5BC6\u7801", "\u6743\u9650\u7c7b\u578b"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		goodsTypeTable.getColumnModel().getColumn(1).setPreferredWidth(110);
		goodsTypeTable.getColumnModel().getColumn(2).setPreferredWidth(123);
		scrollPane.setViewportView(goodsTypeTable);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new User());

		// 设置文本域边框
		goodsTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
	}
	
	/**
	 * 用户类别删除事件处理
	 * @param e
	 */
	private void bookTypeDeleteActionEvent(ActionEvent evt) {
		String id=idTxt.getText();
		String uname=userNameTxt.getText();
		
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		
		if(n==0){
			Connection con=null;
			try{
				con=dbUtil.getCon();
				//boolean flag=goodsDao.existGoodsByGoodsTypeId(id);
				boolean deleteNum=userDao_Implement2.delete(uname);
				if(deleteNum){
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new User());
				}else{
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败");
			}finally{
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 用户修改事件处理
	 * @param evt
	 */
	private void userTypeUpdateActionEvent(ActionEvent evt) {
		String id=idTxt.getText();
		String goodsTypeName=userNameTxt.getText();
		String goodsTypeDesc=goodsTypeDescTxt.getText();
		String type=typeTxt.getText();
		
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		if(StringUtil.isEmpty(goodsTypeName)){
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		//GoodsType goodsType=new GoodsType(Integer.parseInt(id),goodsTypeName,goodsTypeDesc);
		User user=new User(goodsTypeName, goodsTypeDesc,Integer.parseInt(type));
		Connection con=null;
		try{
			con=dbUtil.getCon();
			//boolean modifyNum=goodsTypeDao.update(goodsType);
			boolean modifyNum=userDao_Implement.update(user);
			if(modifyNum){
				JOptionPane.showMessageDialog(null, "修改成功");
				this.resetValue();
				this.fillTable(new User());
			}else{
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败");
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 表格行点击事件处理
	 * @param e
	 */
	private void userTypeTableMousePressed(MouseEvent evt) {
		int row=goodsTypeTable.getSelectedRow();
		idTxt.setText((String)goodsTypeTable.getValueAt(row, 0));
		userNameTxt.setText((String)goodsTypeTable.getValueAt(row, 1));
		goodsTypeDescTxt.setText((String)goodsTypeTable.getValueAt(row, 2));
		typeTxt.setText((String)goodsTypeTable.getValueAt(row, 3));
	}

	/**
	 * 用户名搜索事件处理
	 * @param evt
	 */
	private void userTypeSearchActionPerformed(ActionEvent evt) {
		String s_goodsTypeName=this.s_goodsTypeNameTxt.getText();
		//GoodsType goodsType=new GoodsType();
		//goodsType.setGoodsTypeName(s_goodsTypeName);
		
		User user=new User();
		user.setUname(s_goodsTypeName);
		this.fillTable(user);
		
	}

	/**
	 * 初始化表格
	 * @param bookType
	 */
	private void fillTable(User user){
		DefaultTableModel dtm=(DefaultTableModel)goodsTypeTable.getModel();
		dtm.setRowCount(0); // 设置成0行
		Connection con=null;
		try{
			con=dbUtil.getCon();
			//ResultSet rs=goodsTypeDao.list(goodsType);
			//
			ResultSet rs=userDao_Implement.list(user);
			
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("userName"));
				v.add(rs.getString("password"));
				v.add(rs.getString("type"));
				dtm.addRow(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 重置表单
	 */
	private void resetValue(){
		this.idTxt.setText("");
		this.userNameTxt.setText("");
		this.goodsTypeDescTxt.setText("");
		this.typeTxt.setText("");
	}
}
