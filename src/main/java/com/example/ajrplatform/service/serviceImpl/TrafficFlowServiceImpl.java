package com.example.ajrplatform.service.serviceImpl;

import com.example.ajrplatform.POJO.VO.TrafficFlowYearVO;
import com.example.ajrplatform.mapper.TrafficFlowMapper;
import com.example.ajrplatform.service.TrafficFlowService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.util.StringUtil;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class TrafficFlowServiceImpl implements TrafficFlowService {
    @Autowired
    private TrafficFlowMapper trafficFlowMapper;

    public TrafficFlowYearVO getTrafficFlowYear(int beginYear, int endYear){//2022, 2024
        //数据库存储每天的车流量

        //"2022", "2023", "2024"
        List<String> yearList = new ArrayList<String>();
        for (int year = beginYear; year <= endYear; year++) {
            String yearStr = String.valueOf(year);
            yearList.add(yearStr);
        }

        List<LocalDate> dateList = new ArrayList<LocalDate>(); //2023-01-01 到 2024-12-31 的每一天

        LocalDate firstDayOfBeginYear = LocalDate.of(beginYear,1,1);
        LocalDate firstDayOfEndYear = LocalDate.of(endYear,1,1);
        while (!firstDayOfBeginYear.equals(firstDayOfEndYear)){
            firstDayOfBeginYear = firstDayOfBeginYear.plusYears(1);
            dateList.add(firstDayOfBeginYear);
        }

        List<String> freeFlowList = new ArrayList<String>(); //公路年交通流量
        List<String> highFlowList = new ArrayList<String>(); //告诉年交通流量
        for(LocalDate day : dateList){
            LocalDate beginDay = day;
            LocalDate endDay = beginDay.withMonth(12).withDayOfMonth(31);

            Map map = new HashMap();
            map.put("begin", beginDay);
            map.put("end", endDay);
            Double flow = trafficFlowMapper.sumByMap(map);
            flow = flow == null ? 0.0 : flow;
            freeFlowList.add(Double.toString(flow));
            highFlowList.add(Double.toString(flow-100)); //TO DO
        }

        return TrafficFlowYearVO.builder()
                .yearList(StringUtils.join(yearList, ','))
                .freeWayFlow(StringUtils.join(freeFlowList,','))
                .highWayFlow(StringUtils.join(highFlowList, ','))
                .build();
    }
}
