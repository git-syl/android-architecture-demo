package base.rx;

import rx.Subscriber;

/**
 * @author: syl  Date: 2018/2/25  Email:nerosyl@live.com
 */
public class BaseSubsriber<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {

    }
}
