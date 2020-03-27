package cn.itcast.util;

import sun.misc.BASE64Encoder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class DownLoadUtils {

    public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")) {
            // IE浏览器
        	System.out.println("使用IE浏览器下载文件");
            filename = URLEncoder.encode(filename, "gbk");
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            //火狐浏览器
        	System.out.println("使用火狐浏览器下载文件");
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filename = "=?gbk?B?" + base64Encoder.encode(filename.getBytes("gbk")) + "?=";
        } else {
            //其他浏览器
        	System.out.println("使用其他浏览器下载文件");
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }
}
