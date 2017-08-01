package com.base.core.query;

import java.io.Serializable;

/**
 * Query查询接口
 *
 * @author yidadi
 * @date 2016-10-11 23：17
 */
public interface Query extends Serializable {

    /**
     * 获取当前页
     *
     * @return
     */
    Integer getCurrentPage();

    /**
     * 获取当前分页数
     *
     * @return
     */
    Integer getPageSize();
}
