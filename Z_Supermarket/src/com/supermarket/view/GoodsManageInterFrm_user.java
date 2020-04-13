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

public class GoodsManageInterFrm_user extends JInternalFrame {
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
					GoodsManageInterFrm_user frame = new GoodsManageInterFrm_user();
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
	
	public GoodsManageInterFrm_user() {
		setMaximizable(true);
		setClosable(true);
		setIconifiable(true);
		setTitle("\u8D2D\u4E70\u5546\u54C1");
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
		idTxt.setEnabled(false);
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		
		goodsNameTxt = new JTextField();
		goodsNameTxt.setEnabled(false);
		goodsNameTxt.setEditable(false);
		goodsNameTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u5355\u4EF7\uFF1A");
		
		priceTxt = new JTextField();
		priceTxt.setEnabled(false);
		priceTxt.setEditable(false);
		priceTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u8D2D\u4E70\u6570\u91CF\uFF1A");
		
		quantityTxt = new JTextField();
		quantityTxt.setColumns(10);
		
		JLabel label_5 = new JLabel("\u5546\u54C1\u7C7B\u522B\uFF1A");
		
		goodsTypeJcb = new JComboBox();
		goodsTypeJcb.setEnabled(false);
		
		JLabel label_6 = new JLabel("\u5546\u54C1\u63CF\u8FF0\uFF1A");
		
		goodsDescTxt = new JTextArea();
		goodsDescTxt.setEnabled(false);
		goodsDescTxt.setEditable(false);
		
		JButton button_1 = new JButton("\u8D2D\u4E70");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				goodsUpdateActionPerformed(evt);
			}
		});
		button_1.setIcon(new ImageIcon(GoodsManageInterFrm_user.class.getResource("/images/bookTypeManager.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(19)
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
									.addComponent(goodsTypeJcb, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(252)
							.addComponent(button_1)))
					.addContainerGap(46, Short.MAX_VALUE))
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
					.addGap(31)
					.addComponent(button_1))
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
		button.setIcon(new ImageIcon(GoodsManageInterFrm_user.class.getResource("/images/search.png")));
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
	 * 商品购买事件处理
	 * @param evt
	 */
	private void goodsUpdateActionPerformed(ActionEvent evt) {
		String id=this.idTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选中您要购买的商品");
			return;
		}
		
		String goodsName=this.goodsNameTxt.getText();
		String quantityTxt=this.quantityTxt.getText();
		String price=this.priceTxt.getText();
		String goodsDesc=this.goodsDescTxt.getText();
		String goodsquantity=this.quantityTxt.getText();
		int quantityNum=0;
		
		int row=this.goodsTable.getSelectedRow();
		//获得该商品原有数量
		String str=(String)goodsTable.getValueAt(row, 2);
		int QuantityNum=Integer.parseInt(str);
		
		System.out.println("该商品原有数量"+QuantityNum);
		
		//购买的数量
		if(StringUtil.isEmpty(quantityTxt)){
			JOptionPane.showMessageDialog(null, "购买数量不能为空！");
			return;
		}else {
			
			quantityNum=Integer.parseInt(goodsquantity);
			
			System.out.println("该商品购买数量"+QuantityNum);
			
			if (quantityNum<=0||quantityNum>=QuantityNum) {
				JOptionPane.showMessageDialog(null, "购买数量有误！请重新输入！");
				return;
			}
		}
		
		
		
		GoodsType goodsType=(GoodsType) goodsTypeJcb.getSelectedItem();
		int goodsTypeId=goodsType.getId();
		String goodsTypeName=goodsType.getGoodsTypeName();
		
		Goods goods=new Goods(Integer.parseInt(id),  goodsName,Float.parseFloat(price),QuantityNum-quantityNum, goodsTypeId,goodsTypeName,goodsDesc);
		
		Connection con=null;
		try{
			con=dbUtil.getCon();
			boolean addNum=goodsDao.update(goods);
			if(addNum){
				JOptionPane.showMessageDialog(null, "商品购买成功！");
				resetValue();
				this.fillTable(new Goods());
			}else{
				JOptionPane.showMessageDialog(null, "商品购买失败！");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "商品购买失败！");
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
		this.quantityTxt.setText("1");
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
