package com.asoule.assignmentproject.dtos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name","id"})
public class MovieDto implements Serializable {

	private static final long serialVersionUID = 1757638994976288427L;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Long id;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String name;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Long likes;


	public MovieDto() {
	}
	
	public MovieDto(String name) {
		this.name = name;
	}
	
	public MovieDto(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public MovieDto(Long id, String name, Long likes) {
		this.id = id;
		this.name = name;
		this.likes = likes;
	}

	public Long getLikes() {
		return likes;
	}
	
	public void setLikes(Long likes) {
		this.likes = likes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
