package com.hyong.highway.controller;

import com.hyong.highway.domain.train;
import com.hyong.highway.service.FindRouteService;
import com.hyong.highway.service.StationDaoService;
import com.hyong.highway.service.TrainDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 测试用的controller，不必理会
 */
@RestController
public class DemoController {

    @Autowired
    private TrainDaoService trainDaoService;
    @Autowired
    private StationDaoService stationDaoService;
    @Autowired
    private FindRouteService findRouteService;

    @GetMapping("/demo/TrainDao")
    public String trainDaoDemo(){
//        List<train> all = trainDao.findAll();
        List<train> c1001 = trainDaoService.findTrainForName("C1001");
        return c1001.toString();
    }

    @GetMapping("/demo/StationDao")
    public String stationDaoDemo(){
//        List<station> stations = stationDao.findAll();
        Map<String, Integer> station = stationDaoService.findIdForName("北京");
        return station.toString();
    }

    @GetMapping("/find/route/{Start}/{End}")
    public String findRouteDemo(@PathVariable(name = "Start") String start, @PathVariable(name = "End") String end){
        List<train> trains = findRouteService.FindRouteByStartAndEnd(start, end);
        return trains.toString();
    }
}
