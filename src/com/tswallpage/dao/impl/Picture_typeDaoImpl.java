package com.tswallpage.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tswallpage.dao.Picture_typeDao;
import com.tswallpage.entity.Picture_type;
/**
 * 
 * @author Forever
 *
 */
@Repository("picture_typeDao")
public class Picture_typeDaoImpl extends BaseDao implements Picture_typeDao {
	//�������
	@Override
	public boolean addType(Picture_type pt) {
		return addObject(pt)!=null?true:false;
	}
	
	//ɾ������
	@Override
	public boolean delType(Picture_type pt) {
		return deleteObject(pt);
	}
	
	//����ID��������
	@Override
	public Picture_type findPtById(int id) {
		return (Picture_type)executeQuery("from Picture_type where pt_id="+id).get(0);
	}
	
	//�޸�����
	@Override
	public boolean updateType(Picture_type pt) {
		return updateObject(pt);
	}
	
	//����ȫ������
	@Override
	public List findAllPt() {
		return executeQuery("from Picture_type");
	}

}
