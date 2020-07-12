package com.hyong.highway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 对应着SQL Server的train表的内容，用来给BeanRowsMapper作容器.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class train {

    private Integer id;
    private String TrainId;
    private String StartStation;
    private String EndStation;
    private String StartDate;
    private String EndDate;
    private String service;
}
