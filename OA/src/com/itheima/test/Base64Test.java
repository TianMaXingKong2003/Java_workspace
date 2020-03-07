package com.itheima.test;

import sun.misc.BASE64Encoder;

public class Base64Test {

	public static void main(String[] args) {
		String s = "iamsorry";
		BASE64Encoder b = new BASE64Encoder();
		String s1 = b.encode(s.getBytes());
		System.out.println(s1);
	}

}
