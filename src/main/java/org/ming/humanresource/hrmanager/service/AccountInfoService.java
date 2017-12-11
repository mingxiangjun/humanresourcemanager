package org.ming.humanresource.hrmanager.service;

import org.ming.humanresource.base.BaseService;
import org.ming.humanresource.hrmanager.model.AccountInfo;

/**
 * AccountInfoService
 * @author acer
 * @create 2017-12-10 20:12
 **/
public interface AccountInfoService extends BaseService<AccountInfo>{
    /**
     * 根据账号密码信息查找账户
     * @param account
     * @param password
     * @return
     */
    public AccountInfo findByAccountAndPwd(String account,String password);

    /**
     * 根据账号信息查找用户信息
     * @param account
     * @return
     */
    public AccountInfo findByAccount(String account);
}
