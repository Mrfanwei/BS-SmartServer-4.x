package com.smartlife.model;

/**
 * Created by Administrator on 2017/6/8.
 */
public class MusicInfoModel {
    private Integer id;
    private String phone;
    private String parentid;
    private String filepath;
    private String albumid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getParentId() {
        return parentid;
    }
    public void setParentId(String parentid) {
        this.parentid = parentid;
    }

    public String getFilePath() {
        return filepath;
    }
    public void setFilePath(String filepath) {
        this.filepath = filepath;
    }

    public String getAlbumId() {
        return albumid;
    }
    public void setAlbumId(String albumid) {
        this.albumid = albumid;
    }
}
