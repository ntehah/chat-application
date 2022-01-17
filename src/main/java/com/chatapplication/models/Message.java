package com.chatapplication.models;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;
@Entity
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Room room;

    private MessageType type;
    @Lob
    private String body;
    @ManyToOne
    private User sender;
    @ManyToMany
    private List<User> viewers;
    @ManyToMany
    private List<User> receivers;
    private Timestamp createdAt;
    private boolean deleted;
    private boolean viewedByAll;
    private long version;

    @OneToOne
    private MessageDetail messageDetail;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public List<User> getViewers() {
        return viewers;
    }

    public void setViewers(List<User> viewers) {
        this.viewers = viewers;
    }

    public List<User> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<User> receivers) {
        this.receivers = receivers;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isViewedByAll() {
        return viewedByAll;
    }

    public void setViewedByAll(boolean viewedByAll) {
        this.viewedByAll = viewedByAll;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public MessageDetail getMessageDetail() {
        return messageDetail;
    }

    public void setMessageDetail(MessageDetail messageDetail) {
        this.messageDetail = messageDetail;
    }
}
