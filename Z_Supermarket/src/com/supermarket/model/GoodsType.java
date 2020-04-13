package com.supermarket.model;

/**
 * 商品类别实体
 * @author Administrator
 *
 */
public class GoodsType {

	private int id; // 编号
	private String goodsTypeName; // 商品类别名称
	private String goodsTypeDesc; // 备注

	
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
