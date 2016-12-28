package com.tswallpage.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tswallpage.entity.Users;
import com.tswallpage.service.UsersService;

/**
 * 
 * @author Forever
 *
 */
@Controller
@RequestMapping("/usersAction")
public class UsersAction {
	@Resource(name="usersService")
	private UsersService usersService;
	
	//ע���û�
	@RequestMapping("/addUsers")
	public String addUsers(Users u){
		usersService.addUsers(u);
		return "redirect:/pages/users_login.jsp";
	}
	//��¼
	@RequestMapping("/login")
	public String login(Users u,HttpSession session){
		Users users = usersService.login(u);
		if(users!=null){
			//������룬�Է�����й¶
			users.setU_pass("");
			//���û����浽session��
			session.setAttribute("user", users);
			session.getAttribute("user");
			return "redirect:/index.jsp";
		}
		return "error";
	}
	//�˳���¼
	@RequestMapping("/logout")
	public String logout(Users u,HttpSession session){
		session.invalidate();
		return "redirect:/index.jsp";
	}
	
	//�޸��û���Ϣ���޸� �û������Ա����䡢����ǩ�����ֻ����롢�������䣩
	@RequestMapping("/updateUsers")
	public String updateUsers(Users u,String result,HttpServletRequest request,HttpSession session){
		if(usersService.updateUsers(u)){
			result = "true";
			request.setAttribute("result", result);
			return "pages/users_info";
		}
		result = "false";
		request.setAttribute("result", result);
		return "pages/users_info";
	}
	//����ID��ѯ�û���Ϣ
	@RequestMapping("/findUsersById")
	public Users findUsersById(Users u,int id){
		System.out.println("id:"+id);
		u = usersService.findUsersById2(id);
		System.out.println(u);
		return u;
	}
	
	//�޸�����
	@RequestMapping("/updatePassword")
	public String updatePassword(Users u,String message,HttpServletRequest request){
		//��֤������
		if(usersService.login(u) != null){
			//��֤�ɹ����޸�����
			u.setU_pass(u.getNewPassword());
			if(usersService.updatePassword(u)){
				//�޸ĳɹ�
				return "pages/users_info";
			}
		}
		//���������
		return "pages/users_info";
	}
	
	
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
}
