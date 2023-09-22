package com.example.polls.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.polls.model.Field;


@Repository
public interface FieldRepository  extends JpaRepository<Field, Long> {
}
