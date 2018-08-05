package com.soulee.assignmentproject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asoule.assignmentproject.dtos.MovieDto;
import com.asoule.assignmentproject.repository.MovieRepository;
import com.soulee.assignmentproject.entity.Movie;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;

	public List<MovieDto>list(){
		return movieRepository.findAll().stream().map(m -> new MovieDto(m.getId(), m.getName())).collect(Collectors.toList());
	}
	
	public void add(MovieDto movie){
		Movie m = new Movie();
		movie.setName(movie.getName());
		movieRepository.save(m);
	}
}
