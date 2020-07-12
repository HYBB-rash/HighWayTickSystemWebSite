package com.hyong.highway.Utils;

public class NullData {

    public static void IsStringNull(String data){
        if (data == null) throw new NullPointerException("数据为空！");
    }
}
