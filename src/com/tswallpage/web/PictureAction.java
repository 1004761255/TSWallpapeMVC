package com.tswallpage.web;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tswallpage.entity.Picture;
import com.tswallpage.service.PictureService;
import com.tswallpage.util.CreateUUID;

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
	
	
	
	
	@RequestMapping("/uploadPicture2")
	@ResponseBody
	public boolean uploadFiles(Picture p,@RequestParam("file_upload") MultipartFile [] files,
			HttpServletRequest request,String pname1,String pname2,String pname3,
			String pdescribe1,String pdescribe2,String pdescribe3,int picture_leixing){
		
	    boolean result = false;
	    String realPath;
	    String path = request.getSession().getServletContext().getRealPath("/picture/HD");	//Tomcat��Ŀ¼+picture/HD
	    
	    
	    //�ϴ�
	    for(int i=0;i<files.length;i++){
	        if (!files[i].isEmpty()) { 
				String uuid = CreateUUID.getUUID();											//����uuid
				String pictureName = files[i].getOriginalFilename();						//�õ�ԭ�ļ���
				String suffix = pictureName.substring(pictureName.length()-3);				//�ļ���ȡ��׺
				realPath = path + "/" + uuid + "." + suffix;								//�ϴ�������Ŀ��Ŀ¼/picture/HD��
				
				System.out.println("ԭ�ļ�����"+pictureName);
				System.out.println("�ϴ�·��+�Զ�������+��׺"+realPath);
				
				
				//���浽���ݿ�
				p.setP_date(new Date());													//�ϴ�����
				p.setP_path(realPath);														//����·��
				p.setP_type(picture_leixing);												//ͼƬ����
				
				//��ȡͼƬ����
				String pn = "pname" + (i+1);
				if(pn.equals("pname1")){
					p.setP_name(pname1);
				}else if(pn.equals("pname2")){
					p.setP_name(pname2);
				}else if(pn.equals("pname3")){
					p.setP_name(pname3);
				}
				if(p.getP_name()==null || p.getP_name().length()<1){
					p.setP_name(pictureName.substring(0, pictureName.length()-4));
				}
				
				//��ȡͼƬ����
				String pd = "pdescribe" + (i+1);
				if(pd.equals("pdescribe1")){
					p.setP_describe(pdescribe1);
				}else if(pd.equals("pdescribe2")){
					p.setP_describe(pdescribe2);
				}else if(pd.equals("pdescribe3")){
					p.setP_describe(pdescribe3);
				}
				
			    if(pictureService.uploadPicture(p)){
			    	try {
						files[i].transferTo(new File(realPath));							// �����ļ�
						result = true;
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
					}
				}			
	        }  
	    }
	    return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}
}
