package com.smartlife.service;

import com.smartlife.model.MusicInfoModel;
import com.smartlife.model.RobotModel;
import com.smartlife.repositories.MysqlControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Administrator on 2017/6/9.
 */
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)
@Service("QintinService")
public class QintinServiceImpl implements QintinService{
    private String TAG = "SmartService/NettyS";
    private RobotModel mRobotModel;

    @Autowired
    private MysqlControl mysqlControl;

    public QintinServiceImpl(){
        mRobotModel = new RobotModel();
    }

    @Override
    public int bindDevice(String bindphone,String binddevice){
        System.out.print(TAG+" bindphone="+bindphone+" binddevice="+binddevice+"\n");
        mysqlControl.bindDevice(bindphone, binddevice);
        return 0;
    }

    @Override
    public int bindMusicData(String phone,String parentid,String filepath,String albumid){
        mysqlControl.bindMusicData(phone, parentid,filepath,albumid);
        return 0;
    }

    @Override
    public int insertMusicData(MusicInfoModel musicinfo) {
        return 0;
    }

    @Transactional(readOnly=true)
    @Override
    public List<MusicInfoModel> getMusicInfo(String phonename){
        return mysqlControl.getMusicInfo(phonename);
    }

    @Transactional(readOnly=true)
    @Override
    public RobotModel getRobotInfo(String phoneid) {
        mRobotModel.setData(mysqlControl.getRobotInfo(phoneid));
        return mRobotModel;
    }

    @Override
    public int insertRobotData(String phoneid,String address, String robotname,
                        String robot_serial,int robotid,boolean online){
        mysqlControl.insertRobotData(phoneid, address,robotname,robot_serial,robotid,online);
        return 0;
    }

    @Override
    public void deleteMusicInfo(String phonename,String filepath){
        mysqlControl.deleteMusicInfo(phonename, filepath);
    }
}
