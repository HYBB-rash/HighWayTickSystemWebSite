package com.hyong.highway.service;

import com.hyong.highway.Dao.TrainDao;
import com.hyong.highway.domain.train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findRouteService")
public class FindRouteService {

    @Autowired
    private TrainDao trainDao;

    /**
     * 该方法是使用起始车站名和目的车站名来查询所有可能可以乘搭的列车的所有信息
     * @param StartStation 乘客的起点站，String类型，直接使用，例如:"北京南"
     * @param EndStation 乘客的终点站，String类型，直接类型，例如:"阳春"
     * @return 返回一个List，里面装载着所有途径目的站点的车次
     */
    public List<train> FindRouteByStartAndEnd(String StartStation, String EndStation){
        return trainDao.findRoute(StartStation, EndStation);
    }

}
