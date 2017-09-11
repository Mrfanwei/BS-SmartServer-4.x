package com.smartlife;

import com.smartlife.model.MusicInfoModel;
import com.smartlife.model.RobotModel;
import com.smartlife.service.QintinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by Administrator on 2017/6/10.
 */
@RestController
public class QintinController {
    private String TAG = "SmartService/NetC";

    @Autowired
    private QintinService qintinService;

    @RequestMapping("/hello")
    public String say(){
        System.out.print(TAG+" say\n");
        return "helloworldfwfwfw";
    }

    @RequestMapping(value="/bind",
            method= RequestMethod.POST,
            produces="application/json")
    public int bindDevice(@RequestParam("bindphone") String bindphone, @RequestParam("binddevice") String binddevice){
        System.out.print(TAG+" bindphone="+bindphone+" binddevice="+binddevice+"\n");
        qintinService.bindDevice(bindphone, binddevice);
        return 0;
    }

    @RequestMapping(value="/insertMusicData",
            method= RequestMethod.POST,
            produces="application/json")
    public int insertMusicData(@RequestParam("phone") String phone, @RequestParam("parentid") String parentid,
                               @RequestParam("filepath") String filepath, @RequestParam("albumid") String albumid){
        System.out.print(TAG+" insertMusicData phone="+phone+" parentid="+parentid+" filepath="+filepath+" albumid="+albumid+"\n");
        qintinService.bindMusicData(phone, parentid, filepath, albumid);
        return 0;
    }

    @RequestMapping(value="/getMusicInfo",
            method= RequestMethod.POST,
            produces="application/json")
    public List<MusicInfoModel> getMusicInfo(@RequestParam("phonename") String phonename){
        System.out.print(TAG+" getMusicInfo phonename="+phonename+"\n");
        return qintinService.getMusicInfo(phonename);
    }

    @RequestMapping(value="/unBindRobot",
            method= RequestMethod.POST,
            produces="application/json")
    public int unBindRobot(@RequestParam("phoneid") String phoneid,@RequestParam("robotname") String robotname) {
        System.out.print(TAG+" unBindRobot phoneid="+phoneid+" robotname"+robotname+"\n");
        qintinService.unBindRobot(phoneid,robotname);
        return 0;
    }

    @RequestMapping(value="/getRobotInfo",
            method= RequestMethod.POST,
            produces="application/json")
    public RobotModel getRobotInfo(@RequestParam("phoneid") String phoneid) {
        return qintinService.getRobotInfo(phoneid);
    }

    @RequestMapping(value="/insertRobotData",
            method= RequestMethod.POST,
            produces="application/json")
    public int bindRobot(@RequestParam("phoneid") String phoneid, @RequestParam("address") String address,
                               @RequestParam("robotname") String robotname, @RequestParam("robot_serial") String robot_serial){
        qintinService.insertRobotData(phoneid,address, robotname,robot_serial,111,true);
        return 0;
    }

    @RequestMapping(value="/deleteMusicInfo",
            method= RequestMethod.POST,
            produces="application/json")
    public int deleteMusicInfo(@RequestParam("phonename") String phonename, @RequestParam("filepath") String filepath){
        System.out.print(TAG+" deleteMusicInfo phonename="+phonename+" filepath"+filepath+"\n");
        qintinService.deleteMusicInfo(phonename, filepath);
        return 0;
    }
}
