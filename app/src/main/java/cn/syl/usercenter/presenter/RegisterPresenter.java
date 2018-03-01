package cn.syl.usercenter.presenter;

import javax.inject.Inject;

import cn.syl.base.presenter.BasePresenter;
import cn.syl.base.rx.BaseSubsriber;
import cn.syl.usercenter.presenter.view.IRegisterView;
import cn.syl.usercenter.service.UserService;
import cn.syl.usercenter.service.impl.UserServiceImpl;
import cn.syl.base.rx.utils.ThreadUtils;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author: syl  Date: 2018/2/25  Email:nerosyl@live.com
 */
public class RegisterPresenter extends BasePresenter<IRegisterView> {

    @Inject
    UserService userService ;

    @Inject
    public RegisterPresenter() {
    }

    //1重构前:  Before the refactoring
    public void register(String mobole, String vertifyCode,String password){

        UserService userService = new UserServiceImpl();

        userService.register(mobole,vertifyCode,password)
                .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        mView.onRegisterResult(true);
                    }
                });



    }

 //2 use BaseSubsriber
    public void register1(String mobole, String vertifyCode,String password){

        UserService userService = new UserServiceImpl();
        userService.register(mobole,vertifyCode,password)
                .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new BaseSubsriber<Boolean>(){
                     @Override
                     public void onNext(Boolean aBoolean) {
                         mView.onRegisterResult(true);
                     }
                 });

    }

    //use
    public void register2(String mobole, String vertifyCode,String password){

     //   UserService userService = new UserServiceImpl();

        ThreadUtils.fromIoToMain(userService.register(mobole,vertifyCode,password))
                .subscribe(new BaseSubsriber<Boolean>(){
                    @Override
                    public void onNext(Boolean aBoolean) {
                        mView.onRegisterResult(true);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onRegisterResult(false);
                    }
                });


    }
}
