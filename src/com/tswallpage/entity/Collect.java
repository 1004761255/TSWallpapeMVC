package com.tswallpage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * �����û��ղ�ͼƬ����Ϣ
 * @author Forever
 *
 */
@Entity
@Table(name="tb_collect")
public class Collect {
	private int  c_no;		//�ղر�ID
	private int c_uno;		//�û�ID
	private int c_pno;		//ͼƬID
	public Collect() {
		super();
	}
	public Collect(int c_no, int c_uno, int c_pno) {
		super();
		this.c_no = c_no;
		this.c_uno = c_uno;
		this.c_pno = c_pno;
	}
	
	@Id
	@GeneratedValue
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public int getC_uno() {
		return c_uno;
	}
	public void setC_uno(int c_uno) {
		this.c_uno = c_uno;
	}
	public int getC_pno() {
		return c_pno;
	}
	public void setC_pno(int c_pno) {
		this.c_pno = c_pno;
	}
}
