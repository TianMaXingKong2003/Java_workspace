package com.supermarket.model;

/**
 * ͼ��ʵ��
 * @author Administrator
 *
 */
public class Goods {

	private int id; // ���
	private String goodsName; // ��Ʒ����
	private Float price; // �۸�
	private Integer quantity;//���� 
	private Integer goodsTypeId; // ���Id
	private String goodsTypeName; // ��������
	private String goodsDesc; // ��ע
	
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
