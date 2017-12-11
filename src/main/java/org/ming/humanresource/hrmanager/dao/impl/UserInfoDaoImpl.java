package org.ming.humanresource.hrmanager.dao.impl;

import org.ming.humanresource.base.impl.BaseDaoImpl;
import org.ming.humanresource.hrmanager.dao.UserInfoDao;
import org.ming.humanresource.hrmanager.model.UserInfo;

/**
 * UserInfoDaoImpl
 * @author MingXiangjun
 * @create 2017-12-11 17:35
 */
public class UserInfoDaoImpl extends BaseDaoImpl<UserInfo> implements UserInfoDao{
    /**
     * 根据登录账号信息查找对应用户信息
     * @param accountInfoId
     * @return
     */
    @Override
    public UserInfo findByAccountId(String accountInfoId) {
        return (UserInfo) findSingleByQuery("from UserInfo where accountInfoId=?",accountInfoId);
    }
}
