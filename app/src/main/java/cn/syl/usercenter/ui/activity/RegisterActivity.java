package cn.syl.usercenter.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.syl.base.activity.BaseMvpActivity;
import cn.syl.usercenter.injection.component.DaggerUserComponent;
import cn.syl.usercenter.injection.module.UserModule;
import cn.syl.usercenter.presenter.view.IRegisterView;
import cn.syl.usercenter.presenter.RegisterPresenter;

public class RegisterActivity extends BaseMvpActivity<RegisterPresenter> implements IRegisterView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // mPresenter = new RegisterPresenter();  // inject by dagger2
        // DaggerUserComponent.builder().build().inject(this);
        // DaggerUserComponent.create().inject(this);
        DaggerUserComponent.builder().userModule(new UserModule()).build().inject(this);

        mPresenter.mView = this;


        Button button = findViewById(R.id.button);
        button.setOnClickListener(view ->
                //todo:省略用户名密码.....
                mPresenter.register2("", "", ""));
    }

    @Override
    public void onRegisterResult(Boolean result) {
        if (result)
            Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(RegisterActivity.this, "Error", Toast.LENGTH_SHORT).show();
    }
}
