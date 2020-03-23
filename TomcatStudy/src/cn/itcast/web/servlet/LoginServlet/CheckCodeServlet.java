package cn.itcast.web.servlet.LoginServlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 验证码Servlet
 */
@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int width=100;
		int height=50;
		
		System.out.println("生成一张验证码");
		
		//1.创建一个对象，在内存中代表一张图片（验证码图片）
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		
		//2.美化图片
        //2.1 填充背景色
        Graphics g = image.getGraphics();//画笔对象
        g.setColor(Color.gray);//设置画笔颜色
        g.fillRect(0,0,width,height);
 
        //2.2画边框
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width - 1,height - 1);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        //生成随机角标
        Random ran = new Random();
        //创建一个字符流
        StringBuilder sbu=new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            int index = ran.nextInt(str.length());
            //获取字符
            char ch = str.charAt(index);//随机字符 
            sbu.append(ch);//装入sbu中
            //2.3写验证码
            g.drawString(ch+"",width/5*i,height/2);
        }
        //把验证码的值存入Session
        String checkCode_session=sbu.toString();
        request.getSession().setAttribute("checkCode_session", checkCode_session);
        
        //2.4画干扰线
        g.setColor(Color.GREEN);

        //随机生成坐标点

        for (int i = 0; i < 6; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);

            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }
		
		
		//3.输出图片到页面
		ImageIO.write(image, "jpg", response.getOutputStream()); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
