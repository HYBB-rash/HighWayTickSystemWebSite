package com.hyong.highway.Dao;

import com.hyong.highway.Utils.NullData;
import com.hyong.highway.domain.IdAndNameInStation;
import com.hyong.highway.domain.station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StationDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 用于查找station表中所有的站点信息，会返回一个带有全部站点信息的list
     * @return stations List类型，用station类存储站点信息
     */
    public List<station> findAll(){
        String sql = "select * from station";
        List<station> stations = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(station.class));
        return stations;
    }

    /**
     * 利用站点名字找到对应的站点的所有信息。需要输入一个 string 类型的参数代表站点的名字。
     * @param name String 代表站点的信息
     * @return station --> Map 接口创建的 Hash Map实例， 用站点名字作为key，站点的id所谓value
     */
    public List<station> findStationForName(String name){
        NullData.IsStringNull(name);
        String sql = "select * from station where name = ?";
        Object[] args = new Object[1];
        args[0] = name;
        List<station> stations = jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<>(station.class));
        return stations;
    }

    /**
     * 该方法可以使用实际站点名返回站点ID信息
     * @param name String类型的站点实际名字，类似于"北京南"
     * @return 返回唯一一个实际名字对应的(id, name)键值对信息，如果发现数据库出现一个相同的站点，会抛出一个异常提示
     */
    public IdAndNameInStation findStationIdForName(String name){
        NullData.IsStringNull(name);
        String sql = "select * from IdAndNameInStation where name = ?";
        Object[] args = new Object[1];
        args[0] = name;
        List<IdAndNameInStation> idAndNameInStations =
                jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<>(IdAndNameInStation.class));
        if (idAndNameInStations.size() > 1) throw new IndexOutOfBoundsException("数据库存在两个同名站点！！");
        return idAndNameInStations.get(0);
    }

}
