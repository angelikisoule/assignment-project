package com.soulee.assignmentproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soulee.assignmentproject.entity.Movie;
import com.soulee.assignmentproject.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Movie> list() {
		return movieService.list();
	}

}
