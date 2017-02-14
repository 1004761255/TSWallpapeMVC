package com.tswallpage.web;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import com.tswallpage.entity.Picture_user;
import com.tswallpage.entity.Users;
import com.tswallpage.service.PictureService;
import com.tswallpage.service.Picture_userService;
import com.tswallpage.service.UsersService;
import com.tswallpage.util.CreateUUID;
import com.tswallpage.util.MyDateFormat;
import com.tswallpage.util.PageBean;

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
	@Resource(name="usersService")
	private UsersService usersService;
	@Resource(name="picture_userService")
	private Picture_userService picture_userService;
	
	
	//�ϴ�ͼƬ
	@RequestMapping("/uploadPicture")
	@ResponseBody
	public boolean uploadFiles(Picture p,@RequestParam("file_upload") MultipartFile [] files,
			HttpServletRequest request,String pname1,String pname2,String pname3,
			String pdescribe1,String pdescribe2,String pdescribe3,int picture_leixing,
			Users u,Picture_user pu){
		
	    boolean result = false;
	    String realPath;
	    String path = request.getSession().getServletContext().getRealPath("/picture/HD");	//Tomcat��Ŀ¼+picture/HD������·����
	    
	    for(int i=0;i<files.length;i++){
	        if (!files[i].isEmpty()) { 
				String uuid = CreateUUID.getUUID();											//����uuid
				String pictureName = files[i].getOriginalFilename();						//�õ�ԭ�ļ���
				String suffix = pictureName.substring(pictureName.length()-3);				//�ļ���ȡ��׺
				realPath = path + "/" + uuid + "." + suffix;								//��Ŀ��Ŀ¼/picture/HD/�Զ�������+��׺������·��+ͼƬ��+��׺��
				String relativePath = "picture/HD" + "/" + uuid + "." + suffix;				//���·��+��׺
				
				p.setP_date(new Date());													//�ϴ�����
				p.setP_path(relativePath);													//����·��(���·��)
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
				
				//���浽���ݿ�
	    		if(pictureService.uploadPicture(p)){
	    			//�����û�ID���û���Ϣ
	    			u = usersService.findUsersById2(u.getU_no());
					//�޸��û���Ϣ --> �����û����ϴ�ͼƬ����
			    	u.setU_upload(u.getU_upload()+1);
			    	
			    	if(usersService.updateUsers2(u)){
			    		//����û�ͼƬ�м����Ϣ
			    		
			    		//�����Զ���������ͼƬ����Ϊ�Զ���������uuid���ɵģ���Ψһ�ģ�
						Picture pic = pictureService.findPictureByUUIDNane(relativePath);
			    		pu.setPu_uno(u.getU_no());											//�ϴ���ID
			    		pu.setPu_pno(pic.getP_no());										//ͼƬID
			    		
			    		if(picture_userService.addPicture_userDao(pu)){
			    			//������Ϣ�޸ĳɹ��󱣴�ͼƬ
			    			try {
								files[i].transferTo(new File(realPath));					// �����ļ�
								result = true;
							} catch (IllegalStateException | IOException e) {
								e.printStackTrace();
							}
			    		}
			    	}
				}
	        }  
	    }
	    return result;
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
	
	//��ѯȫ��ͼƬ
	@RequestMapping("queryAllPicture")
	@ResponseBody
	public List queryAllPicture(){
		return pictureService.queryAllPicture();
	} 
	
	//��ҳ��ѯͼƬ
	@RequestMapping("/pagingQuery")
	@ResponseBody
	public PageBean pagingQuery(int number){
		PageBean pb = pictureService.pagingQuery(number);
		/*MyDateFormat d = new MyDateFormat();
		
		for (int i = 0; i < pb.getList().size(); i++) {
			Picture p = (Picture)pb.getList().get(i);
			p.setP_date(d.parse(d.format(p.getP_date(), "yyyy-MM-dd HH:mm:ss")));
		}*/
		
		return pb;
	}
	
	
	
	
	
	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public void setPicture_userService(Picture_userService picture_userService) {
		this.picture_userService = picture_userService;
	}
	
}
