package com.soulee.assignmentproject.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asoule.assignmentproject.dtos.MovieDto;
import com.asoule.assignmentproject.repository.LikeRepository;
import com.asoule.assignmentproject.repository.MovieRepository;
import com.asoule.assignmentproject.util.Converter;
import com.soulee.assignmentproject.entity.Like;
import com.soulee.assignmentproject.entity.Movie;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private LikeRepository likeRepository;

	public List<MovieDto> list() {
		return movieRepository.findAll().stream()
				.map(m -> new MovieDto(m.getId(), m.getName(), 
						m.getLike()!=null ? m.getLike().getCounter() : 0
						
						))				
				
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
	
	public MovieDto like(Long id) {
		Optional<Movie> optional = movieRepository.findById(id);
		if (optional.isPresent()) {
			Movie movie = optional.get();
			Like like = movie.getLike();
			long l = like.getCounter()+1;
			like.setCounter(l);
			likeRepository.save(like);
			
			return Converter.toDto(movieRepository.findById(id).get());
		} else {
			return new MovieDto();
		}

	}

	public List<MovieDto> getByName(String name) {
		List<Movie> movies = movieRepository.findByName(name);
		return Converter.toDto(movies);
	}

	public void add(MovieDto movie) {
		Like like = likeRepository.save(new Like(0l));
		movieRepository.save(new Movie(movie.getName(), like));
	}

	public void deleteById(Long id) {
		movieRepository.deleteById(id);
	}
}
