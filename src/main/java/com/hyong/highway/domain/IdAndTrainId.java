package com.hyong.highway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 承载Train中的Train和TrainId
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IdAndTrainId {

    private Integer id;
    private String TrainId;
}
