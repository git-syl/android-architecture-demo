package cn.syl.register.service;

import rx.Observable;

/**
 * @author: syl  Date: 2018/2/25  Email:nerosyl@live.com
 */
public interface UserService {
    Observable<Boolean> register(String mobile,String verifyCode,String pwd);
}
