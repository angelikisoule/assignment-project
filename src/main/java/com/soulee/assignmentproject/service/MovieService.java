package com.soulee.assignmentproject.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asoule.assignmentproject.dtos.MovieDto;
import com.asoule.assignmentproject.repository.MovieRepository;
import com.asoule.assignmentproject.util.Converter;
import com.soulee.assignmentproject.entity.Movie;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public List<MovieDto> list() {
		return movieRepository.findAll().stream().map(m -> new MovieDto(m.getId(), m.getName()))
				.collect(Collectors.toList());
	}

	public MovieDto getById(Long id) {
		Optional<Movie> optional = movieRepository.findById(id);
		if (optional.isPresent()) {
			return Converter.toDto(optional.get());
		} else {
			return new MovieDto();
		}

	}

	public List<MovieDto> getByName(String name) {
		List<Movie> movies = movieRepository.findByName(name);
		return Converter.toDto(movies);
	}

	public void add(MovieDto movie) {
		movieRepository.save(new Movie(movie.getName()));
	}

	public void deleteById(Long id) {
		movieRepository.deleteById(id);
	}
}
