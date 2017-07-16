package com.smartlife.service;

import com.smartlife.model.MusicInfoModel;
import com.smartlife.model.RobotModel;

import java.util.List;

/**
 * Created by Administrator on 2017/6/9.
 */
public interface QintinService {
    int bindDevice(String bindphone, String binddevice);

    int bindMusicData(String phone, String parentid, String filepath, String albumid);

    int insertMusicData(MusicInfoModel musicinfo);

    List<MusicInfoModel> getMusicInfo(String phonename);

    RobotModel getRobotInfo(String phoneid);

    int insertRobotData(String phoneid, String address, String robotname,
                        String robot_serial, int robotid, boolean online);

    void deleteMusicInfo(String phonename, String filepath);
}
