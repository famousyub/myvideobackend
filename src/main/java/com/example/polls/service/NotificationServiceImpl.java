package com.example.polls.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.polls.model.Notification;
import com.example.polls.model.User;
import com.example.polls.model.Video;
import com.example.polls.repository.NotificationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service ("notificationService")
public class NotificationServiceImpl implements NotificationService
{
        private final NotificationRepository notificationRepository;

        @Autowired
        public NotificationServiceImpl ( NotificationRepository notificationRepository )
        {
                this.notificationRepository = notificationRepository;
        }

        @Override
        public List<Notification> findByUser ()
        {
                User user;

                if ( SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User )
                {
                        user = ( User ) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                        if ( user != null )
                                return notificationRepository.findAll();

                }
                return null;
        }

        @Override
        public boolean create ( Video poll )
        {
               /* Notification notification = Notification.builder()
                        .createdAt( LocalDateTime.now() )
                        .message( "Someone voted in your poll" )
                        .poll( poll )
                        .read( false )
                        .build();
                notificationRepository.save( notification );
                return true;*/
        	return true;
        }

        @Override
        public boolean update ()
        {
                return false;
        }

        @Override
        public List<Notification> readByUser ()
        {
                User user;

                if ( SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User )
                {
                        user = ( User ) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                        return notificationRepository.findAll(  )
                                .stream()
                                .map( e -> {
                                        e.setRead( true );
                                        return notificationRepository.save( e );
                                } ).collect( Collectors.toList() );
                }
                return null;
        }
}
