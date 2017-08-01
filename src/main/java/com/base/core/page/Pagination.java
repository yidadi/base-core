package com.base.core.page;


import com.base.core.query.Query;
import com.base.core.util.PaginationUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.Serializable;

/**
 * 分页信息类
 *
 * @author yidadi
 * @date 2016-09-09 09：59
 */
public class Pagination implements Serializable {

    private static final long serialVersionUID = -2033520789012497916L;

    /**
     * 默认的当前页
     */
    private static final Integer DEFAULT_FIRST_PAGE = NumberUtils.INTEGER_ONE;


    /**
     * 默认的每页条数
     */
    private static final Integer DEFAULT_PAGE_SIZE = NumberUtils.INTEGER_ONE * 20;


    /**
     * 当前页
     */
    private Integer currentPage = DEFAULT_FIRST_PAGE;

    /**
     * 每页条数
     */
    private Integer pageSize = DEFAULT_PAGE_SIZE;

    /**
     * 总记录条数
     */
    private Long totalRows;

    /**
     * 总页数
     */
    private Integer totalPages;

    public Pagination() {
    }

    public Pagination(Query query) {
        this.currentPage = query.getCurrentPage();
        this.pageSize = query.getPageSize();
    }

    public Pagination(Integer currentPage, Integer pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Long totalRows) {
        this.totalRows = totalRows;
    }

    public Integer getTotalPages() {
        return PaginationUtils.calculateTotalPage(this.pageSize, this.totalRows);
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
