package com.example.ajrplatform.service;

import com.example.ajrplatform.POJO.VO.TrafficFlowYearVO;

public interface TrafficFlowService {
    TrafficFlowYearVO getTrafficFlowYear(int beginYear, int endYear);
}
