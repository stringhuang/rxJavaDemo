package com.zg.rxJava2.observer;

import com.zg.rxJava2.dto.OrderData;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class OrderObserver implements Observer<OrderData> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(OrderData value) {
        long sleepSeconds = new Double(Math.random() * 10000).longValue();
        try {
            Thread.sleep(sleepSeconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("{} sleep {} millis, consume {}", this.getClass().getSimpleName(), sleepSeconds, value);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
