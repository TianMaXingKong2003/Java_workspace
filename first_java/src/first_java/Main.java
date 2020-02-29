package first_java;

import java.awt.*;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		
		JFrame frame=new JFrame();
		frame.setSize(300,300);
		
		int windowWidth = frame.getWidth();                     //获得窗口宽
        int windowHeight = frame.getHeight();                   //获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit();              //定义工具包
        Dimension screenSize = kit.getScreenSize();             //获取屏幕的尺寸
        int screenWidth = screenSize.width;                     //获取屏幕的宽
        int screenHeight = screenSize.height;                   //获取屏幕的高
        frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示
	
        
        
        
        
		
		frame.setVisible(true);
		
	}

}
 