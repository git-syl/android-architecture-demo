package mvp.syl.cn.simplemvpdiy.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import base.activity.BaseMvpActivity;
import mvp.syl.cn.simplemvpdiy.R;
import mvp.syl.cn.simplemvpdiy.presenter.RegisterPresenter;
import mvp.syl.cn.simplemvpdiy.presenter.view.IRegisterView;

public class RegisterActivity extends BaseMvpActivity<RegisterPresenter> implements IRegisterView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //todo: dagger2
        mPresenter = new RegisterPresenter();
        mPresenter.mView = this;

      Button button = findViewById(R.id.button);

      button.setOnClickListener(view -> mPresenter.register("","",""));
    }

    @Override
    public void onRegisterResult(Boolean result) {
        if (result)
        Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
    }
}
