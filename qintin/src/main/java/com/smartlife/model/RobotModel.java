package com.smartlife.model;

import java.util.List;

/**
 * Created by Administrator on 2017/7/6.
 */

public class RobotModel {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean{

        private String phoneid;

        private String address;

        private int robotid;

        private String robotname;

        private boolean online;

        private String robot_serial;

        private int controller;

        public int getRid() {
            return robotid;
        }

        public void setRid(int rid) {
            this.robotid = rid;
        }

        public String getRname() {
            return robotname;
        }

        public void setRname(String rname) {
            this.robotname = rname;
        }

        public boolean isOnline() {
            return online;
        }

        public void setOnline(boolean online) {
            this.online = online;
        }

        public int getController() {
            return controller;
        }

        public void setController(int controller) {
            this.controller = controller;
        }

        public String getId() {
            return phoneid;
        }

        public void setId(String id) {
            this.phoneid = id;
        }

        public String getRobot_serial() {
            return robot_serial;
        }

        public void setRobot_serial(String robot_serial) {
            this.robot_serial = robot_serial;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
