package com.example.ajrplatform.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface TrafficFlowMapper {
    Double sumByMap(Map map)
}
