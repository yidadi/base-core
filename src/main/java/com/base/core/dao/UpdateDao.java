package com.base.core.dao;

/**
 * @author yidadi
 * @description 修改实体接口
 * @date 2017-04-05 14:44
 */
public interface UpdateDao<E> {

    /**
     * 修改实体类
     *
     * @param e
     */
    void update(E e);


}
