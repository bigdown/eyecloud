package com.t.s.eyecloud.common.data.base;

import java.io.Serializable;
import java.util.List;

import com.t.s.eyecloud.base.BaseTreeModel;

import io.swagger.annotations.ApiModelProperty;

/**
 * Desc: 通用树形结构
 * Info: <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年11月28日
 */
public class TreeVO<T extends BaseTreeModel> implements Serializable {

    private static final long serialVersionUID = -2925843318374535661L;

    @ApiModelProperty(value = "通用树形结构id（唯一）")
	private String id;

	@ApiModelProperty(value = "通用树形结构父级code")
	private String pid;

	@ApiModelProperty(value = "通用树形拓展数据")
	private Object data;

	@ApiModelProperty(value = "通用树形结构子级元素")
	private List<TreeVO<? extends BaseTreeModel>> children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public List<TreeVO<? extends BaseTreeModel>> getChildren() {
		return children;
	}

	public void setChildren(List<TreeVO<? extends BaseTreeModel>> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TreeVO [id=").append(id).append(", pid=").append(pid).append(", data=").append(data)
				.append(", children=").append(children).append("]");
		return builder.toString();
	}

}
