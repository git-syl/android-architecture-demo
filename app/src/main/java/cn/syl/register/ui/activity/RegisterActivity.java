package cn.syl.register.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.syl.base.activity.BaseMvpActivity;
import cn.syl.register.presenter.view.IRegisterView;
import cn.syl.register.presenter.RegisterPresenter;

public class RegisterActivity extends BaseMvpActivity<RegisterPresenter> implements IRegisterView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //todo: dagger2
        mPresenter = new RegisterPresenter();
        mPresenter.mView = this;

      Button button = findViewById(R.id.button);

      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              mPresenter.register2("","","");
          }
      });
    }

    @Override
    public void onRegisterResult(Boolean result) {
        if (result)
        Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(RegisterActivity.this,"Error",Toast.LENGTH_SHORT).show();
    }
}
