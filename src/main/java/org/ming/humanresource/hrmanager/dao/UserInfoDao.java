package org.ming.humanresource.hrmanager.dao;

import org.ming.humanresource.base.BaseDao;
import org.ming.humanresource.hrmanager.model.UserInfo;

/**
 * 用户信息Dao
 * @author MingXiangjun
 * @create 2017-12-11 17:26
 **/
public interface UserInfoDao extends BaseDao{
    /**
     * 根据登录账号信息查找对应用户信息
     * @param accountInfoId
     * @return
     */
    public UserInfo findByAccountId(String accountInfoId);

}
