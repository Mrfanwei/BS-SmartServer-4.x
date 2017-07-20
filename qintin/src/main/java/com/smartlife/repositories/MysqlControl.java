package com.smartlife.repositories;

import com.smartlife.model.MusicInfoModel;
import com.smartlife.model.RobotModel;
import com.smartlife.provider.CollectionDynaSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static com.smartlife.common.NettyConstants.BINDROBOT_TABLE;
import static com.smartlife.common.NettyConstants.MUSICDATA_TABLE;
import static com.smartlife.common.NettyConstants.ROBOT_TABLE;

/**
 * Created by Administrator on 2017/6/8.
 */
public interface MysqlControl {

    @Insert("insert into "+BINDROBOT_TABLE+"(PHONE,ROBOT) values(#{bindphone},#{binddevice})")
    void bindDevice(@Param("bindphone") String bindphone, @Param("binddevice") String binddevice);

    @Insert("insert into "+MUSICDATA_TABLE+"(PHONE,PARENTID,FILEPATH,ALBUMID) values(#{phone},#{parentid},#{filepath},#{albumid})")
    void bindMusicData(@Param("phone") String phone, @Param("parentid") String parentid,
                       @Param("filepath") String filepath, @Param("albumid") String albumid);

    @SelectProvider(type=CollectionDynaSqlProvider.class,method="insertMusicData")
    void insertMusicData(MusicInfoModel musicinfo);

    @Select("select * from "+MUSICDATA_TABLE+" where phone = #{phonename}")
    List<MusicInfoModel> getMusicInfo(@Param("phonename") String phonename);

    @Delete(" delete from "+ROBOT_TABLE+" where phoneid = #{phoneid} and robotname = #{robotname}")
    void unBindRobot(@Param("phoneid") String phoneid,@Param("robotname") String robotname);

    @Select("select * from "+ROBOT_TABLE+" where phoneid = #{phoneid}")
    List<RobotModel.DataBean> getRobotInfo(@Param("phoneid") String phoneid);

    @Insert("insert into "+ROBOT_TABLE+"(PHONEID,ADDRESS,ROBOTNAME,ROBOT_SERIAL,ONLINE,ROBOTID) values(#{phoneid},#{address},#{robotname},#{robot_serial},#{robotid},#{online})")
    void insertRobotData(@Param("phoneid") String phoneid, @Param("address") String address,
                         @Param("robotname") String robotname, @Param("robot_serial") String robot_serial,
                         @Param("robotid") int robotid, @Param("online") boolean online);

    @Delete(" delete from "+MUSICDATA_TABLE+" where phone = #{phonename} and filepath = #{filepath}")
    void deleteMusicInfo(@Param("phonename") String phonename, @Param("filepath") String filepath);
}
