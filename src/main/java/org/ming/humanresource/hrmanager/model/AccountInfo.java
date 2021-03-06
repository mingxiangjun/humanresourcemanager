package org.ming.humanresource.hrmanager.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * AccountInfo.java
 * @author MingXiangjun
 * @create 2017/12/11-11:29
 */
@Entity
@Table(name = "account_")
public class AccountInfo implements Serializable{
    //主键id
    @Id
    @Column(name = "uuid")
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator",strategy = "uuid")
    private String uuid;
    //人员账号
    @Column(name = "account")
    private String account;
    //账号密码
    @Column(name = "password")
    private String password;
    //安全邮箱
    @Column(name = "email")
    private String email;
    //安全问题
    @Column(name = "securityQues")
    private String securityQues;
    //安全问题答案
    @Column(name = "securityAns")
    private String securityAns;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecurityQues() {
        return securityQues;
    }

    public void setSecurityQues(String securityQues) {
        this.securityQues = securityQues;
    }

    public String getSecurityAns() {
        return securityAns;
    }

    public void setSecurityAns(String securityAns) {
        this.securityAns = securityAns;
    }
}
