package org.ming.humanresource.hrmanager.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 用户信息实体类，与AccountInfo一一对应
 * @author MingXiangjun
 * @create 2017-12-11 14:26
 */
public class UserInfo implements Serializable{
    //主键ID
    @Id
    @Column(name = "uuid")
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator",strategy = "uuid")
    private String uuid;
    //对应账号ID
    @Column(name = "accountInfoId")
    private String accountInfoId;
    //真实姓名
    @Column(name = "realName",nullable = false)
    private String realName;
    //年龄
    @Column(name = "age")
    private int age;
    //性别
    @Column(name = "gender",nullable = false)
    private String gender;
    //出生日期
    @Column(name = "birthDay")
    private String birthDay;
    //居住地址
    @Column(name = "address")
    private String address;
    //组织id
    @Column(name = "organId")
    private String organId;
    //证件类型
    @Column(name = "certificateType")
    private int certificateType;
    //证件号码
    @Column(name = "certificateNum")
    private String certificateNum;
    //手机号
    @Column(name = "mobile")
    private String mobile;
    //座机号码
    @Column(name = "telephone")
    private String telephone;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAccountInfoId() {
        return accountInfoId;
    }

    public void setAccountInfoId(String accountInfoId) {
        this.accountInfoId = accountInfoId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public int getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(int certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateNum() {
        return certificateNum;
    }

    public void setCertificateNum(String certificateNum) {
        this.certificateNum = certificateNum;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
