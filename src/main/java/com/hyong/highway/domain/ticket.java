package com.hyong.highway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ticket {

    private Integer TicketId;
    private Integer CostumerId;
    private String BootTime;
    private String TrainId;
    private Integer StartStation;
    private Integer EndStation;
    private Integer Car;
    private Integer CarRow;
    private Integer CarColumn;
    private Integer BuyStatue;
    private Integer BuyLocation;
    private Date BuyDate;
}
