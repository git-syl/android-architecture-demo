package cn.syl.usercenter.injection.module;

import cn.syl.usercenter.service.UserService;
import cn.syl.usercenter.service.impl.UserServiceImpl;
import dagger.Module;
import dagger.Provides;

/**
 * @author: syl  Date: 2018/3/1  Email:nerosyl@live.com
 */
@Module
public class UserModule {

    @Provides
    UserService providesUserService(){
        return new UserServiceImpl();
    }

//    @Provides
//    UserService providesUserService(UserServiceImpl userServiceImpl){
//        return userServiceImpl;
//    }
}
