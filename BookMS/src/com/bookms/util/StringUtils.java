package com.bookms.util;

//�ַ�����

public class StringUtils {

	//�ж��Ƿ�Ϊ��
	public static boolean isEmpty(String str) {
		
		if(str==null || "".equals(str.trim())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	//�ж��Ƿ��ǿ�
	public static boolean isNotEmpty(String str) {
		
		if(str!=null && !"".equals(str.trim())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
}
