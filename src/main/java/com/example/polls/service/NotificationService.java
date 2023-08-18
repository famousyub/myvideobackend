package com.example.polls.service;

import java.util.List;

import com.example.polls.model.Notification;
import com.example.polls.model.Video;

public interface NotificationService
{
        List<Notification> findByUser ();

        boolean create (Video poll);

        boolean update ();

        List<Notification> readByUser();
}
