package com.hyong.highway.domain;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 承载Costumer的全部信息
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class costumer {

    private Integer Id;
    private String UserName;
    private String Password;
    private String UserId;
    private String RealName;
    private Boolean Sex;
}
