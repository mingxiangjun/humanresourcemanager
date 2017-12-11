package org.ming.humanresource.base.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ming.humanresource.base.BaseDao;
import org.ming.humanresource.base.Page;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 基类Dao实现
 * @author acer
 * @create 2017-12-10 12:06
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao {

    private Class<T> classEntity;
    public BaseDaoImpl() {
        //获取泛型实际类型
        Type genType = getClass().getSuperclass();
        if (genType instanceof ParameterizedType){
            classEntity = (Class)((ParameterizedType)genType).getActualTypeArguments()[0];
        }else{
            classEntity = (Class)Object.class;
        }
    }

    @Resource
    public void setSuperSessionFactory(SessionFactory sessionFactory){
        setSessionFactory(sessionFactory);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(Object entity) {
        getHibernateTemplate().save(entity);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Object entity) {
        getHibernateTemplate().delete(entity);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Object entity) {
        getHibernateTemplate().update(entity);
    }

    @Override
    public T findById(String id) {
        return getHibernateTemplate().get(classEntity,id);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteById(String id) {
        Object entity = findById(id);
        if (entity!=null){
            delete(entity);
        }
    }

    @Override
    public List findListByQuery(String hql, Object... values) {
        return getHibernateTemplate().find(hql,values);
    }

    /**
     * 根据HQL查询单条记录
     *
     * @param hql
     * @param values
     * @return
     */
    @Override
    public Object findSingleByQuery(String hql, Object... values) {
        List list = getHibernateTemplate().find(hql,values);
        if (list!=null && list.size() == 1) {
            return list.get(0);
        }else{
            logger.error("查询出错，查询出多条记录，HQL=["+hql+"],parameters=["+values+"]");
            return new Object();
        }
    }

    @Override
    public Page findByPage(final String hql, final Page page, final Object... values) {
        getHibernateTemplate().execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(hql);
                if (values!=null){
                    for (int i=0;i<values.length;i++){
                        query.setParameter(i,values[i]);
                    }
                    List countList = query.list();
                    int totalRows = countList!=null?countList.size():0;
                    //初始化分页器，生成startIndex、totalPage等信息
                    page.init(totalRows);
                    //分页
                    int startIndex = page.getStartIndex();
                    query.setFirstResult(startIndex);
                    query.setMaxResults(page.getPageSize());
                    List resultList = query.list();
                    page.setInfoList(resultList);
                }
                return page;
            }
        });
        return page;
    }
}
