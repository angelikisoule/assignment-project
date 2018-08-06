package com.asoule.assignmentproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.soulee.assignmentproject.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	  @Query("SELECT m FROM Movie m where m.name like %:name%") 
	  public List<Movie> findByName(@Param("name") String name);
	  
}
