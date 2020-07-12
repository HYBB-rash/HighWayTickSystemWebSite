package com.hyong.highway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 对应着SQL Server的pass表的内容，用来给BeanRowsMapper作容器.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class pass {

    private Integer id;
    private Integer TrainId;
    private Integer StationId;
    private Integer StationOrder;
    private String ArrivalTime;
    private String SetOffTime;
}
