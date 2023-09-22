package com.example.polls.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.polls.model.ReservationTerrain;

import java.util.List;
import java.util.Optional;


@Repository
public interface ReservationTerrainRepository extends JpaRepository<ReservationTerrain, Long> {

    List<ReservationTerrain> findByTitleContainingIgnoreCase(String title);
    
    @Query(value = "select a from ReservationTerrain a where a.user.id=?1 ")
    List<ReservationTerrain> findterainreservecutomser(@Param("user_id") Long id);

}
