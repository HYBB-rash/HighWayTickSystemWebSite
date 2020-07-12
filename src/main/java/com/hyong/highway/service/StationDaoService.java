package com.hyong.highway.service;

import com.hyong.highway.Dao.StationDao;
import com.hyong.highway.domain.station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TrainDao 的service层
 */
@Service("stationService")
public class StationDaoService {

    @Autowired
    private StationDao stationDao;

    /**
     * 该方法可以返回所有Station在数据库中的所有信息
     * @return 返回一个List，利用station类装载，承载在数据库中所有的Station数据
     */
    public List<station> findAll() {
        List<station> stations = stationDao.findAll();
        return stations;
    }

    /**
     * 该方法使用一个站点的名字查找对应的ID值
     * @param name 一个String类型的数据，存储站点的名字，例如“北京”之类的
     * @return 一个Map存储（name，id）键值对，id是在数据中找到的id。
     * 如果数据库存在有同名站点，会抛出IndexOutOfBoundsException
     */
    public Map<String, Integer> findIdForName(String name) {
        List<station> stations = stationDao.findStationForName(name);
        if (stations.size() >= 2) throw new IndexOutOfBoundsException("相同名字的站点有两个或以上！");
        Map<String, Integer> station = new HashMap<>();
        station.put(name, stations.get(0).getId());
        return station;
    }
}
