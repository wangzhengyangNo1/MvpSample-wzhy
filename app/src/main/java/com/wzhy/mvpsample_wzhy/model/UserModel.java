package com.wzhy.mvpsample_wzhy.model;

import android.util.SparseArray;
import android.widget.ImageView;

import com.wzhy.mvpsample_wzhy.bean.UserBean;

/**
 * Created by ran on 2016/11/15.
 */

public class UserModel implements IUserModel {

    private String mFirstName;
    private String mLastName;
    private int mId;
    private SparseArray<UserBean> mUsers = new SparseArray<UserBean>();

    @Override
    public void setId(int pId) {
        this.mId = pId;
    }

    @Override
    public void setFirstName(String pFirstName) {
        mFirstName = pFirstName;
    }

    @Override
    public void setLastName(String pLastName) {
        mLastName = pLastName;
        UserBean _user = new UserBean(mFirstName, mLastName);
        mUsers.append(mId, _user);
    }

    @Override
    public UserBean load(int pId) {
        this.mId = pId;
        return mUsers.get(mId, new UserBean("not found", "not found"));
    }
}
