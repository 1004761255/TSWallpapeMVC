package com.tswallpage.dao;

import java.util.List;

import com.tswallpage.entity.Users;

public interface UsersDao {
	//����û�
	public Users addUsers(Users u);
	
	//�ж��û��Ƿ����
	public Users findUsersByName(Users u);
	
	//��֤�˺������Ƿ���ȷ
	public boolean loginUsers(Users u);
	
	//�޸��û���Ϣ
	public boolean updateUsers(Users u);
	
	//����ID��ѯ�û���Ϣ
	public Users findUsersById(Users u);
	public Users findUsersById2(int id);
	
	//�޸�����
	public boolean updatePassword(Users u);
	
}
