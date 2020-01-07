package com.example.oa10.Utils;

import com.example.oa10.entity.ResultBean;

public class LoginFlag {
    private static LoginFlag loginFlag = null;
    private ResultBean resultBean = null;

    public static LoginFlag getInstance(){

        if(loginFlag==null){
            loginFlag = new LoginFlag();
        }
        return loginFlag;
    }

    public ResultBean getResultBean() {
        return resultBean;
    }

    public void setResultBean(ResultBean resultBean) {
        this.resultBean = resultBean;
    }
}
