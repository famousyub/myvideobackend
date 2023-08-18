package com.example.polls.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.polls.model.Notification;
import com.example.polls.model.User;
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
	//List<Notification> findAllCreatorOrder ( User user );

}
