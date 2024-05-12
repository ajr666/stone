package com.example.ajrplatform.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.Map;

@Mapper
public interface TrafficFlowMapper {
    Double sumYearTrafficFlow(@Param("begin") LocalDate beginDay, @Param("end") LocalDate endDay);
}
