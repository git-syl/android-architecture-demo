package cn.syl.base.activity;

import javax.inject.Inject;

import cn.syl.base.presenter.BasePresenter;
import cn.syl.base.presenter.view.IBaseView;

/**
 * @author: syl  Date: 2018/2/25  Email:nerosyl@live.com
 */
// t is BasePresenter
public class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements IBaseView {
    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError() {
    }

    @Inject
    protected T mPresenter;
}
