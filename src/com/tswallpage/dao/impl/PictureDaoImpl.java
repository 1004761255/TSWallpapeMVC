package com.tswallpage.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.tswallpage.dao.PictureDao;
import com.tswallpage.entity.Picture;
/**
 * 
 * @author Forever
 *
 */
@Repository("pictureDao")
public class PictureDaoImpl extends BaseDao implements PictureDao {
	
	//���ͼƬ
	@Override
	public boolean uploadPicture(Picture p) {
		return addObject(p)!=null?true:false;
	}
	
	//ɾ��ͼƬ
	@Override
	public boolean delPicture(Picture p) {
		return deleteObject(p);
	}
	
	//����ID��ѯͼƬ
	@Override
	public Picture findPictureById(int id) {
		return (Picture)executeQuery("from Picture where p_no="+id).get(0);
	}
	
	//�޸�ͼƬ
	@Override
	public boolean updatePicture(Picture p) {
		return updateObject(p);
	}
	
	//��ѯ���û�������ͼƬ
	@Override
	public List findAllPicture(int id) {
		String sql = "select * from `tswallpape`.`tb_picture` p "
	+"left join `tswallpape`.`tb_picture_user` pr on p.p_no=pr.pu_pno "
	+"left join `tswallpape`.`tb_picture_type` pt on p.p_type=pt.pt_id where pr.pu_uno="+id;
		return getSession().createSQLQuery(sql).list();
	}

}
