package com.base.core.dao;

import com.base.core.query.Query;

import java.io.Serializable;
import java.util.List;

/**
 * @author yidadi
 * @description 查询实体接口
 * @date 2017-04-05 14:47
 */
public interface QueryDao<E> {


    /**
     * 根据主键查询某个实体类
     *
     * @param id
     * @return
     */
    E findById(Serializable id);


    /**
     * 根据分页信息查询出总的记录数
     *
     * @param query
     * @return 总条数
     */
    Long countByQuery(Query query);


    /**
     * 查询所有实体类
     *
     * @return
     */
    List<E> findAll();

}
