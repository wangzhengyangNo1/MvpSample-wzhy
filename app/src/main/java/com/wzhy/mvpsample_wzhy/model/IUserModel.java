package com.wzhy.mvpsample_wzhy.model;

import com.wzhy.mvpsample_wzhy.bean.UserBean;

/**
 * Created by wzhy on 2016/11/15.
 */

public interface IUserModel {
    void setId(int pId);

    void setFirstName(String pFirstName);

    void setLastName(String pLastName);

    UserBean load(int pId);
}
