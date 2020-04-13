package com.supermarket.model;

/**
 * 图书实体
 * @author Administrator
 *
 */
public class Goods {

	private int id; // 编号
	private String goodsName; // 商品名称
	private Float price; // 价格
	private Integer quantity;//数量 
	private Integer goodsTypeId; // 类别Id
	private String goodsTypeName; // 类名名称
	private String goodsDesc; // 备注
	
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Goods(String goodsName, Integer goodsTypeId) {
		super();
		this.goodsName = goodsName;
		this.goodsTypeId = goodsTypeId;
	}



	public Goods(String goodsName, Float price, Integer quantity, Integer goodsTypeId, String goodsTypeName,
			String goodsDesc) {
		super();
		this.goodsName = goodsName;
		this.price = price;
		this.quantity = quantity;
		this.goodsTypeId = goodsTypeId;
		this.goodsTypeName = goodsTypeName;
		this.goodsDesc = goodsDesc;
	}



	public Goods(int id, String goodsName, Float price, Integer quantity, Integer goodsTypeId, String goodsTypeName,
			String goodsDesc) {
		super();
		this.id = id;
		this.goodsName = goodsName;
		this.price = price;
		this.quantity = quantity;
		this.goodsTypeId = goodsTypeId;
		this.goodsTypeName = goodsTypeName;
		this.goodsDesc = goodsDesc;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getGoodsTypeId() {
		return goodsTypeId;
	}
	public void setGoodsTypeId(Integer goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}
	public String getGoodsTypeName() {
		return goodsTypeName;
	}
	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}
	public String getGoodsDesc() {
		return goodsDesc;
	}
	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", goodsName=" + goodsName + ", price=" + price + ", quantity=" + quantity
				+ ", goodsTypeId=" + goodsTypeId + ", goodsTypeName=" + goodsTypeName + ", goodsDesc=" + goodsDesc
				+ "]";
	}
	
	
	
}
