package first_java;

import java.awt.*;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		
		JFrame frame=new JFrame();
		frame.setSize(300,300);
		
		int windowWidth = frame.getWidth();                     //��ô��ڿ�
        int windowHeight = frame.getHeight();                   //��ô��ڸ�
        Toolkit kit = Toolkit.getDefaultToolkit();              //���幤�߰�
        Dimension screenSize = kit.getScreenSize();             //��ȡ��Ļ�ĳߴ�
        int screenWidth = screenSize.width;                     //��ȡ��Ļ�Ŀ�
        int screenHeight = screenSize.height;                   //��ȡ��Ļ�ĸ�
        frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//���ô��ھ�����ʾ
	
        
        
        
        
		
		frame.setVisible(true);
		
	}

}
 