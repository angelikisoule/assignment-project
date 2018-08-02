package com.asoule.assignmentproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soulee.assignmentproject.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
