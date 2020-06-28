package com.t.s.eyecloud.common.data.base;

import java.io.Serializable;
import java.util.List;

/**
 * Desc: 分页数据结构
 * Info: <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年11月28日
 */
public class PageResultVO<T> implements Serializable {

	private static final long serialVersionUID = 7436276186245962773L;

	private List<T> list;
	/**
	 * 当前页数
	 */
	private Long pageNo;

	/**'
	 * 每页显示行数
	 */
	private Long pageSize;

	private Long totalCnt;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Long getPageNo() {
		return pageNo;
	}

	public void setPageNo(Long pageNo) {
		this.pageNo = pageNo;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(Long totalCnt) {
		this.totalCnt = totalCnt;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PageResultVO [list=").append(list).append(", pageNo=").append(pageNo).append(", pageSize=")
				.append(pageSize).append(", totalCnt=").append(totalCnt).append("]");
		return builder.toString();
	}

}
