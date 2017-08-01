package com.base.core.page;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * 分页包装类
 *
 * @author yidadi
 * @date 2016-08-18 14：07
 */
//@ApiModel(value = "分页包装类")
public abstract class Page<E> implements Serializable {

    private static final long serialVersionUID = 6913615974516038024L;

    /**
     * 分页信息
     */
//    @ApiModelProperty(name = "pagination", value = "分页信息")
    protected Pagination pagination;

    protected List<E> rows;

    public abstract  List<E> getRows();

    public abstract void setRows(List<E> rows);

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
