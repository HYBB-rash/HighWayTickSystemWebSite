package com.hyong.highway.service;

import com.hyong.highway.Dao.TrainDao;
import com.hyong.highway.domain.train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * train 的 DAO 服务层
 */

@Service("trainService")
public class TrainDaoService {

    @Autowired
    private TrainDao trainDao;

    /**
     * 用于返回所有train在数据库中的数据
     * @return List类型，泛型为train，装载着全部train的数据
     */
    public List<train> findAll(){
        return trainDao.findAll();
    }

    /**
     * 该方法可以用TrainId找到对应的所有Train（注意，在数据库中，一个TrainId可能对应着两辆行程不同的列车）
     * @param TrainId 该参数是TrainID，车次的意思，类似“C1001”之类
     * @return 返回一个List，里面装载所有TrainId相同的train
     */
    public List<train> findTrainForName(String TrainId){
        return trainDao.findTrainForTrainId(TrainId);
    }

    /**
     * 该方法是先利用TrainId找到所有在数据库中的车次，再用出发时间和到达时间来唯一确定对应的列车，传出这辆的ID
     * @param TrainId 该参数是TrainID，车次的意思，类似“C1001”之类
     * @param StartDate 该参数是StartDate，车次的出发时间，类似“18:20”之类的
     * @param EndDate 该参数是EndDate，车次的到达时间，类似“18:30”之类的
     * @return 最后经过筛选处理，返回列车在数据库中的ID
     */
    public Map<String, Integer> findIdForTrainIdAndDate(String TrainId, String StartDate, String EndDate) {
        List<train> trains = trainDao.findTrainForTrainId(TrainId);
        Map<String, Integer> train = new HashMap<>();
        for (train Train : trains){
            if(Train.getStartDate().equals(StartDate) && Train.getEndDate().equals(EndDate))
                train.put(TrainId, Train.getId());
        }
        return train;
    }
}
