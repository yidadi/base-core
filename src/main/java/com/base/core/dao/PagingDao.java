package com.base.core.dao;

import com.base.core.query.Query;

import java.util.List;

/**
 * @author yidadi
 * @description
 * @date 2017-04-05 14:48
 */
public interface PagingDao<E> {

    /**
     * 根据分页信息查询出所有实体类
     *
     * @param query
     * @return
     */
    List<E> findByQuery(Query query);
}
