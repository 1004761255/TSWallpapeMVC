package com.tswallpage.dao;

import java.util.List;

import com.tswallpage.entity.Picture;
import com.tswallpage.util.PageBean;

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
	
	//����uuid��������ѯͼƬ
	public Picture findPictureByUUIDNane(String uname);
	
	//��ѯȫ��ͼƬ
	public List queryAllPicture();
	
	//��������ѯ
	//public List multi_condition();
	
	//��ҳ��ѯ
	public PageBean pagingQuery(int number);
}
