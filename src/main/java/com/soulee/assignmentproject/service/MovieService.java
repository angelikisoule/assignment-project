package com.soulee.assignmentproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asoule.assignmentproject.repository.MovieRepository;
import com.soulee.assignmentproject.entity.Movie;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;

	public List<Movie>list(){
		return movieRepository.findAll();
	}
	
	public void add(Movie movie){
		movieRepository.save(movie);
	}
}
