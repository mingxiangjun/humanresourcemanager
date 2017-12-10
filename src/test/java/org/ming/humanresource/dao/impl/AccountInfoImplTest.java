package org.ming.humanresource.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ming.humanresource.dao.AccountInfoDao;
import org.ming.humanresource.model.AccountInfo;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-*.xml")
public class AccountInfoImplTest {
    @Resource
    private AccountInfoDao accountInfoDao;
    private int ThreadNum = 200;
    private CountDownLatch cdl = new CountDownLatch(ThreadNum);

    @Test
    public void saveAccount(){
        for (int i = 0; i < 100; i++) {
            AccountInfo currentAccount = new AccountInfo();
            currentAccount.setAccount("userName"+i);
            currentAccount.setPassword("password");
            currentAccount.setEmail("921962"+i+"@qq.com");
            accountInfoDao.save(currentAccount);
        }
    }

//    @Test
//    public void findByAccount() throws Exception {
//    }
//
//    @Test
//    public void findByAccountAndPwd() throws Exception {
//    }

    private class AccountReques implements Runnable{
        @Override
        public void run() {
            try {
                cdl.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}