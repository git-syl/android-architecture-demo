package cn.syl.register.repository;

import cn.syl.base.data.net.RetrofitFactory;
import cn.syl.base.data.protocol.BaseResponse;
import cn.syl.register.data.api.UserApi;
import cn.syl.register.data.protocol.RegisterResponse;
import rx.Observable;

/**
 * @author: syl  Date: 2018/2/26  Email:nerosyl@live.com
 */
public class UserRepository {
  public  Observable<BaseResponse<String>> register(String mobile, String pwd, String verifyCode){
       return   RetrofitFactory.getSingleton().create(UserApi.class)
                 .register(new RegisterResponse(mobile,pwd,verifyCode));
    }
}
