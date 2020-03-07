package com.tjl.view;

import java.util.Scanner;

import com.tjl.bean.User;

public class View {

	private static Scanner input = new Scanner(System.in);

    /*** ��ҳ����
     * @return �����û�
     */
    public static User indexView(){
        System.out.println("***********************************");
        System.out.println("********\tѧ����Ϣ����ϵͳ\t*******");
        System.out.println("*********\t�������ʾ����\t*******");
        System.out.println("**********\t�������˺ţ�\t***********");
        String uname = input.nextLine();
        System.out.println("**********\t���������룺\t***********");
        String upass = input.nextLine();
        System.out.println("***********************************");
        return new User(uname,upass);
    }

    /*** �����߲˵�����
     * @return ���ز���ѡ��
     */
    public static int managerMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t��ӭ����Ա�ؼ�\t*******");
        System.out.println("*********\t�������ʾ����\t*******");
        System.out.println("**********\t0.�˳�\t\t***********");
        System.out.println("**********\t1.���ѧ����Ϣ\t***********");
        System.out.println("**********\t2.ɾ��ѧ����Ϣ\t***********");
        System.out.println("**********\t3.�޸�ѧ����Ϣ\t***********");
        System.out.println("**********\t4.��ѯѧ����Ϣ\t***********");
        boolean flag = true;
        int num = 5;
        while(flag){
            //ת��Ϊ���ͣ�����ֻ��ʹ��nextLine������ʹ��nextInt�������ֱ����ת����һ������
            num = Integer.parseInt(input.nextLine());
            if (num >= 0 && num <= 4) {
                flag = false;//�˳�ѭ��
                break;
            }
            System.out.println("����������������룺");
        }
        System.out.println("***********************************");
        return num;
    }

    /*** �����û�����
     * @return �������ӵ��û���Ϣ
     */
    public static User addMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t����û�����\t*******");
        System.out.println("*********\t�������ʾ����\t*******");
        System.out.println("**********\t�������˺ţ�\t***********");
        String uname = input.nextLine();
        System.out.println("**********\t���������룺\t***********");
        String upass = input.nextLine();
        System.out.println("***********************************");
        return new User(uname,upass);
    }

    /*** ɾ���û�����
     * @return ����ɾ�����û���Ϣ
     */
    public static String deleteMenuView(){
        System.out.println("***********************************");
        System.out.println("********\tɾ���û�����\t*******");
        System.out.println("*********\t�������ʾ����\t*******");
        System.out.println("**********\t�������˺ţ�\t***********");
        String uname = input.nextLine();
        System.out.println("***********************************");
        return uname;
    }

    /*** �����޸��û�����
     * @return �����޸ĵ��û���
     */
    public static User updateMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t�޸��û�����\t*******");
        System.out.println("*********\t�������ʾ����\t*******");
        System.out.println("**********\t�������˺ţ�\t***********");
        String uname = input.nextLine();
        System.out.println("**********\t�����������룺\t***********");
        String upass = input.nextLine();
        System.out.println("***********************************");
        
        System.out.println(uname+"\t"+upass);
        
        return new User(uname,upass);
    }

    /*** ��ѯ�û�����
     * @return ���ز�ѯ���û���Ϣ
     */
    public static String selectMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t��ѯ�û�����\t*******");
        System.out.println("*********\t�������ʾ����\t*******");
        System.out.println("**********\t�������ѯ�˺ţ�\t***********");
        String uname = input.nextLine();
        System.out.println("***********************************");
        return uname;
    }
    
    /**����û���Ϣ
     * @return �û���ȫ����Ϣ��������ԱȨ��ʹ�ã�
     */
    public  static String printUser(User user) {
		
    	String print_info="ID��"+user.getId()+"\t�û�����"+user.getUname()+"\t�û����룺"+user.getUpass()+"\t�û�Ȩ�ޣ�";
    	
    	
    	switch (user.getType()) {
		case 1:
			print_info+="����Ա";
			break;
		case 2:
			print_info+="ѧ��";
			break;
		default:
			break;
		}
    	
    	
    	return print_info;
	}

    /**
     * ѧ���˵�����
     * @return ���ز���ѡ��
     */
    public static int studentMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t��ӭѧ���ؼ�\t*******");
        System.out.println("*********\t�������ʾ����\t*******");
        System.out.println("**********\t0.�˳�\t\t***********");
        System.out.println("**********\t1.�޸�����\t***********");
        boolean flag = true;
        int num = -1;
        while(flag){
            num = Integer.parseInt(input.nextLine());
            if (num >= 0 && num <= 1) {
                flag = false;//�˳�ѭ��
                break;
            }
            System.out.println("����������������룺");
        }
        System.out.println("***********************************");
        return num;
    }
    /*** �޸��������
     * @return �����޸ĵ��û���
     */
    public static String alterPassView(){
        System.out.println("***********************************");
        System.out.println("********\t�޸��������\t*******");
        System.out.println("*********\t�������ʾ����\t*******");
        System.out.println("**********\t�����������룺\t***********");
        String upass = input.nextLine();
        System.out.println("***********************************");
        return upass;
    }
}
