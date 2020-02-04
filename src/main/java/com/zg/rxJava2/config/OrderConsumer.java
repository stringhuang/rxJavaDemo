package com.zg.rxJava2.config;

import com.zg.rxJava2.dto.OrderData;
import com.zg.rxJava2.observer.OrderObserver;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class OrderConsumer {

    @Autowired
    private OrderObserver orderObserver;

    @PostConstruct
    public void post_init() {

        List<OrderData> orderDataList = new ArrayList<>();
        orderDataList.add(OrderData.builder().orderNum("10001").price(34.31).build());
        orderDataList.add(OrderData.builder().orderNum("10002").price(34.32).build());
        orderDataList.add(OrderData.builder().orderNum("10003").price(34.33).build());
        orderDataList.add(OrderData.builder().orderNum("10004").price(34.34).build());
        orderDataList.add(OrderData.builder().orderNum("10005").price(34.35).build());
        orderDataList.add(OrderData.builder().orderNum("10006").price(34.36).build());
        orderDataList.add(OrderData.builder().orderNum("10007").price(34.37).build());
        orderDataList.add(OrderData.builder().orderNum("10008").price(34.38).build());
        orderDataList.add(OrderData.builder().orderNum("10009").price(34.39).build());

        for (OrderData orderData : orderDataList) {
//            Observable.just(orderData).subscribe(this.orderObserver);
            Observable.just(orderData).subscribeOn(Schedulers.newThread()).subscribe(this.orderObserver);
        }

    }
}
