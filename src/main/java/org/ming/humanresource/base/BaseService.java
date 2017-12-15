package org.ming.humanresource.base;

import org.ming.humanresource.common.model.Page;

import java.util.List;

/**
 * Service基类
 *
 * @author acer
 * @create 2017-12-10 20:15
 */
public interface BaseService<T> {
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
     * 更加id删除
     * @param id
     */
    public void deleteById(String id);

    /**
     * 根据HQL删除
     * @param hql
     * @param values
     * @return
     */
    public List<T> findListByQuery(String hql, Object... values);

    /**
     * 根据HQL分页器查询
     * @param hql
     * @param page
     * @param values
     * @return
     */
    public Page findByPage(String hql, Page page, Object... values);
}
