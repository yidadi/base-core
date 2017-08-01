package com.base.core.util;

/**
 * @author yidadi
 * @description 分页的工具类
 * @date 2017-06-20 10:51
 */
public class PaginationUtils {

    /**
     * 计算总页数
     *
     * @param pageSize  分页数
     * @param totalRows 总条数
     * @return
     */
    public static Integer calculateTotalPage(Integer pageSize, Long totalRows) {
        return Long.valueOf(((totalRows - 1) / pageSize + 1)).intValue();
    }
}
