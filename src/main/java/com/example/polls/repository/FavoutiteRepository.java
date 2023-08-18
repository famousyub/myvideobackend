package com.example.polls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.polls.model.Favoutite;


@Repository
public interface FavoutiteRepository extends JpaRepository<Favoutite, Long> {

}
