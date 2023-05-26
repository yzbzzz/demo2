package com.example.demo.domain;

import jakarta.persistence.*;


@Table(name= "user_log")
@Entity
public class User_log {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private long id;
        private long uuid;
        private String uname;
        private String type;
        private long createTime;

    public User_log(long uuid, String uname, String type, long createTime) {
        this.uuid = uuid;
        this.uname = uname;
        this.type = type;
        this.createTime = createTime;
    }

    public User_log() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUuid() {
        return uuid;
    }

    public void setUuid(long uuid) {
        this.uuid = uuid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}

