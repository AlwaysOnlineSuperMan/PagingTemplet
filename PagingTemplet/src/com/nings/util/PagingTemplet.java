package com.nings.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页模板<分页对象>
 * 
 * @author nings
 *
 * @param <T>
 */
public class PagingTemplet<T> {
	// 共allRecord条记录
	private int allRecord;
	// 每页currRecord条记录
	private int currRecord;
	// 共allPageSize页
	private int allPageSize;
	// 当前第currPageNo页
	private int currPageNo;
	// 本页的结果集resultList
	private List<T> resultList = new ArrayList<T>();

	/*
	 * public void init(List<T> resultList){ this.allRecord = resultList.size();
	 * 
	 * }
	 */

	// 跳转第一页
	public int getFristPageNo() {
		return 0;
	}

	// 跳转上一页
	public int getPreviosPageNo() {
		return  currPageNo <= 1 ? 1 : currPageNo-1;
	}

	// 跳转下一页
	public int getNextPageNo() {
		return  currPageNo >= getAllPageSize() ? getAllPageSize() : currPageNo+1;
	}

	// 跳转最后一页
	public int getBottomPageNo() {
		return getAllPageSize();
	}

	public int getAllRecord() {
		return allRecord;
	}

	public void setAllRecord(int allRecord) {
		this.allRecord = allRecord;
	}

	public int getCurrRecord() {
		return currRecord;
	}

	public void setCurrRecord(int currRecord) {
		this.currRecord = currRecord;
	}

	// 获取总页数
	public int getAllPageSize() {
		return (allRecord + currRecord - 1) / currRecord;
	}

	public void setAllPageSize(int allPageSize) {
		this.allPageSize = allPageSize;
	}

	public int getCurrPageNo() {
		return currPageNo;
	}

	public void setCurrPageNo(int currPageNo) {
		this.currPageNo = currPageNo;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	public String toString() {
		return "PagingTemplet [allRecord=" + allRecord + ", currRecord=" + currRecord + ", allPageSize=" + allPageSize
				+ ", currPageNo=" + currPageNo + ", resultList=" + resultList + "]";
	}

}
