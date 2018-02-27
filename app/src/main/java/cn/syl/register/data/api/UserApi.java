package cn.syl.register.data.api;

/**
 * @author: syl  Date: 2018/2/26  Email:nerosyl@live.com
 */

import cn.syl.base.data.protocol.BaseResponse;
import cn.syl.register.data.protocol.RegisterResponse;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * @author: syl  Date: 2018/2/25  Email:nerosyl@live.com
 */
public interface UserApi {
    @POST("userCenter/register")
    Observable<BaseResponse<String>> register(@Body RegisterResponse req);
}