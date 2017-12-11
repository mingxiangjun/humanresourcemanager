package org.ming.humanresource.hrmanager.dao.impl;

import org.ming.humanresource.base.impl.BaseDaoImpl;
import org.ming.humanresource.hrmanager.dao.AccountInfoDao;
import org.ming.humanresource.hrmanager.model.AccountInfo;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 账号信息Dao实现
 * @author acer
 * @create 2017-12-10 13:58
 */
@Repository(value = "accountInfoDao")
public class AccountInfoDaoImpl extends BaseDaoImpl<AccountInfo> implements AccountInfoDao {
    private final static Logger logger= LoggerFactory.getLogger(AccountInfoDaoImpl.class);
    @Override
    public AccountInfo findByAccount(String account) {
        List<AccountInfo> list = findListByQuery("from AccountInfo where account=?",account);
        if (list==null){
            logger.info("未查找到账号为：【"+account+"】的账号信息");
            return new AccountInfo();
        }
        if (list.size() > 1){
            logger.info("账号信息异常，出现多个相同账号：【"+account+"】;取值第一个账号！");
        }
        return list.get(0);
    }

    @Override
    public AccountInfo findByAccountAndPwd(String account, String password) {
        List<AccountInfo> list = findListByQuery("from AccountInfo where account=? and password=?" ,account,password);
        if (list==null){
            logger.info("未查找到账号为：【"+account+"】的账号信息");
            return new AccountInfo();
        }
        if (list.size() > 1){
            logger.info("账号信息异常，出现多个相同账号：【"+account+"】;");
            return new AccountInfo();
        }
        return list.get(0);
    }

    @Override
    public AccountInfo findBySecurityQuesAns(String quesId, String ansId) {
        return null;
    }
}
