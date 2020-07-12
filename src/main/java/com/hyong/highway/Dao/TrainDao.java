package com.hyong.highway.Dao;

import com.hyong.highway.Utils.NullData;
import com.hyong.highway.domain.IdAndTrainId;
import com.hyong.highway.domain.train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrainDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 用来查找所有的train的信息，返回一个用list和train类型承载的数据
     * 不需要输入参数
     * @return trains --> List 类型， 泛型为 train， 装载着所有的train的信息。
     */
    public List<train> findAll(){
        String sql = "select * from train";
        List<train> trains = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(train.class));
        return trains;
    }

    /**
     * 通过TrainId查找对应在表里对应的所有信息
     * @param TrainId -> String类型， 传入一个TrainId，例如 "C1001"
     * @return train -> List<train> 装载着所有的车次信息
     */
    public List<train> findTrainForTrainId(String TrainId){
        NullData.IsStringNull(TrainId);
        String sql = "select * from train where TrainId = ?";
        Object[] args = new Object[1];
        args[0] = TrainId;
        List<train> trains = jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<>(train.class));
        return trains;
    }

    /**
     * 该方法可以通过TrainId返回所有和TrainId相同的Id值
     * @param TrainId 传入一个TrainId值，类似"C1001"
     * @return 返回一个List，里面用IdAndTrainId装载，一个Id对应一个TrainId。不过一个TrainId可能对应着多个Id。
     */
    public List<IdAndTrainId> findIdForTrainId(String TrainId){
        NullData.IsStringNull(TrainId);
        String sql = "select * from IdAndTrainId where TrainId = ?";
        Object[] args = new Object[1];
        args[0] = TrainId;
        List<IdAndTrainId> idAndTrainIds = jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<>(IdAndTrainId.class));
        return idAndTrainIds;
    }

    /**
     * 该方法通过输入两个实际站点的名字，一个是起点一个是终点，返回所有可行的车次
     * @param StartStation String类型，是站点的实际名字，例如"北京南"
     * @param EndStation String类型，是站点的实际名字，例如"阳春"
     * @return 返回一个List，承载着所有可能的车次的所有信息
     */
    public List<train> findRoute(String StartStation, String EndStation){
        NullData.IsStringNull(StartStation);NullData.IsStringNull(EndStation);
        String sql = "exec findRoute ?, ?";
        Object[] args = new Object[2];
        args[0] = StartStation; args[1] = EndStation;
        List<train> trains = jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<>(train.class));
        return trains;
    }
}
