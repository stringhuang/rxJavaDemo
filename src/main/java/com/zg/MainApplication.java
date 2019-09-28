package com.zg;

import com.zg.observerPattern.impl.ObservableImplA;
import com.zg.observerPattern.impl.ObserverImplA;
import com.zg.observerPattern.impl.ObserverImplB;
import com.zg.observerPattern.inter.IObserver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);

//        IObserver observerImplA = new ObserverImplA();
//        IObserver observerImplB = new ObserverImplB();
//
//        IObservable iObservable = new ObservableImplA();
//
//        iObservable.attachObserver(observerImplA);
//        iObservable.attachObserver(observerImplB);
//
//        iObservable.notifyObserver();


        IObserver observerA = new ObserverImplA();
        IObserver observerb = new ObserverImplB();

        ObservableImplA observable = new ObservableImplA();

        observable.attachObserver(observerA);
        observable.attachObserver(observerb);
        observable.doSomething();

        observable.detachObserver(observerA);
        observable.doSomething();

    }
}