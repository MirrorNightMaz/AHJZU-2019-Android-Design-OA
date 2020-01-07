package com.xleone.server_oa.bean;


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

    private admin userEntity;

    public admin getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(admin userEntity) {
        this.userEntity = userEntity;
    }
}
