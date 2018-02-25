package mvp.syl.cn.simplemvpdiy.service.impl;

import mvp.syl.cn.simplemvpdiy.service.UserService;
import rx.Observable;

/**
 * @author: syl  Date: 2018/2/25  Email:nerosyl@live.com
 */
public class UserServiceImpl implements UserService {
    @Override
    public Observable<Boolean> register(String mobile, String verifyCode, String pwd) {
        return Observable.just(true);
    }

}
