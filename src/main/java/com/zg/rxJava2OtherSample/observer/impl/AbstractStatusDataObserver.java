package com.zg.rxJava2OtherSample.observer.impl;

import com.zg.rxJava2OtherSample.dto.StatusDataDto;
import com.zg.rxJava2OtherSample.observer.interf.DataObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class AbstractStatusDataObserver implements DataObserver<StatusDataDto> {

    private final Observer observer;

    public AbstractStatusDataObserver() {
        this.observer = new Observer<StatusDataDto>() {
            @Override
            public void onSubscribe(Disposable d) {
                doSubscribe(d);
            }

            @Override
            public void onNext(StatusDataDto value) {
                doNext(value);
            }

            @Override
            public void onError(Throwable e) {
                doError(e);
            }

            @Override
            public void onComplete() {
                doComplete();
            }
        };
    }

    @Override
    public void subscribe(Observable observable) {
        observable.subscribe(this.observer);
    }


    @Override
    public void doError(Throwable e) {

    }

    @Override
    public void doComplete() {

    }

    @Override
    public void doSubscribe(Disposable disposable) {

    }
}
