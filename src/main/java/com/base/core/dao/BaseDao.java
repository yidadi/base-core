package com.base.core.dao;

/**
 * @author yidadi
 * @description DAO层的基础抽象类
 * @date 2017-04-05 14:55
 */
public interface BaseDao<E> extends InsertDao<E>, DeleteDao<E>, UpdateDao<E>, QueryDao<E>, PagingDao<E> {
}
