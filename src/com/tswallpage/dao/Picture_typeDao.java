package com.tswallpage.dao;

import java.util.List;

import com.tswallpage.entity.Picture_type;

public interface Picture_typeDao {
	//�������
	public boolean addType(Picture_type pt);
	
	//ɾ������
	public boolean delType(Picture_type pt);
	
	//����ID��������
	public Picture_type findPtById(int id);
	
	//�޸�����
	public boolean updateType(Picture_type pt);
	
	//��ѯȫ������
	public List findAllPt();
}
