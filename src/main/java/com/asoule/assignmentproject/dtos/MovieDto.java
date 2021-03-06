package com.asoule.assignmentproject.dtos;
import java.io.Serializable;

public class MovieDto implements Serializable{

	private static final long serialVersionUID = 1757638994976288427L;
	private Long id;
	private String name;

	public MovieDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
