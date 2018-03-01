package cn.syl.usercenter.service.impl;

import cn.syl.base.data.protocol.BaseResponse;
import cn.syl.base.rx.BaseException;
import cn.syl.usercenter.repository.UserRepository;
import cn.syl.usercenter.service.UserService;
import rx.Observable;
import rx.functions.Func1;

/**
 * @author: syl  Date: 2018/2/25  Email:nerosyl@live.com
 */
public class UserServiceImpl implements UserService {
    @Override
    public Observable<Boolean> register(String mobile, String verifyCode, String pwd) {
       // return Observable.just(true);
        UserRepository repository = new UserRepository();
        return  repository.register(mobile, verifyCode, pwd)
                .flatMap(new Func1<BaseResponse<String>,Observable<Boolean>>(){
                    @Override
                    public Observable<Boolean> call(BaseResponse<String> data) {
                        if (data.getStatus()!=0){
                            return Observable.error(new BaseException(data.getStatus(),data.getMessage()));
                          //  return Observable.just(false);
                        }
                        //{"status":0} SUCCESS
                        return Observable.just(true);
                    }
                });
    }

}
