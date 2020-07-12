package com.hyong.highway.controller;


import com.hyong.highway.service.StationDaoService;
import com.hyong.highway.service.TrainDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 该类用来上传爬回来的真实数据到SQL Server数据库中，请不要随便调用！！！
 * txt文件用的是utf-8编码格式
 */
@RestController
public class UploadController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private StationDaoService stationDaoService;
    @Autowired
    private TrainDaoService trainDaoService;

    /**
     * 上传Train的全部信息
     * @return 返回一个成功上传的message
     * @throws IOException 如果读取txt文件出现问题，就会抛出。所有的Train的信息都用txt存储。
     */
    @GetMapping("/upload/Train")
    public String uploadTrain() throws IOException {
        int cnt = 1;
        String sql = "insert into train values(?,?,?,?,?,?,?)";
        String filepath = "D:\\springboot\\highway\\src\\database\\train.txt";
        FileInputStream fileInputStream = new FileInputStream(filepath);
        InputStreamReader inputStreamReader = new InputStreamReader((fileInputStream));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String temp = "";
        while ((temp = bufferedReader.readLine()) != null){
            String[] split = temp.split("\t");

            int update = jdbcTemplate.update(sql, cnt++, split[0],
                    stationDaoService.findIdForName(split[1]).get(split[1]),
                    stationDaoService.findIdForName(split[2]).get(split[2]), split[3], split[4]
                    , Integer.valueOf(split[5]));
            System.out.println(update);
        }
        bufferedReader.close();
        return "upload-ok!" + temp;
    }

    /**
     * 上床Station的信息，源信息是用txt存储的
     * @return 返回一个成功上床的message
     * @throws IOException 如果读取txt文件出现问题，就会抛出异常。
     */
    @GetMapping("/upload/Station")
    public String uploadStation() throws IOException {
        String sql = "insert into station values (?, ?, ?, ?)";
        String filepath = "D:\\springboot\\highway\\src\\database\\station.txt";
        FileInputStream fileInputStream = new FileInputStream(filepath);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String temp = "";
        String test = "";
        int cnt = 0;
        while ((temp = bufferedReader.readLine()) != null){
            String[] split = temp.split("\t");
            int update = jdbcTemplate.update(sql, Integer.valueOf(split[0]), split[1],
                    Double.valueOf(split[2]), Double.valueOf(split[3]));
            test += cnt + update + " ";
        }
        return "update ok \n" + test;
    }

    /**
     * 上传pass的全部信息，具体存在pass的txt文件中.
     * @return 返回一个成功上床的message
     * @throws IOException 如果读取txt文件出现问题，就会抛出异常。
     */
    @GetMapping("/upload/Pass")
    public String uploadPass() throws IOException {
        String sql = "insert into pass values(?, ?, ?, ?, ?, ?)";
        String filepath = "D:\\springboot\\highway\\src\\database\\pass.txt";
        FileInputStream fileInputStream = new FileInputStream(filepath);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String temp = "";
        String cache = "";
        int cnt = 1;
        Map<String, Integer> TrainId = new HashMap<>();
        while ((temp = bufferedReader.readLine()) != null){
            String[] split = temp.split("\t");
            if(!split[0].equals("")) {
                cache = split[0];
                TrainId = trainDaoService.findIdForTrainIdAndDate(split[0],split[1], split[2]);
            }
            else split[0] = cache;
            if(split[5].equals("----")) split[5] = split[6];
            Map<String, Integer> StationId = stationDaoService.findIdForName(split[4]);
            cnt += jdbcTemplate.update(sql, cnt, TrainId.get(split[0]), Integer.valueOf(split[3]),
                    StationId.get(split[4]), split[5], split[6]);
            System.out.println(cnt);
        }
        return "upload ok!";
    }
}
