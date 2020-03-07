package com.music.view;

import java.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.*;
import javax.swing.table.*;
import java.net.*;
 
public class MainPage extends JFrame{
	
	private static final long serialVersionUID = 1L; 
	private JPanel jContentPane = null;
	private JTextField filePath = null;
	private JButton openFile = null;
	private JButton playButton = null;
	private File selectedFile;
	private AudioClip audioClip;
	private JButton button;
	
	private boolean zanting=false;
	
	Scanner stdin=new Scanner(System.in);
	private JButton button_1;
 
	//��ʾѡ�����Ƶ�ļ�
	private JTextField getJTextField() {
		
		if (filePath == null) {
			filePath = new JTextField();
			filePath.setPreferredSize(new Dimension(200, 20));//�����ı���Ĵ�С
			filePath.setBackground(Color.WHITE);
			filePath.setEditable(false);//�����ı����ܽ��б༭
		}
		return filePath;
	}
	
	// ��ȡѡ����Ƶ�ļ���ť
	private JButton getOpenFile() {
		
		if (openFile == null) {
			openFile = new JButton();
			openFile.setText("ѡ����Ƶ");
			openFile.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					JFileChooser fileChooser = new JFileChooser();//�ļ�ѡ����
					fileChooser.setFileFilter(new FileNameExtensionFilter("֧�ֵ���Ƶ�ļ���*.MP3��*.WAV��", "wav", "WAV", "mp3", "MP3"));//����֧��ѡ�����Ƶ�ļ���ʽ
					fileChooser.showOpenDialog(MainPage.this);
					selectedFile = fileChooser.getSelectedFile();//��ȡѡ�����Ƶ�ļ�
					filePath.setText(selectedFile.getAbsolutePath());//�ı�����ʾѡ�����Ƶ�ļ�
				}
			});
		}
		return openFile;
	}
	
	// ��ȡ���Ű�ť
	private JButton getPlayButton() {
		if (playButton == null) {
			playButton = new JButton();
			playButton.setText("������Ƶ");
			playButton.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent e) {
							
							if (selectedFile != null) {
								
								try {
									if (audioClip != null) {//�������Ƶ�ڲ���
										audioClip.stop();//ֹͣ��ǰ��Ƶ�Ĳ���
										
									}
									audioClip = Applet.newAudioClip(selectedFile.toURI().toURL());//��ȡѡ�����Ƶ
									audioClip.play();//������Ƶ
									
									zanting=false;//��ͣ������
									
								} catch (MalformedURLException e1) {
									e1.printStackTrace();
								}
							}
						}
					});
		}
		return playButton;
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainPage test = new MainPage();
		test.setVisible(true);
 
	}
	
	public MainPage() {
		super();
		setTitle("Hern");
		setBounds(400, 400, 645, 430);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(getJContentPane());
		
	}
	
	
	// ��ʼ���������ķ���
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new FlowLayout());
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getOpenFile(), null);
			jContentPane.add(getPlayButton(), null);
			jContentPane.add(getButton());
			jContentPane.add(getButton_1());
		}
		return jContentPane;
	}
 
	private JButton getButton() {
		if (button == null) {
			button = new JButton("\u505C\u6B62");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					zanting=!zanting;
					
					if (zanting) {
						audioClip.stop();
					}else {
						audioClip.play();
					}
	
					
					
				}
			});
		}
		return button;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("\u5FAA\u73AF");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					audioClip.loop();
				}
			});
		}
		return button_1;
	}
}