package org.ming.humanresource.hrmanager.dao;

import org.ming.humanresource.base.BaseDao;
import org.ming.humanresource.hrmanager.model.AccountInfo;
/**
 * 系统账号信息Dao：AccountInfoDao.java
 * @author MingXiangjun
 * @create 2017/12/10-12:57
 */
public interface AccountInfoDao extends BaseDao{
    /**
     * 根据账号查找信息（注册信息重名检索）
     * @param account
     * @return
     */
    public AccountInfo findByAccount(String account);

    /**
     * 更加账号密码查找用户账号信息（登录账号密码检索）
     * @param acount
     * @param password
     * @return
     */
    public AccountInfo findByAccountAndPwd(String acount,String password);

    /**
     * 根据安全账号问题检索账号（账号找回操作）
     * @param quesId
     * @param ansId
     * @return
     */
    public AccountInfo findBySecurityQuesAns(String quesId,String ansId);
}
