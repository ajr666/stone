package com.example.ajrplatform.POJO.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrafficFlowYearVO {
    //年列表，逗号分割，例如：2020, 2021, 2022, 2023
    private String yearList;

    //城镇公路流量，逗号分割，单位万辆，例如：6980, 7721, 8989,7680
    private String freeWayFlow;

    //高速公路流量，逗号分割，单位万辆，例如：6980, 7721, 8989, 7680
    private String highWayFlow;

    //年环比，逗号分割，单位%，例如：3.44, 5.74, 2.35, 7.76
    private String compare; //环比
}

