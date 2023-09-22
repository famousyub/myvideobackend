package com.example.polls.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.polls.model.StadeZone;
import com.example.polls.model.Stadium;


@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long> {
	
	
	  List<Stadium> findByTitleContainingIgnoreCase(String keyword);

	  @Query("UPDATE Stadium t SET t.published = :published WHERE t.id = :id")
	  @Modifying
	  public void updatePublishedStatus(Long id, boolean published);

}
