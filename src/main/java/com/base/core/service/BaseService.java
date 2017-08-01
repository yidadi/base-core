package com.base.core.service;

import com.base.core.dao.BaseDao;
import com.base.core.page.Page;
import com.base.core.page.Pagination;
import com.base.core.query.Query;

import java.io.Serializable;
import java.util.List;

/**
 * @author yidadi
 * @description 服务层的基类抽象类
 * @date 2017-04-06 13:30
 */
public interface BaseService<E> {

    /**
     * 新增实体类
     *
     * @param e
     * @return
     */
    default void save(E e) {
        this.getBaseDao().save(e);
    }

    /**
     * 删除实体类
     *
     * @param id
     */
    default void remove(Serializable id) {
        this.getBaseDao().remove(id);
    }

    /**
     * 删除实体类
     *
     * @param e
     */
    default void remove(E e) {
        this.getBaseDao().remove(e);
    }

    /**
     * 修改实体类
     *
     * @param e
     */
    default void update(E e) {
        this.getBaseDao().update(e);
    }

    /**
     * 根据主键查询某个实体类
     *
     * @param id
     * @return
     */
    default E findById(Serializable id) {
        return this.getBaseDao().findById(id);
    }

    /**
     * 根据分页信息查询出总的记录数
     *
     * @param query
     * @return 总条数
     */
    default Long countByQuery(Query query) {
        return this.getBaseDao().countByQuery(query);
    }

    /**
     * 根据分页信息查询出所有实体类
     *
     * @param query
     * @return
     */
    default List<E> findByQuery(Query query) {
        return this.getBaseDao().findByQuery(query);
    }

    /**
     * 查询所有的实体类
     *
     * @return
     */
    default List<E> findAll() {
        return this.getBaseDao().findAll();
    }

    /**
     * 根据分页信息查询具体的分页包装类
     *
     * @param query
     * @return
     */
    default <P extends Page<E>> P findPageByQuery(Query query) {
        P page = this.getPage();
        Pagination p = new Pagination(query);
        p.setTotalRows(this.countByQuery(query));
        page.setRows(this.findByQuery(query));
        page.setPagination(p);
        return page;
    }

    /**
     * 初始化子类的Dao
     *
     * @return
     */
    BaseDao<E> getBaseDao();

    /**
     * 初始化业务对象的Page子类
     *
     * @param <P>
     * @return
     */
    <P extends Page<E>> P getPage();
}
