package com.tswallpage.service;

import java.util.List;

import com.tswallpage.entity.Picture_type;

/**
 * 
 * @author Forever
 *
 */
public interface Picture_typeService {
	//���ͼƬ����
	public boolean addPicture_type(Picture_type pt);
	
	//ɾ��ͼƬ����
	public boolean delPicture_type(Picture_type pt);
	
	//����ID����ͼƬ����
	public Picture_type findPtById(int id);
	
	//�޸�ͼƬ
	public boolean updatePt(Picture_type pt);
	
	//��ѯȫ������
	public List findAllPt();
}
