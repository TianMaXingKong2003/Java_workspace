package com.supermarket.model;

public class User {

	private int id;//用户id
    private String uname;//用户名
    private String upass;//用户密码
    private int type;//用户类型 1：管理员 2：顾客
      
	public User() {
		super();
	}
	
	public User(String uname, String upass) {
		super();
		this.uname = uname;
		this.upass = upass;
	}

	public User(String uname, String upass, int type) {
		super();
		this.uname = uname;
		this.upass = upass;
		this.type = type;
	}

	public User(int id, String uname, String upass, int type) {
		super();
		this.id = id;
		this.uname = uname;
		this.upass = upass;
		this.type = type;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", upass=" + upass + ", type=" + type + "]";
	}

	
}
