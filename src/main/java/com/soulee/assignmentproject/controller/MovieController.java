package com.soulee.assignmentproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asoule.assignmentproject.dtos.MovieDto;
import com.soulee.assignmentproject.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<MovieDto> list() {
		return movieService.list();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MovieDto getMovie(@PathVariable("id") Long id) {
		return movieService.getById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		movieService.deleteById(id);
	}
	
	@RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
	public List<MovieDto> getMovie(@PathVariable("name") String name) {
		return movieService.getByName(name);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public void add(@RequestBody MovieDto Dto) {
		movieService.add(Dto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public void like(@PathVariable("id") Long id) {
		movieService.like(id);
	}

}
