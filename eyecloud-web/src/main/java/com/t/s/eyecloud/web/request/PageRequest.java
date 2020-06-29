package com.t.s.eyecloud.web.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * description: <简述>
 * info: <详细信息>
 *
 * @author: tanshen@qding.me
 * @Date:
 * @since [产品/模块版本]
 */
@Valid
public class PageRequest<T> {

    @ApiModelProperty(value = "请求数据体")
    private T data;

    @ApiModelProperty(value = "最后一条数据的id")
    private String lastId;

    @ApiModelProperty(value = "请求分页大小")
    @NotNull
    private Long pageSize;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public String getLastId() {
        return lastId;
    }

    public void setLastId(String lastId) {
        this.lastId = lastId;
    }
}
