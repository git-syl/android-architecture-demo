package base.rx.utils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author: syl  Date: 2018/2/25  Email:nerosyl@live.com
 */
public class ThreadUtils {

    public static Observable<Boolean> fromIoToMain(Observable<Boolean> register) {
      return register.subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread());
    }
}
