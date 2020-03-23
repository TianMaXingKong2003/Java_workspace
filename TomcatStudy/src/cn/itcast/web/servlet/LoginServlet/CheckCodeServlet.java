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
 * ��֤��Servlet
 */
@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int width=100;
		int height=50;
		
		System.out.println("����һ����֤��");
		
		//1.����һ���������ڴ��д���һ��ͼƬ����֤��ͼƬ��
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		
		//2.����ͼƬ
        //2.1 ��䱳��ɫ
        Graphics g = image.getGraphics();//���ʶ���
        g.setColor(Color.gray);//���û�����ɫ
        g.fillRect(0,0,width,height);
 
        //2.2���߿�
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width - 1,height - 1);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        //��������Ǳ�
        Random ran = new Random();
        //����һ���ַ���
        StringBuilder sbu=new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            int index = ran.nextInt(str.length());
            //��ȡ�ַ�
            char ch = str.charAt(index);//����ַ� 
            sbu.append(ch);//װ��sbu��
            //2.3д��֤��
            g.drawString(ch+"",width/5*i,height/2);
        }
        //����֤���ֵ����Session
        String checkCode_session=sbu.toString();
        request.getSession().setAttribute("checkCode_session", checkCode_session);
        
        //2.4��������
        g.setColor(Color.GREEN);

        //������������

        for (int i = 0; i < 6; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);

            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }
		
		
		//3.���ͼƬ��ҳ��
		ImageIO.write(image, "jpg", response.getOutputStream()); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
