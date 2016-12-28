package com.tswallpage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tswallpage.dao.PictureDao;
import com.tswallpage.entity.Picture;
import com.tswallpage.service.PictureService;

/**
 * 
 * @author Forever
 *
 */
@Service("pictureService")
public class PictureServiceImpl implements PictureService{
	
	@Resource(name="pictureDao")
	private PictureDao pictureDao;
	
	//���ͼƬ
	@Override
	public boolean uploadPicture(Picture p) {
		return pictureDao.uploadPicture(p);
	}
	
	//ɾ��ͼƬ
	@Override
	public boolean delPicture(Picture p) {
		return pictureDao.delPicture(p);
	}
	
	//����ID����ͼƬ
	@Override
	public Picture findPictureById(int id) {
		return pictureDao.findPictureById(id);
	}
	
	//�޸�ͼƬ
	@Override
	public boolean updatePicture(Picture p) {
		return pictureDao.updatePicture(p);
	}
	
	//��ѯ���û�������ͼƬ
	@Override
	public List findAllPicture(int id) {
		return pictureDao.findAllPicture(id);
	}
	
	public void setPictureDao(PictureDao pictureDao) {
		this.pictureDao = pictureDao;
	}
}
