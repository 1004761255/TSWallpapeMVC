package com.tswallpage.service;

import com.tswallpage.entity.Picture_user;

/**
 * 
 * @author Forever
 *
 */
public interface Picture_userService {
	//���
	public boolean addPicture_userDao(Picture_user pu);
	
	//ɾ��
	public boolean delPicture_userDao(Picture_user pu);
	
	//�޸�
	public boolean updatePicture_userDao(Picture_user pu);
}
