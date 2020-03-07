package com.tjl.controller;

import com.tjl.bean.User;
import com.tjl.dao.UserDao;
import com.tjl.dao.UserDao_Implement;
import com.tjl.view.View;

public class Control {

	public static void main(String[] args) {
		
		while (true) {
			
			//���ȸ��û�չʾ��¼����
			
			User user = View.indexView();
			
			UserDao_Implement udi = new UserDao_Implement();
			
			int type = udi.login(user);
			
			
				switch (type) {
				case -1:
					System.out.println("������������д����");
					break;
	
				case 1:
					System.out.println("����Ա��¼�ɹ�");
					//�������Աҳ��
					managerServer();
					break;
					
				case 2:
					System.out.println("ѧ����¼�ɹ�");
					//����ѧ��ҳ��
					studentServer();
					break;
					
				default:
					break;
				}
		}
		
		
		
	}

	private static void managerServer() {
		
		UserDao_Implement udi = new UserDao_Implement();
	
		while (true) {
			
			//չʾ����Ա��ͼ
			
			int managerMenuView = View.managerMenuView();
			
			boolean flag;
			
			switch (managerMenuView) {
			
			case 0://�˳�
				
				System.exit(-1);//�˳�����ϵͳ
				
				break;
				
			case 1://���
				
				User user_insert = View.addMenuView();
				
				flag= udi.insert(user_insert);
				
				System.out.println(flag?"��ӳɹ�":"���ʧ��");
				
				break;
				
			case 2://ɾ��
				
				String uname_delete = View.deleteMenuView();
				
				flag= udi.delete(uname_delete);
				
				System.out.println(flag?"ɾ���ɹ�":"ɾ��ʧ��");
				
				break;
				
			case 3://�޸�
				
				User user_update = View.updateMenuView();
				
				flag = udi.update(user_update);
				
				System.out.println(flag?"�޸ĳɹ�":"�޸�ʧ��");
				
				break;
				
			case 4://����
				
				String uname_selsect = View.selectMenuView();
				
				User user_select = udi.select(uname_selsect);
				
				System.out.println(View.printUser(user_select));
				
				break;

			default:
				break;
			}
			
		}
	}

	private static void studentServer() {

		//չʾ����Ա��ͼ
			
			
		}

}
