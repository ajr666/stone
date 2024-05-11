package com.example.ajrplatform.controller;

import com.example.ajrplatform.POJO.VO.TrafficFlowYearVO;
import com.example.ajrplatform.common.Result;
import com.example.ajrplatform.service.TrafficFlowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/traffic-flow")
@Slf4j
public class TrafficFlowController {

    @Autowired
    private TrafficFlowService trafficFlowService;

    @GetMapping("/year")
    public Result<TrafficFlowYearVO> getTrafficFlowYear(@RequestParam(name = "beginYear") int beginYear,
                                                        @RequestParam(name = "endYear") int endYear) {
        return Result.success(trafficFlowService.getTrafficFlowYear(beginYear, endYear));
    }
}
