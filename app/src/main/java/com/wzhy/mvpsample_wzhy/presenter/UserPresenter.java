package com.wzhy.mvpsample_wzhy.presenter;

import com.wzhy.mvpsample_wzhy.bean.UserBean;
import com.wzhy.mvpsample_wzhy.model.IUserModel;
import com.wzhy.mvpsample_wzhy.model.UserModel;
import com.wzhy.mvpsample_wzhy.view.IUserView;

/**
 * Created by wzhy on 2016/11/15.
 */

public class UserPresenter {

    private IUserView mUserView;

    private IUserModel mUserModel;

    public UserPresenter(IUserView pView) {
        this.mUserView = pView;
        mUserModel = new UserModel();
    }

    public void saveUser(int pId, String pFirstName, String pLastName){
        mUserModel.setId(pId);
        mUserModel.setFirstName(pFirstName);
        mUserModel.setLastName(pLastName);
    }

    public void loadUser(int pId){
        UserBean _user = mUserModel.load(pId);
        mUserView.setFirstName(_user.getmFirstName());
        mUserView.setLastName(_user.getmLastName());
    }
}
