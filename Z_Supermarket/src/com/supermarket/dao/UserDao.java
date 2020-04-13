package com.supermarket.dao;

import com.supermarket.model.User;

//����һ���ӿڣ����ڽӿڵĻ���֪ʶ�����Java���ļ�����p117-124

//�ӿڵ�ʵ����UserDao_Implement.java��

//��java�������ݿ⣬ʵ������ͨ������MySQL����������ݿ���в�����

public interface UserDao {

	
	/**��֤��¼�ķ���
	 * @param userҪ��¼���û�		uname�˺�		upass����
	 * @return int����			1 ����Ա��¼		2 ��ͨ�û���¼			0 �쳣		-1 �˺Ų�����		-2 ���벻��ȷ		
	 */
	int login(User user);
	
	/**��������û���Ϣ�ķ���
	 * @param	userҪ��ӵ��û�		�����˺ź�����
	 * @return	false	ʧ��		true	�ɹ�
	 */
	boolean insert(User user);
	
	/**����ɾ���û���Ϣ�ķ���
	 * @param	unameҪɾ�����û�		�����˺ź�����
	 * @return	false	ʧ��		true	�ɹ�
	 */
	boolean delete(String uname);
	
	/**�����޸��û���Ϣ�ķ���
	 * @param	userҪ�޸ĵ��û�		�����˺ź�����
	 * @return	false	ʧ��		true	�ɹ�
	 */
	boolean update(User user);
	
	/**������ѯ�û���Ϣ�ķ���
	 * @param unameҪ��ѯ���û�
	 * @return ��ѯ�ɹ�����user		ʧ�ܷ���null
	 */
	User select(String uname);
	
}
