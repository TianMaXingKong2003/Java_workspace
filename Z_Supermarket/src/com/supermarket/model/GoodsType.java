package com.supermarket.model;

/**
 * ��Ʒ���ʵ��
 * @author Administrator
 *
 */
public class GoodsType {

	private int id; // ���
	private String goodsTypeName; // ��Ʒ�������
	private String goodsTypeDesc; // ��ע

	
	public GoodsType() {
		super();
	}


	public GoodsType(String goodsTypeName, String goodsTypeDesc) {
		super();
		this.goodsTypeName = goodsTypeName;
		this.goodsTypeDesc = goodsTypeDesc;
	}



	public GoodsType(int id, String goodsTypeName, String goodsTypeDesc) {
		super();
		this.id = id;
		this.goodsTypeName = goodsTypeName;
		this.goodsTypeDesc = goodsTypeDesc;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getGoodsTypeName() {
		return goodsTypeName;
	}



	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}



	public String getGoodsTypeDesc() {
		return goodsTypeDesc;
	}



	public void setGoodsTypeDesc(String goodsTypeDesc) {
		this.goodsTypeDesc = goodsTypeDesc;
	}



	@Override
	public String toString() {
		return  id + ". " + goodsTypeName ;
	}



	
	
	
}
