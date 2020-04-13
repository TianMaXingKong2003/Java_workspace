package com.supermarket.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.supermarket.dao.GoodsDao;
import com.supermarket.dao.GoodsTypeDao;
import com.supermarket.model.Goods;
import com.supermarket.model.GoodsType;
import com.supermarket.util.DbUtil;
import com.supermarket.util.StringUtil;

public class GoodsAddInterFrm extends JInternalFrame {
	private JTextField goodsNameTxt;
	private JTextField quantityTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField priceTxt;
	private JComboBox goodsTypeJcb;
	private JTextArea goodsDescTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private GoodsTypeDao goodsTypeDao=new GoodsTypeDao();
	private GoodsDao goodsDao=new GoodsDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoodsAddInterFrm frame = new GoodsAddInterFrm();
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
	public GoodsAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u5546\u54C1\u6DFB\u52A0");
		setBounds(100, 100, 437, 459);
		
		JLabel label = new JLabel("\u5546\u54C1\u7684\u540D\u79F0\uFF1A");
		
		goodsNameTxt = new JTextField();
		goodsNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5546\u54C1\u6570\u91CF\uFF1A");
		
		quantityTxt = new JTextField();
		quantityTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5546\u54C1\u4EF7\u683C\uFF1A");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u5546\u54C1\u63CF\u8FF0\uFF1A");
		
		goodsDescTxt = new JTextArea();
		
		JLabel label_5 = new JLabel("\u5546\u54C1\u7C7B\u522B\uFF1A");
		
		goodsTypeJcb = new JComboBox();
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookAddActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(GoodsAddInterFrm.class.getResource("/images/add.png")));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon(GoodsAddInterFrm.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(42)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label_1)
										.addComponent(label_3)
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(label_4)
												.addComponent(label_5))))
									.addGap(21))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(goodsDescTxt, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(goodsTypeJcb, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(priceTxt, Alignment.LEADING)
									.addComponent(quantityTxt, Alignment.LEADING)
									.addComponent(goodsNameTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(98)
							.addComponent(button)
							.addGap(51)
							.addComponent(button_1)))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(goodsNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(quantityTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_3)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(goodsTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_4)
						.addComponent(goodsDescTxt, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(51))
		);
		getContentPane().setLayout(groupLayout);

		// 设置文本域边框
		goodsDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));

		
		fillBookType();
	}
	
	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent e) {
		this.resetValue();
	}

	/**
	 * 商品添加事件处理
	 * @param e
	 */
	private void bookAddActionPerformed(ActionEvent evt) {
		String goodsName=this.goodsNameTxt.getText();
		String price=this.priceTxt.getText();
		String goodsDesc=this.goodsDescTxt.getText();
		String goodsquantity=this.quantityTxt.getText();
		
		if(StringUtil.isEmpty(goodsName)){
			JOptionPane.showMessageDialog(null, "商品名称不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(goodsquantity)) {
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
		
		Goods goods=new Goods(goodsName,Float.parseFloat(price),Integer.parseInt( goodsquantity ), goodsTypeId,goodsTypeName,goodsDesc);
		
		Connection con=null;
		try{
			con=dbUtil.getCon();
			boolean addNum=goodsDao.add(goods);
			if(addNum){
				JOptionPane.showMessageDialog(null, "商品添加成功！");
				resetValue();
			}else{
				JOptionPane.showMessageDialog(null, "商品添加失败！");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "商品添加失败！");
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
		this.goodsNameTxt.setText("");
		
		this.priceTxt.setText("");
		
		this.quantityTxt.setText("");
	
		this.goodsDescTxt.setText("");
		if(this.goodsTypeJcb.getItemCount()>0){
			this.goodsTypeJcb.setSelectedIndex(0);
		}
	}

	/**
	 * 初始化商品类别下拉框
	 */
	private void fillBookType(){
		Connection con=null;
		GoodsType goodsType=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=goodsTypeDao.list(new GoodsType());
			while(rs.next()){
				goodsType=new GoodsType();
				goodsType.setId(rs.getInt("id"));
				goodsType.setGoodsTypeName(rs.getString("goodsTypeName"));
				this.goodsTypeJcb.addItem(goodsType);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
	}
}
