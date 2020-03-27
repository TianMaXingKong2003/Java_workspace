package web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tools.WordGenerator;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	     Map<String, Object> map = new HashMap<String, Object>();  
	     Enumeration<String> paramNames = request.getParameterNames();  
	     // 閫氳繃寰幆灏嗚〃鍗曞弬鏁版斁鍏ラ敭鍊煎鏄犲皠涓�  
	     while(paramNames.hasMoreElements()) {  
	         String key = paramNames.nextElement();  
	         String value = request.getParameter(key);  
	         map.put(key, value);  
	     }  
	     	// 鎻愮ず锛氬湪璋冪敤宸ュ叿绫荤敓鎴怶ord鏂囨。涔嬪墠搴斿綋妫�鏌ユ墍鏈夊瓧娈垫槸鍚﹀畬鏁�  
	        // 鍚﹀垯Freemarker鐨勬ā鏉垮紩鎿庡湪澶勭悊鏃跺彲鑳戒細鍥犱负鎵句笉鍒板�艰�屾姤閿� 杩欓噷鏆傛椂蹇界暐杩欎釜姝ラ浜�  
	        File file = null;  
	        InputStream fin = null;  
	        ServletOutputStream out = null;  
	        try {  
	            // 璋冪敤宸ュ叿绫籛ordGenerator鐨刢reateDoc鏂规硶鐢熸垚Word鏂囨。  
	            file = WordGenerator.createDoc(map, "resume");  
	            fin = new FileInputStream(file);  
	              
	            response.setCharacterEncoding("utf-8");  
	            response.setContentType("application/msword");  
	            // 璁剧疆娴忚鍣ㄤ互涓嬭浇鐨勬柟寮忓鐞嗚鏂囦欢榛樿鍚嶄负resume.doc  
	            response.addHeader("Content-Disposition", "attachment;filename=resume.doc");  
	              
	            out = response.getOutputStream();  
	            byte[] buffer = new byte[512];  // 缂撳啿鍖�  
	            int bytesToRead = -1;  
	            // 閫氳繃寰幆灏嗚鍏ョ殑Word鏂囦欢鐨勫唴瀹硅緭鍑哄埌娴忚鍣ㄤ腑  
	            while((bytesToRead = fin.read(buffer)) != -1) {  
	                out.write(buffer, 0, bytesToRead);  
	            }  
	        } finally {  
	            if(fin != null) fin.close();  
	            if(out != null) out.close();  
	            if(file != null) file.delete(); // 鍒犻櫎涓存椂鏂囦欢  
	        }  
	} 
//        WordUtils.exportMillCertificateWord(request,response,map);  
//	}
}
