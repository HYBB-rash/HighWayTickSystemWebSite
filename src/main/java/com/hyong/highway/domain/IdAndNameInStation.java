package com.hyong.highway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 承载Station的ID和Name
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IdAndNameInStation {

    private Integer id;
    private String name;
}
