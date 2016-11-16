package com.wzhy.mvpsample_wzhy.bean;

/**
 * Created by wzhy on 2016/11/15.
 */

public class UserBean {
    private String mFirstName;
    private String mLastName;

    public UserBean(String mFirstName, String mLastName) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
    }

    public String getmFirstName(){
        return mFirstName;
    }

    public String getmLastName(){
        return mLastName;
    }
}
