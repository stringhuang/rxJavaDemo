package com.zg.observerPattern.inter;

import java.util.ArrayList;

public abstract class AbstractObservable {

    private ArrayList<IObserver> iObserverArrayList = new ArrayList<IObserver>();

    public void attachObserver(IObserver iObserver) {
        this.iObserverArrayList.add(iObserver);
    }

    public void notifyObserver() {
        this.iObserverArrayList.forEach(iObserver -> {
            iObserver.update();
        });
    }

    public void detachObserver(IObserver iObserver){
        this.iObserverArrayList.remove(iObserver);
    }

}
