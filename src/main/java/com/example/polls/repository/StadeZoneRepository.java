package com.example.polls.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.polls.model.StadeZone;


@Repository
@Transactional
public interface StadeZoneRepository  extends JpaRepository<StadeZone, Long>{

	  List<StadeZone> findByTitleContainingIgnoreCase(String keyword);

	  @Query("UPDATE StadeZone t SET t.published = :published WHERE t.id = :id")
	  @Modifying
	  public void updatePublishedStatus(Long id, boolean published);
}
