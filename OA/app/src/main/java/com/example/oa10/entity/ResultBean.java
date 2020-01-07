package com.example.oa10.entity;


/**
 * 用于返回结果的JavaBean
 */

public class ResultBean {

    /**
     * 结果码:
     * 100--代表登陆操作返回结果码
     * 成功登陆--101
     * 登陆失败--102
     *
     *
     */
    private int resultCode;


    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    private User userEntity;

    public User getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(User userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "resultCode=" + resultCode +
                ", userEntity=" + userEntity +
                '}';
    }
}
