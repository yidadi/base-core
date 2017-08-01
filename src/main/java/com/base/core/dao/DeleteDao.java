package com.base.core.dao;

import java.io.Serializable;

/**
 * @author yidadi
 * @description 删除实体接口
 * @date 2017-04-05 14:46
 */
public interface DeleteDao<E> {

    /**
     * 删除实体类
     *
     * @param id
     */
    void remove(Serializable id);

    /**
     * 删除实体类
     *
     * @param e
     */
    void remove(E e);
}
