package com.tswallpage.dao;

import java.util.List;

import com.tswallpage.entity.Picture;

public interface PictureDao {
	//���ͼƬ
	public boolean uploadPicture(Picture p);
	
	//ɾ��ͼƬ
	public boolean delPicture(Picture p);
	
	//����ID��ѯͼƬ
	public Picture findPictureById(int id);
	
	//�޸�ͼƬ��Ϣ
	public boolean updatePicture(Picture p);
	
	//��ѯ���û�������ͼƬ
	public List findAllPicture(int id);
}
