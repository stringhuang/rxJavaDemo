package com.zg.rxJava2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderData {

    private String orderNum;
    private Double price;

    @Override
    public String toString() {
        return "OrderData{" +
                "orderNum='" + orderNum + '\'' +
                ", price=" + price +
                '}';
    }
}
