package cn.syl.base.data.net;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cn.syl.base.common.BaseConstant;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author: syl  Date: 2018/2/25  Email:nerosyl@live.com
 */
public class RetrofitFactory {

    private volatile static RetrofitFactory instance;
    private RetrofitFactory (){}
    public static RetrofitFactory getSingleton() {
        if (instance == null) {
            synchronized (RetrofitFactory.class) {
                if (instance == null) {
                    instance = new RetrofitFactory();
                }
            }
        }
        return instance;
    }



    private static Retrofit retrofit;
    private static Interceptor interceptor;
    //private val interceptor2:Interceptor

    static   {

        interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request()
                        .newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .addHeader("charset", "utf-8")
                        .build();
                return chain.proceed(request);
            }
        };

        retrofit= new Retrofit.Builder()
                .baseUrl(BaseConstant.SERVER_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(intiClient())
                .build();



    }

    private static OkHttpClient intiClient() {
        return  new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(intiLogInterceptor())
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .build();
    }

    private static HttpLoggingInterceptor intiLogInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    public <T> T create(Class<T> service){
        return  retrofit.create(service);
    }


}