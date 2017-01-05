package com.tswallpage.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
/**
 * ��ҳ����
 * @author Forever
 *
 */
@Repository("pageBean")
public class PageBean {
	private Integer totalCount;																// �ܼ�¼��
	private Integer pageLine;																// ÿҳ��ѯ��¼��
	private Integer currentPage;															// ��ǰҳ��
	private Integer pageNum;																// ��ҳ��
	private Integer start;																	// ��ѯ��ʼ��
	private Integer end;																	// ��ѯ������

	private List<Object> list;																// ��ѯ�Ľ����װ����

	PageBean() {
	}

	public PageBean(Integer totalCount, Integer pageLine, Integer currentPage) {
		this.totalCount = totalCount;
		this.pageLine = ((null == pageLine) ? 24 : pageLine);								// (Ĭ��24����¼)
		this.pageNum = this.countPageNum(this.getTotalCount(), this.getPageLine());
		this.currentPage = ((null == currentPage) ? 1
				: ((currentPage > this.getPageNum()) ? this.getPageNum() : currentPage));	// Ĭ�ϵ�1ҳ,������������ҳ������ô��չʾĩҳ
		this.start = this.countStart(this.getCurrentPage(), this.getPageLine());
		this.end = this.countEnd(this.getCurrentPage(), this.getPageLine());
	}

	/**
	 * �����ҳ����
	 * 
	 * @param totalCount
	 *            --�ܼ�¼��
	 * @param pageLine
	 *            --ÿҳ��¼��
	 * @return
	 */
	public Integer countPageNum(Integer totalCount, Integer pageLine) {
		int pageNum;
		if (totalCount % pageLine > 0) {
			pageNum = totalCount / pageLine + 1;
		} else {
			pageNum = totalCount / pageLine;
		}
		return pageNum;
	}

	/**
	 * �����ѯ��ʼ��
	 * 
	 * @param currentPage
	 *            --��ǰҳ��
	 * @param pageLine
	 *            --ÿҳ��¼��
	 * @return
	 */
	public Integer countStart(Integer currentPage, Integer pageLine) {
		int start = (currentPage - 1) * pageLine + 1;
		return start;
	}

	/**
	 * �����ѯ������
	 * 
	 * @param currentPage
	 *            --��ǰҳ��
	 * @param pageLine
	 *            --ÿҳ��¼��
	 * @return
	 */
	public Integer countEnd(Integer currentPage, Integer pageLine) {
		// ��ĩҳʱ�Ľ�����ѯ��
		int end = currentPage * pageLine;
		if (currentPage == this.getPageNum()) {
			int remainder = this.getTotalCount() % pageLine;
			if (remainder > 0) {
				// ���һҳʣ��ļ�¼��������ֻ��1ҳ�������
				end = (currentPage - 1) * pageLine + remainder;
			}
		}
		return end;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPageLine() {
		return pageLine;
	}

	public void setPageLine(Integer pageLine) {
		this.pageLine = pageLine;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		String rn = "\r\n";
		String sp = ":";
		String sp1 = " ";
		// ��ӡ���
		String info = "��¼����" + sp + rn;
		if (null == list) {
			this.setList(new ArrayList<Object>());
		}
		for (int x = 0; x < list.size(); x++) {
			info += "��¼" + x + sp + list.get(x).toString() + rn;
		}
		info += "�ܼ�¼����" + this.getTotalCount() + sp1;
		info += "��ҳ����" + this.getPageNum() + rn;
		info += "��ǰҳ��" + this.getCurrentPage() + sp1;
		info += "ÿҳ����" + this.getPageLine() + rn;
		info += "start:" + this.getStart() + sp1;
		info += "end:" + this.getEnd();
		return info;
	}

}
