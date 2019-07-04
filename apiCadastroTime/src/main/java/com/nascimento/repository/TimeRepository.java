package com.nascimento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nascimento.domain.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Integer> {
	
}
