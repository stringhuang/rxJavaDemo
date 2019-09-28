package com.zg.observerPattern.impl;

import com.zg.observerPattern.inter.AbstractObservable;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ObservableImplA extends AbstractObservable {

    public void doSomething() {
        log.info("ObservableImplA is doing something");
        super.notifyObserver();
    }
}
