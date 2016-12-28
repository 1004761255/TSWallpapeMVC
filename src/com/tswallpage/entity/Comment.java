package com.tswallpage.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ����ͼƬ���۵���Ϣ
 * @author Forever
 *
 */
@Entity
@Table(name="tb_comment")
public class Comment {
	private int co_no;				//ͼƬ���۱�ID
	private int co_p_no;			//ͼƬID
	private int co_u_no;			//�û�ID
	private String co_content;		//��������
	private Date co_time;			//��������
	private int co_count; 			//���۱�������
	public Comment() {
		super();
	}
	public Comment(int co_no, int co_p_no, int co_u_no, String co_content, Date co_time, int co_count) {
		super();
		this.co_no = co_no;
		this.co_p_no = co_p_no;
		this.co_u_no = co_u_no;
		this.co_content = co_content;
		this.co_time = co_time;
		this.co_count = co_count;
	}
	
	@Id
	@GeneratedValue
	public int getCo_no() {
		return co_no;
	}
	public void setCo_no(int co_no) {
		this.co_no = co_no;
	}
	public int getCo_p_no() {
		return co_p_no;
	}
	public void setCo_p_no(int co_p_no) {
		this.co_p_no = co_p_no;
	}
	public int getCo_u_no() {
		return co_u_no;
	}
	public void setCo_u_no(int co_u_no) {
		this.co_u_no = co_u_no;
	}
	public String getCo_content() {
		return co_content;
	}
	public void setCo_content(String co_content) {
		this.co_content = co_content;
	}
	public Date getCo_time() {
		return co_time;
	}
	public void setCo_time(Date co_time) {
		this.co_time = co_time;
	}
	public int getCo_count() {
		return co_count;
	}
	public void setCo_count(int co_count) {
		this.co_count = co_count;
	}
}
