package com.base.core.dao;

/**
 * @author yidadi
 * @description 新增实体接口
 * @date 2017-04-05 14:40
 */
public interface InsertDao<E> {

    /**
     * 新增实体
     *
     * @param e
     */
    void save(E e);


    /**
     * 批量新增实体
     *
     * @param collection
     */
//    void batchSave(Collection<E> collection);

}
