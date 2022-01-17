package com.chatapplication.payloads;

import com.chatapplication.models.User;

import java.util.List;

public class RoomRequest {
    private String title;
    private List<User> participants;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }
}
