package org.ming.humanresource.hrmanager.controller;

import org.ming.humanresource.common.util.RegexUtil;
import org.ming.humanresource.hrmanager.model.AccountInfo;
import org.ming.humanresource.hrmanager.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.security.rsa.RSASignature;

/**
 * 人员账号信息Controller
 *
 * @author MingXiangjun
 * @create 2017-12-17 14:25
 */
@Controller
@RequestMapping(value = "/accountInfo")
public class AccountInfoController {
    @Autowired
    private AccountInfoService accountInfoService;
    @RequestMapping("/saveAccountInfo")
    public void saveAccountInfo(@RequestParam(value = "account")String account,
                                @RequestParam(value = "email")String email,
                                @RequestParam(value = "securityQues")String securityQues,
                                @RequestParam(value = "securityAns") String securityAns){
        boolean isAccount = RegexUtil.isAccount(account);
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAccount(account);
        accountInfo.setEmail(email);
        accountInfo.setSecurityAns(securityAns);
        accountInfo.setSecurityQues(securityQues);
        accountInfoService.save(accountInfo);
    }
}
