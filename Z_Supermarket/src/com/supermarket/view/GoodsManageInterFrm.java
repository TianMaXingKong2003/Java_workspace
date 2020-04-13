package com.supermarket.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.Book;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
import com.supermarket.model.Goods;
import com.supermarket.model.GoodsType;
import com.supermarket.util.DbUtil;
import com.supermarket.util.StringUtil;

public class GoodsManageInterFrm extends JInternalFrame {
	private JTable goodsTable;
	private JTextField s_goodsNameTxt;
	private JComboBox s_goodsTypeJcb;
	private JTextArea goodsDescTxt;
	private JComboBox goodsTypeJcb ;
	
	private DbUtil dbUtil=new DbUtil();
	private GoodsTypeDao goodsTypeDao=new GoodsTypeDao();
	private GoodsDao goodsDao=new GoodsDao();
	private JTextField idTxt;
	private JTextField goodsNameTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField priceTxt;
	private JTextField quantityTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoodsManageInterFrm frame = new GoodsManageInterFrm();
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
	
	public GoodsManageInterFrm() {
		setMaximizable(true);
		setClosable(true);
		setIconifiable(true);
		setTitle("\u5546\u54C1\u7BA1\u7406");
		setBounds(100, 100, 677, 539);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(scrollPane)))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		
		goodsNameTxt = new JTextField();
		goodsNameTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u4EF7\u683C\uFF1A");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5546\u54C1\u6570\u91CF\uFF1A");
		
		quantityTxt = new JTextField();
		quantityTxt.setColumns(10);
		
		JLabel label_5 = new JLabel("\u5546\u54C1\u7C7B\u522B\uFF1A");
		
		goodsTypeJcb = new JComboBox();
		
		JLabel label_6 = new JLabel("\u5546\u54C1\u63CF\u8FF0\uFF1A");
		
		goodsDescTxt = new JTextArea();
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				goodsUpdateActionPerformed(evt);
			}
		});
		button_1.setIcon(new ImageIcon(GoodsManageInterFrm.class.getResource("/images/modify.png")));
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				goodsDeleteActionPerformed(evt);
			}
		});
		button_2.setIcon(new ImageIcon(GoodsManageInterFrm.class.getResource("/images/delete.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_6)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(goodsDescTxt, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(label_4)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(priceTxt))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(lblNewLabel)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
									.addGap(26)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(lblNewLabel_1)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(goodsNameTxt, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(lblNewLabel_2)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(quantityTxt)))
									.addGap(26)
									.addComponent(label_5)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(goodsTypeJcb, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(46, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(button_1)
							.addGap(78)
							.addComponent(button_2)
							.addGap(198))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(goodsNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(quantityTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(goodsTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(label_6)
						.addComponent(goodsDescTxt, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_2)
						.addComponent(button_1))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel label = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		
		s_goodsNameTxt = new JTextField();
		s_goodsNameTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5546\u54C1\u7C7B\u522B\uFF1A");
		
		s_goodsTypeJcb = new JComboBox();
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goodsSearchActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(GoodsManageInterFrm.class.getResource("/images/search.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_goodsNameTxt, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(s_goodsTypeJcb, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(30))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(s_goodsNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(16))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(s_goodsTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(button))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		goodsTable = new JTable();
		goodsTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				goodsTableMousePressed(met);
			}
		});
		scrollPane.setViewportView(goodsTable);
		goodsTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u5546\u54c1\u540D\u79F0", "\u5546\u54c1\u6570\u91cf", "\u5546\u54c1\u4EF7\u683C", "\u5546\u54c1\u7C7B\u522B", "\u5546\u54c1\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		goodsTable.getColumnModel().getColumn(5).setPreferredWidth(119);
		getContentPane().setLayout(groupLayout);

		// 设置文本域边框
		goodsDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));

				
		this.fillGoodsType("search");
		this.fillGoodsType("modify");
		this.fillTable(new Goods());
	}
	
	/**
	 * 商品删除事件处理
	 * @param evt
	 */
	private void goodsDeleteActionPerformed(ActionEvent evt) {
		String id=idTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if(n==0){
			Connection con=null;
			try{
				con=dbUtil.getCon();
				boolean deleteNum=goodsDao.delete(id);
				if(deleteNum){
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new Goods());
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
	 * 商品修改事件处理
	 * @param evt
	 */
	private void goodsUpdateActionPerformed(ActionEvent evt) {
		String id=this.idTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		
		String goodsName=this.goodsNameTxt.getText();
		String author=this.quantityTxt.getText();
		String price=this.priceTxt.getText();
		String goodsDesc=this.goodsDescTxt.getText();
		String goodsquantity=this.quantityTxt.getText();
		
		if(StringUtil.isEmpty(goodsName)){
			JOptionPane.showMessageDialog(null, "商品名称不能为空！");
			return;
		}
		
		//数量
		if(StringUtil.isEmpty(author)){
			JOptionPane.showMessageDialog(null, "商品数量不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(price)){
			JOptionPane.showMessageDialog(null, "商品价格不能为空！");
			return;
		}
		
		
		
		GoodsType goodsType=(GoodsType) goodsTypeJcb.getSelectedItem();
		int goodsTypeId=goodsType.getId();
		String goodsTypeName=goodsType.getGoodsTypeName();
		
		Goods goods=new Goods(Integer.parseInt(id),  goodsName,Float.parseFloat(price),Integer.parseInt( goodsquantity ), goodsTypeId,goodsTypeName,goodsDesc);
		
		Connection con=null;
		try{
			con=dbUtil.getCon();
			boolean addNum=goodsDao.update(goods);
			if(addNum){
				JOptionPane.showMessageDialog(null, "商品修改成功！");
				resetValue();
				this.fillTable(new Goods());
			}else{
				JOptionPane.showMessageDialog(null, "商品修改失败！");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "商品修改失败！");
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
		this.goodsNameTxt.setText("");
		this.quantityTxt.setText("");
		this.priceTxt.setText("");
		
		this.goodsDescTxt.setText("");
		if(this.goodsTypeJcb.getItemCount()>0){
			this.goodsTypeJcb.setSelectedIndex(0);
		}
	}

	/**
	 * 表格行点击事件处理
	 * @param met
	 */
	private void goodsTableMousePressed(MouseEvent met) {
		int row=this.goodsTable.getSelectedRow();
		//编号
		this.idTxt.setText((String)goodsTable.getValueAt(row, 0));
		//名称
		this.goodsNameTxt.setText((String)goodsTable.getValueAt(row, 1));
		//数量
		this.quantityTxt.setText((String)goodsTable.getValueAt(row, 2));
		//价格
		this.priceTxt.setText((goodsTable.getValueAt(row, 3)).toString());
		//描述
		this.goodsDescTxt.setText((String)goodsTable.getValueAt(row, 5));
		
		
		//类别
		String goodsTypeName=(String)this.goodsTable.getValueAt(row, 4);
		int n=this.goodsTypeJcb.getItemCount();
		
		//System.out.println("搜索类别");
		
		for(int i=0;i<n;i++){
			GoodsType item=(GoodsType)this.goodsTypeJcb.getItemAt(i);	
			//System.out.println(item.getGoodsTypeName()+"\t\t"+goodsTypeName);
			if(item.getGoodsTypeName().equals(goodsTypeName)){
				this.goodsTypeJcb.setSelectedIndex(i);
			}
		}
	}

	/**
	 * 商品查询事件处理
	 * @param e
	 */
	private void goodsSearchActionPerformed(ActionEvent evt) {
		String goodsName=this.s_goodsNameTxt.getText();
		
		GoodsType goodsType=(GoodsType) this.s_goodsTypeJcb.getSelectedItem();
		int goodsTypeId=goodsType.getId();
		
		Goods goods=new Goods(goodsName,goodsTypeId);
		this.fillTable(goods);
	}

	/**
	 * 初始化下拉框
	 * @param type 下拉框类型 
	 */
	private void fillGoodsType(String type){
		Connection con=null;
		GoodsType goodsType=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=goodsTypeDao.list(new GoodsType());
			if("search".equals(type)){
				goodsType=new GoodsType();
				goodsType.setGoodsTypeName("请选择...");
				goodsType.setId(-1);
				this.s_goodsTypeJcb.addItem(goodsType);
			}
			while(rs.next()){
				goodsType=new GoodsType();
				goodsType.setGoodsTypeName(rs.getString("goodsTypeName"));
				goodsType.setId(rs.getInt("id"));
				if("search".equals(type)){
					this.s_goodsTypeJcb.addItem(goodsType);
				}else if("modify".equals(type)){
					this.goodsTypeJcb.addItem(goodsType);
				}
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
	 * 初始化表格数据
	 * @param book
	 */
	private void fillTable(Goods goods){
		DefaultTableModel dtm=(DefaultTableModel) goodsTable.getModel();
		dtm.setRowCount(0); // 设置成0行
		Connection con=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=goodsDao.list(goods);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("goodsName"));
				v.add(rs.getString("quantity"));
				v.add(rs.getFloat("price"));	
				v.add(rs.getString("goodsTypeName"));
				v.add(rs.getString("goodsDesc"));
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
}
