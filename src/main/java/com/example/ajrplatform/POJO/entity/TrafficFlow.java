package com.example.ajrplatform.POJO.entity;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrafficFlow implements Serializable {
    private LocalDate date;
    private String roadType;
    private double flow;
}
