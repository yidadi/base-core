package com.base.core.query;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * 分页包装类
 *
 * @author yidadi
 * @date 2016-08-18 14：07
 */
public class BaseQuery implements Query {

    private static final long serialVersionUID = 6913615974516038024L;

    /**
     * 默认的当前页
     */
    protected static final Integer DEFAULT_FIRST_PAGE = NumberUtils.INTEGER_ONE;


    /**
     * 默认的每页条数
     */
    protected static final Integer DEFAULT_PAGE_SIZE = NumberUtils.INTEGER_ONE * 20;

    private enum QueryParamsType {
        CURRENT_PAGE, PAGE_SIZE
    }

    /**
     * 每页条数
     */
    protected Integer pageSize = DEFAULT_PAGE_SIZE;

    /**
     * 当前页
     */
    protected Integer currentPage = DEFAULT_FIRST_PAGE;

    /**
     * 第一条记录
     */
    private Integer startRow;

    /**
     * 最后一条记录
     */
    private Integer endRow;


    @Override
    public Integer getCurrentPage() {
        return this.currentPage;
    }

    @Override
    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = this.getValidQueryParams(pageSize, QueryParamsType.PAGE_SIZE);
        this.setStartEndRow();
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = this.getValidQueryParams(currentPage, QueryParamsType.CURRENT_PAGE);
        this.setStartEndRow();
    }

    public Integer getStartRow() {
        this.setStartEndRow();
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getEndRow() {
        this.setStartEndRow();
        return endRow;
    }

    public void setEndRow(Integer endRow) {
        this.endRow = endRow;
    }

    /**
     * 验证请求查询参数是否合法
     *
     * @param params
     * @param pageType
     * @return
     */
    private Integer getValidQueryParams(Integer params, QueryParamsType pageType) {
        Integer initValue = DEFAULT_FIRST_PAGE;
        if (QueryParamsType.PAGE_SIZE == pageType) {
            initValue = DEFAULT_PAGE_SIZE;
        }
        return (null == params || NumberUtils.INTEGER_ONE.compareTo(params) > 0) ? initValue : params;
    }

    /**
     * 计算分页的开始行和结束行数
     */
    private void setStartEndRow() {
        this.startRow = this.getPageSize().intValue()
                * (this.getCurrentPage().intValue() - 1);
        this.endRow = this.startRow + this.getPageSize().intValue() - 1;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
