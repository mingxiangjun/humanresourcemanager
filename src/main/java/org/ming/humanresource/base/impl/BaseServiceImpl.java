package org.ming.humanresource.base.impl;

import org.apache.poi.ss.formula.functions.T;
import org.ming.humanresource.base.BaseDao;
import org.ming.humanresource.base.BaseService;
import org.ming.humanresource.base.Page;

import java.util.List;

/**
 * Service基类实现
 *
 * @author acer
 * @create 2017-12-11 10:58
 */
public class BaseServiceImpl<T> implements BaseService<T>{

    private BaseDao<T> baseDao;

    public void setBaseDao(BaseDao<T> baseDao){
        this.baseDao = baseDao;
    }

    @Override
    public void save(T entity) {
        baseDao.save(entity);
    }

    @Override
    public void delete(T entity) {
        baseDao.delete(entity);
    }

    @Override
    public void update(T entity) {
        baseDao.update(entity);
    }

    @Override
    public T findById(String id) {
        return baseDao.findById(id);
    }

    @Override
    public void deleteById(String id) {
        baseDao.deleteById(id);
    }

    @Override
    public List<T> findListByQuery(String hql, Object... values) {
        return baseDao.findListByQuery(hql,values);
    }

    @Override
    public Page findByPage(String hql, Page page, Object... values) {
        return baseDao.findByPage(hql,page,values);
    }
}
