package cn.itcast.util;

import sun.misc.BASE64Encoder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class DownLoadUtils {

    public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")) {
            // IE�����
        	System.out.println("ʹ��IE����������ļ�");
            filename = URLEncoder.encode(filename, "gbk");
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            //��������
        	System.out.println("ʹ�û������������ļ�");
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filename = "=?gbk?B?" + base64Encoder.encode(filename.getBytes("gbk")) + "?=";
        } else {
            //���������
        	System.out.println("ʹ����������������ļ�");
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }
}
