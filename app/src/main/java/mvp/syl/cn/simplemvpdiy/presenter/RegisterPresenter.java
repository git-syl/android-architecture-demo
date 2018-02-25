package mvp.syl.cn.simplemvpdiy.presenter;

import base.presenter.BasePresenter;
import base.rx.BaseSubsriber;
import mvp.syl.cn.simplemvpdiy.presenter.view.IRegisterView;
import mvp.syl.cn.simplemvpdiy.service.UserService;
import mvp.syl.cn.simplemvpdiy.service.impl.UserServiceImpl;
import base.rx.utils.ThreadUtils;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author: syl  Date: 2018/2/25  Email:nerosyl@live.com
 */
public class RegisterPresenter extends BasePresenter<IRegisterView> {

    //重新构前:
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

    public void register2(String mobole, String vertifyCode,String password){

        UserService userService = new UserServiceImpl();

        ThreadUtils.fromIoToMain(userService.register(mobole,vertifyCode,password))
                .subscribe(new BaseSubsriber<Boolean>(){
                    @Override
                    public void onNext(Boolean aBoolean) {
                        super.onNext(aBoolean);
                    }
                });


    }
}
