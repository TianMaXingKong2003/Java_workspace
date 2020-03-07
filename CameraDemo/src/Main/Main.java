package Main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileSystemView;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.github.sarxos.webcam.WebcamUtils;
import com.github.sarxos.webcam.util.ImageUtils;

public class Main {

	private static JFrame window;
	 
	public static void main(String[] args) throws InterruptedException {
		
		//获取桌面路径
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File com=fsv.getHomeDirectory();   
		System.out.println(com.getPath()); //这便是桌面的具体路径
 
		Webcam webcam = Webcam.getDefault();
		webcam.setViewSize(WebcamResolution.VGA.getSize());
 
		WebcamPanel panel = new WebcamPanel(webcam);
		panel.setFPSDisplayed(true);
		panel.setDisplayDebugInfo(true);
		panel.setImageSizeDisplayed(true);
		panel.setMirrored(true);
 
		JFrame window = new JFrame("Test webcam panel");
		window.add(panel);
		window.setResizable(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
 
 
 
		final JButton button = new JButton("拍照");
		window.add(panel, BorderLayout.CENTER);
		window.add(button, BorderLayout.SOUTH);
		window.setResizable(true);
		window.pack();
		window.setVisible(true);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
 
				System.out.println("拍照");
				
				button.setEnabled(false);  //设置按钮可点击
 
 
				//实现拍照保存-------start
				String fileName = com.getPath()+ "\\"+System.currentTimeMillis();       //保存路径即图片名称（不用加后缀）
				WebcamUtils.capture(webcam, fileName, ImageUtils.FORMAT_PNG);
				
				SwingUtilities.invokeLater(new Runnable() {
 
					@Override
					public void run()
					{
						JOptionPane.showMessageDialog(null, "拍照成功");
						
						System.out.println(fileName);
						
						button.setEnabled(true);    //设置按钮可点击
 
						return;
					}
				});
				//实现拍照保存-------end
 
			}

			
		});
}
}