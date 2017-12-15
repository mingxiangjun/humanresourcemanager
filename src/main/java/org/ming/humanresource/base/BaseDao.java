package org.ming.humanresource.base;

import org.ming.humanresource.common.model.Page;

import java.util.List;

/**
 * Dao基类
 * @author MingXiangjun
 * @create 2017/12/10-11:55
 */
public interface BaseDao<T> {
    /**
     * 保存
     * @param entity
     */
    public void save(T entity);

    /**
     * 删除
     * @param entity
     */
    public void delete(T entity);

    /**
     * 更新
     * @param entity
     */
    public void update(T entity);

    /**
     * 根据id查询实体
     * @param id
     * @return
     */
    public T findById(String id);

    /**
     * 根据id删除
     * @param id
     */
    public void deleteById(String id);

    /**
     * 根据HQL查询
     * @param hql
     * @param values
     * @return
     */
    public List<T> findListByQuery(String hql,Object... values);

    /**
     * 根据HQL查询单条记录
     * @param hql
     * @param values
     * @return
     */
    public T findSingleByQuery(String hql,Object... values);

    /**
     * 根据HQL分页器查询
     * @param hql
     * @param page
     * @param values
     * @return
     */
    public Page findByPage(String hql, Page page, Object... values);
}
