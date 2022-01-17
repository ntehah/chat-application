package com.chatapplication.models;

import javax.persistence.*;

@Entity
public class MessageDetail {

    @Id
    @GeneratedValue
    private long id;
    private long duration; // for voice message
    private long size; // in bytes
    @Lob
    private String thumbnail; // base64 thumbnail for image messages
    @Column(unique=true)
    private String pathName; // path to image or audio file

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }
}
