package com.tswallpage.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tswallpage.entity.Picture;
import com.tswallpage.service.PictureService;

/**
 * 
 * @author Forever
 *
 */
@Controller
@RequestMapping("/pictureAction")
public class PictureAction {
	@Resource(name="pictureService")
	private PictureService pictureService;
	
	//�ϴ�ͼƬ
	@RequestMapping("/uploadPicture")
	public String uploadPicture(Picture p){
		
		System.out.println("----uploadAction----");
		if(pictureService.uploadPicture(p)){
			return "pages/users_info";
		}
		return "error";
	}
	
	//ɾ��ͼƬ
	@RequestMapping("/delPicture")
	public String delPicture(Picture p){
		if(pictureService.delPicture(p)){
			return "";
		}
		return "error";
	}
	
	//��ѯ���û���ȫ��ͼƬ
	@RequestMapping("/findAllPicture")
	@ResponseBody
	public List findAllPicture(int id){
		return pictureService.findAllPicture(id);
	}
	
	
	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}
}
