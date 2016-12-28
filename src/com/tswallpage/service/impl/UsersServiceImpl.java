package com.tswallpage.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tswallpage.dao.UsersDao;
import com.tswallpage.entity.Users;
import com.tswallpage.service.UsersService;
@Service("usersService")
public class UsersServiceImpl implements UsersService {
	@Resource(name="usersDao")
	private UsersDao usersDao;
	
	//ע���û�
	@Override
	public Users addUsers(Users u) {
		return usersDao.addUsers(u);
	}
	
	//��¼ 
	@Override
	public Users login(Users u) {
		//�����ж��û��Ƿ����
		Users users = usersDao.findUsersByName(u);
		if(users!=null){
			if(usersDao.loginUsers(u)){
				return users;
			}
		}
		return null;
	}
	
	//�޸��û���Ϣ
	@Override
	public boolean updateUsers(Users u) {
		return usersDao.updateUsers(u);
	}
	
	//����ID��ѯ�û���Ϣ
	@Override
	public Users findUsersById(Users u) {
		return usersDao.findUsersById(u);
	}
	@Override
	public Users findUsersById2(int id) {
		return usersDao.findUsersById2(id);
	}
	
	//�޸�����
	@Override
	public boolean updatePassword(Users u) {
		return usersDao.updatePassword(u);
	}
	

}
