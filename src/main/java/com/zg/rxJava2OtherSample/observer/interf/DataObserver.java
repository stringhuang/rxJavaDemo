package com.zg.rxJava2OtherSample.observer.interf;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public interface DataObserver<T> {
    public void doSubscribe(Disposable d);

    public void doError(Throwable e);

    public void doComplete();

    public void doNext(T value);

    public void subscribe(Observable observable);
}
