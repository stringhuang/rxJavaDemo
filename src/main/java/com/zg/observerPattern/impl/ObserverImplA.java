package com.zg.observerPattern.impl;

import com.zg.observerPattern.inter.IObserver;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ObserverImplA implements IObserver {
    @Override
    public void update() {
        log.info("ObserverImplA is updated");
    }
}
