package com.zg.rxJava2OtherSample.config;

import com.zg.rxJava2OtherSample.dto.StatusDataDto;
import com.zg.rxJava2OtherSample.observer.impl.AbstractStatusDataObserver;
import io.reactivex.Observable;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
@Log4j2
public class StatusConsumer {

    @Autowired
    private List<AbstractStatusDataObserver> statusDataObserverList;

    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            8,
            16,
            1000,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingDeque<Runnable>(),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );

    @PostConstruct
    public void post_init() {

        StatusDataDto statusDataDto1 = StatusDataDto.builder()
                .statusName("temperature").statusValue(23.03)
                .build();

        for (AbstractStatusDataObserver statusDataObserver : statusDataObserverList) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    statusDataObserver.subscribe(Observable.just(statusDataDto1));
                }
            });
        }
    }
}
