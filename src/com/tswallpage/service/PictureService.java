package com.tswallpage.service;

import java.util.List;

import com.tswallpage.entity.Picture;

/**
 * 
 * @author Forever
 *
 */
public interface PictureService {
	//���ͼƬ
	public boolean uploadPicture(Picture p);
	
	//ɾ��ͼƬ
	public boolean delPicture(Picture p);
	
	//����ID��ѯͼƬ
	public Picture findPictureById(int id);
	
	//�޸�ͼƬ
	public boolean updatePicture(Picture p);
	
	//��ѯ���û�������ͼƬ
	public List findAllPicture(int id);
	
	//����uuid��������ѯͼƬ
	public Picture findPictureByUUIDNane(String uname);
	
	//��ѯȫ��ͼƬ
	public List queryAllPicture();
}
