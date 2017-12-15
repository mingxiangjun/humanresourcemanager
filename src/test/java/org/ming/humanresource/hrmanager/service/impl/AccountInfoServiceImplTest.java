package org.ming.humanresource.hrmanager.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ming.humanresource.common.annotation.OperationLogAnnotation;
import org.ming.humanresource.hrmanager.model.AccountInfo;
import org.ming.humanresource.hrmanager.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-*.xml")
public class AccountInfoServiceImplTest {

    @Autowired
    private AccountInfoService accountInfoService;

    @Test
    public void findByAccount() throws Exception {
        String account="userName10086";
        AccountInfo accountInfo = accountInfoService.findByAccount(account);
        if (accountInfo!=null){
            System.out.println("用户名为："+accountInfo.getAccount());
            System.out.println("用户安全邮箱为："+accountInfo.getEmail());
        }else{
            System.out.println("未查找到用户名为:【"+account+"】的用户信息");
        }
    }
/*    @Autowired
    private UserController userController;

    @Test
    public void findByAccount() throws Exception {
        userController.testAOP("zhangsan", "123456");
    }*/
}