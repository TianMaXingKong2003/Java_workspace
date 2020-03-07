package com.tjl.controller;

import com.tjl.bean.User;
import com.tjl.dao.UserDao;
import com.tjl.dao.UserDao_Implement;
import com.tjl.view.View;

public class Control {

	public static void main(String[] args) {
		
		while (true) {
			
			//首先给用户展示登录界面
			
			User user = View.indexView();
			
			UserDao_Implement udi = new UserDao_Implement();
			
			int type = udi.login(user);
			
			
				switch (type) {
				case -1:
					System.out.println("输入有误，请重写输入");
					break;
	
				case 1:
					System.out.println("管理员登录成功");
					//进入管理员页面
					managerServer();
					break;
					
				case 2:
					System.out.println("学生登录成功");
					//进入学生页面
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
			
			//展示管理员视图
			
			int managerMenuView = View.managerMenuView();
			
			boolean flag;
			
			switch (managerMenuView) {
			
			case 0://退出
				
				System.exit(-1);//退出整个系统
				
				break;
				
			case 1://添加
				
				User user_insert = View.addMenuView();
				
				flag= udi.insert(user_insert);
				
				System.out.println(flag?"添加成功":"添加失败");
				
				break;
				
			case 2://删除
				
				String uname_delete = View.deleteMenuView();
				
				flag= udi.delete(uname_delete);
				
				System.out.println(flag?"删除成功":"删除失败");
				
				break;
				
			case 3://修改
				
				User user_update = View.updateMenuView();
				
				flag = udi.update(user_update);
				
				System.out.println(flag?"修改成功":"修改失败");
				
				break;
				
			case 4://查找
				
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

		//展示管理员视图
			
			
		}

}
