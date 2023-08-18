package com.example.polls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.polls.model.Imagedata;


@Repository
public interface ImageDataRepository extends JpaRepository<Imagedata, Long> {

}
