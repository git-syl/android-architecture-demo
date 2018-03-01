package cn.syl.usercenter.injection.component;

import cn.syl.usercenter.injection.module.UserModule;
import cn.syl.usercenter.ui.activity.RegisterActivity;
import dagger.Component;

/**
 * @author: syl  Date: 2018/3/1  Email:nerosyl@live.com
 */
@Component(modules ={ UserModule.class})
public interface UserComponent {
    void inject(RegisterActivity activity);
}
