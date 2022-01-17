package com.chatapplication.models;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @ManyToOne
    private User creator;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> participants;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Message> messages;
    private RoomStatus status;
    private Timestamp createdAt;
    private Timestamp closedAt;
    private long version; //the last transferred message version for sync msgs
    @ManyToMany
    private List<User> mutedList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }
    public void addParticipant(User participant) {
        if (participants==null)
            participants= new ArrayList<>();
        participants.add(participant);
    }


    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(Timestamp closedAt) {
        this.closedAt = closedAt;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public List<User> getMutedList() {
        return mutedList;
    }

    public void setMutedList(List<User> mutedList) {
        this.mutedList = mutedList;
    }
}
