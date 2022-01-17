package com.chatapplication.services;


import com.chatapplication.models.Room;
import com.chatapplication.models.User;
import com.chatapplication.payloads.RoomRequest;
import com.chatapplication.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;

@Service
public class RoomService {
    @Autowired
    JwtService jwtService;
    @Autowired
    RoomRepository roomRepository;

    public ResponseEntity<Object> createRoom(HttpServletRequest request, RoomRequest roomRequest) {
        User user = jwtService.parseToken(request);
        if (user == null)
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        Room room = new Room();
        room.setTitle(roomRequest.getTitle());
        room.setParticipants(roomRequest.getParticipants());
        room.setCreator(user);
        room.setVersion(0);
        room.setMessages(new ArrayList<>());
        room.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        File roomFile = new File(System.getProperty("user.home") + "/rooms/" + room.getId());
        if (!roomFile.exists()) {
            if (roomFile.mkdir()) {
                File audio = new File(System.getProperty("user.home") + "/rooms/" + room.getId() + "/audio");
                File image = new File(System.getProperty("user.home") + "/rooms/" + room.getId() + "/image");
                audio.mkdir();
                image.mkdir();
            }
        }
        Room roomAfterSaving = roomRepository.save(room);
        return new ResponseEntity<>(roomAfterSaving, HttpStatus.OK);
    }


}
