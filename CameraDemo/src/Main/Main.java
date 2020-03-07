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
		
		//��ȡ����·��
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File com=fsv.getHomeDirectory();   
		System.out.println(com.getPath()); //���������ľ���·��
 
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
 
 
 
		final JButton button = new JButton("����");
		window.add(panel, BorderLayout.CENTER);
		window.add(button, BorderLayout.SOUTH);
		window.setResizable(true);
		window.pack();
		window.setVisible(true);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
 
				System.out.println("����");
				
				button.setEnabled(false);  //���ð�ť�ɵ��
 
 
				//ʵ�����ձ���-------start
				String fileName = com.getPath()+ "\\"+System.currentTimeMillis();       //����·����ͼƬ���ƣ����üӺ�׺��
				WebcamUtils.capture(webcam, fileName, ImageUtils.FORMAT_PNG);
				
				SwingUtilities.invokeLater(new Runnable() {
 
					@Override
					public void run()
					{
						JOptionPane.showMessageDialog(null, "���ճɹ�");
						
						System.out.println(fileName);
						
						button.setEnabled(true);    //���ð�ť�ɵ��
 
						return;
					}
				});
				//ʵ�����ձ���-------end
 
			}

			
		});
}
}