package com.zg.rxJava2OtherSample.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StatusDataDto {

    private String statusName;
    private Double statusValue;
}
