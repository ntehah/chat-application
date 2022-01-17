package com.chatapplication.repository;

import com.chatapplication.models.MessageDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface MessageDetailRepository extends JpaRepository<MessageDetail,Long> {

}
