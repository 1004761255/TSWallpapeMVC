package com.tswallpage.service;

import com.tswallpage.entity.Users;

public interface UsersService {
	//ע���û�
	public Users addUsers(Users u);
	
	//��¼
	public Users login(Users u);
	
	//�޸��û���Ϣ
	public boolean updateUsers(Users u);
	
	//����ID��ѯ�û���Ϣ
	public Users findUsersById(Users u);
	public Users findUsersById2(int id);
	
	
	//�޸�����
	public boolean updatePassword(Users u);
}
