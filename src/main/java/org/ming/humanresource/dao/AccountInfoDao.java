package org.ming.humanresource.dao;

import org.ming.humanresource.base.BaseDao;
import org.ming.humanresource.model.AccountInfo;
/**
 * 系统账号信息Dao：AccountInfoDao.java
 * @author MingXiangjun
 * @create 2017/12/10-12:57
 */
public interface AccountInfoDao extends BaseDao{
    public AccountInfo findByAccount(String account);
    public AccountInfo findByAccountAndPwd(String acount,String password);
}
