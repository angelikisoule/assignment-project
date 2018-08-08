package com.soulee.assignmentproject.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIE")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "like_id", nullable = false)
	private Like like;

	public Movie() {}
	
	public Movie(String name) {
		this.name = name;
	}
	
	public Movie(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Movie( String name, Like like) {
		this.name = name;
		this.like = like;
	}
	
	public Like getLike() {
		return like;
	}

	public void setLike(Like like) {
		this.like = like;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    

}
