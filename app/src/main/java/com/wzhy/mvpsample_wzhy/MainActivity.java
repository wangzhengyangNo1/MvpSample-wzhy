package com.wzhy.mvpsample_wzhy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.widget.Toast;

import com.wzhy.mvpsample_wzhy.presenter.UserPresenter;
import com.wzhy.mvpsample_wzhy.view.IUserView;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IUserView{

   /*绑定控件*/
    @BindView(R.id.edt_id)
    AppCompatEditText mEdtId;

    @BindView(R.id.edt_first_name)
    AppCompatEditText mEdtFirstName;

    @BindView(R.id.edt_last_name)
    AppCompatEditText mEdtLastName;

    private Unbinder mUnBinder;
    private UserPresenter mUserPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ButterKnife绑定当前界面
        mUnBinder = ButterKnife.bind(this);
        mUserPresenter = new UserPresenter(this);
    }

    @Override
    protected void onDestroy() {
        //ButterKnife解除与当前界面的绑定
        mUnBinder.unbind();
        super.onDestroy();
    }

    /**
     * 按钮点击监听
     * @param pBtn
     */
    @OnClick({R.id.btn_save, R.id.btn_load})
    public void onBtnClick(AppCompatButton pBtn){
        switch (pBtn.getId()){
            case R.id.btn_save:
                showTip("save");
                mUserPresenter.saveUser(getId(),getFristName(), getLastName());
                break;
            case R.id.btn_load:
                showTip("load");
                mUserPresenter.loadUser(getId());
                break;
        }
    }

    @Override
    public int getId() {
        return Integer.valueOf(mEdtId.getText().toString());
    }

    @Override
    public String getFristName() {
        return mEdtFirstName.getText().toString();
    }

    @Override
    public String getLastName() {
        return mEdtLastName.getText().toString();
    }

    @Override
    public void setFirstName(String pFirstName) {
        mEdtFirstName.setText(pFirstName);
    }

    @Override
    public void setLastName(String pLastName) {
        mEdtLastName.setText(pLastName);
    }

    /**
     * 吐司信息
     * @param pTip 需要吐司的信息
     */
    public void showTip(String pTip){
        if (TextUtils.isEmpty(pTip)) return;
        Toast.makeText(getApplicationContext(),pTip, Toast.LENGTH_SHORT).show();
    }
}
