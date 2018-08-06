package com.asoule.assignmentproject.util;

import java.util.List;
import java.util.stream.Collectors;

import com.asoule.assignmentproject.dtos.MovieDto;
import com.soulee.assignmentproject.entity.Movie;

public class Converter {
	
	static public Movie toEntity(MovieDto movieDto) {
		if(movieDto == null) {
			return null;
		}
		return new Movie(movieDto.getId(), movieDto.getName());
	}
	
	static public MovieDto toDto(Movie movie) {
		if(movie == null) {
			return null;
		}
		return new MovieDto(movie.getId(), movie.getName());
	}
	
	static public List<MovieDto> toDto(List<Movie> movies) {
		if(movies == null) {
			return null;
		}
		
		return movies.stream()
				.map(m ->  new MovieDto(m.getId(), m.getName()))
				.collect(Collectors.toList());

		
	}
}
