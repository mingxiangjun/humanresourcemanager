package org.ming.humanresource.hrmanager.service.impl;

import com.codahale.metrics.annotation.Timed;
import org.ming.humanresource.base.impl.BaseServiceImpl;
import org.ming.humanresource.common.annotation.CacheData;
import org.ming.humanresource.common.annotation.OperationLogAnnotation;
import org.ming.humanresource.hrmanager.dao.AccountInfoDao;
import org.ming.humanresource.hrmanager.model.AccountInfo;
import org.ming.humanresource.hrmanager.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 账号信息Service实现
 * @author acer
 * @create 2017-12-11 11:02
 */
@Service(value = "accountInfoService")
public class AccountInfoServiceImpl extends BaseServiceImpl<AccountInfo> implements AccountInfoService {
    @Autowired
    private AccountInfoDao accountInfoDao;
    @Resource
    public void setAccountInfoDao(AccountInfoDao accountInfoDao){
        setBaseDao(accountInfoDao);
    }

    /**
     * 根据账号密码信息查找账户
     * @param account
     * @param password
     * @return
     */
    @Override
    public AccountInfo findByAccountAndPwd(String account, String password) {
        return accountInfoDao.findByAccountAndPwd(account,password);
    }

    /**
     * 根据账号信息查找用户信息
     * @param account
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    @CacheData
    @OperationLogAnnotation(operatorType=1,operateId = "#account")
//    @Timed
    public AccountInfo findByAccount(String account) {
        System.out.println("当前线程信息："+Thread.currentThread().toString());
        return accountInfoDao.findByAccount(account);
    }
}
