package org.ming.humanresource.hrmanager.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ming.humanresource.common.annotation.OperationLogAnnotation;
import org.ming.humanresource.hrmanager.model.AccountInfo;
import org.ming.humanresource.hrmanager.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-*.xml")
public class AccountInfoServiceImplTest {

    @Autowired
    private AccountInfoService accountInfoService;

    @Autowired
    private TaskExecutor taskExecutor;

    private String account = "userName";
    private static int THREADNUM = 200;
    private CountDownLatch cdl = new CountDownLatch(THREADNUM);

    @Test
    public void findByAccount() throws Exception {
        account="userName10086";
        AccountInfo accountInfo = accountInfoService.findByAccount(account);
        if (accountInfo!=null){
            System.out.println("用户名为："+accountInfo.getAccount());
            System.out.println("用户安全邮箱为："+accountInfo.getEmail());
        }else{
            System.out.println("未查找到用户名为:【"+account+"】的用户信息");
        }
    }

    @Test
    public void findByAccountMulti(){
        for (int i=0;i<THREADNUM;i++) {
            String tmpAccount = account+i;
            System.out.println(account);
            taskExecutor.execute(new QueryRequest(tmpAccount));
//            new Thread(new QueryRequest(tmpAccount)).start();
//            cdl.countDown();
//            System.out.println("==================================="+cdl.toString());
        }

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *  模拟多线程查询
     */
    private class QueryRequest implements Runnable{
        private String account_="";
        public QueryRequest(String account) {
            account_=account;
        }


        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
//            try {
//                cdl.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            AccountInfo accountInfo = accountInfoService.findByAccount(account_);
            if (accountInfo!=null){
                System.out.println("用户名为："+accountInfo.getAccount());
                System.out.println("用户安全邮箱为："+accountInfo.getEmail());
            }else{
                System.out.println("未查找到用户名为:【"+account_+"】的用户信息");
            }
        }
    }
}