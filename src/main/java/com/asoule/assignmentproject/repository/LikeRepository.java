package com.asoule.assignmentproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soulee.assignmentproject.entity.Like;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
	
	  
}