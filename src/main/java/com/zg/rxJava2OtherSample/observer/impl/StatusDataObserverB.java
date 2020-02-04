package com.zg.rxJava2OtherSample.observer.impl;

import com.zg.rxJava2OtherSample.dto.StatusDataDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class StatusDataObserverB extends AbstractStatusDataObserver {

    @Override
    public void doNext(StatusDataDto value) {
        long sleepSeconds = new Double(Math.random() * 10000).longValue();
        try {
            Thread.sleep(sleepSeconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("{} sleep {} millis, consume {}", this.getClass().getSimpleName(), sleepSeconds, value);
    }
}
