package base.presenter;

import base.presenter.view.IBaseView;

/**
 * @author: syl  Date: 2018/2/25  Email:nerosyl@live.com
 */
//t is IBaseView
public class BasePresenter<T extends IBaseView> {
   public T mView;
}
