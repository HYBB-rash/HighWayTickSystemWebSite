package com.hyong.highway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 对应着SQL Server的station表的内容，用来给BeanRowsMapper作容器.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class station {

    private Integer id;
    private String name;
    private Double latitude;
    private Double Longitude;
}
