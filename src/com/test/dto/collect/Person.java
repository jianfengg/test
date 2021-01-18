package com.test.dto.collect;

/**
 * @Description:
 * @Copyright: Copyright (c) 2020  ALL RIGHTS RESERVED.
 * @Company: 宝能汽车销售有限公司
 * @Author: gjf
 * @CreateDate: 2021/1/6 14:45
 * @UpdateDate: 2021/1/6 14:45
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class Person {
    public Person(Integer id, String userCode, String userName, String sex) {
        this.id = id;
        this.userCode = userCode;
        this.userName = userName;
        this.sex = sex;
    }

    public Person() {
        super();
    }

    /**
     * 数据ID
     */
    private Integer id;

    /**
     * 用户编码
     */
    private String userCode;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户性别 1：男 2：女
     */
    private String sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
