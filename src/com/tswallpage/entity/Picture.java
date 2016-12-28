package com.tswallpage.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ����ͼƬ��Ϣ��ʵ����
 * @author Forever
 *
 */
@Entity
@Table(name="tb_picture")
public class Picture {
	private int p_no;			//ͼƬID
	private String p_name;		//ԭͼƬ��
	private String p_path;		//·��+�Զ�������+��׺
	private int p_type;			//���ͱ�� 
	private Date p_date; 		//�ϴ�����
	private int p_praise; 		//��������
	private String P_describe;	//ͼƬ���������������Ĺؼ��ʣ�
	public Picture() {
		super();
	}
	public Picture(int p_no, String p_name, String p_path, int p_type, Date p_date, int p_praise, String p_describe) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_path = p_path;
		this.p_type = p_type;
		this.p_date = p_date;
		this.p_praise = p_praise;
		P_describe = p_describe;
	}
	@Id
	@GeneratedValue
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_path() {
		return p_path;
	}
	public void setP_path(String p_path) {
		this.p_path = p_path;
	}
	public int getP_type() {
		return p_type;
	}
	public void setP_type(int p_type) {
		this.p_type = p_type;
	}
	public Date getP_date() {
		return p_date;
	}
	public void setP_date(Date p_date) {
		this.p_date = p_date;
	}
	public int getP_praise() {
		return p_praise;
	}
	public void setP_praise(int p_praise) {
		this.p_praise = p_praise;
	}
	public String getP_describe() {
		return P_describe;
	}
	public void setP_describe(String p_describe) {
		P_describe = p_describe;
	}
}
