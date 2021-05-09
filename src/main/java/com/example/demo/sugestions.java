package com.example.demo;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name="sugestions")
@Table(name="sugestions")
@JsonIgnoreProperties(ignoreUnknown = true)
public class sugestions implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String sugestion;
	@Column
	private String title;
	@Column
	private String email;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSugestion() {
		return sugestion;
	}
	public void setSugestion(String sugestion) {
		this.sugestion = sugestion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public sugestions() {
		
	}
	@Override
	public String toString() {
		return "sugestions [id=" + id + ", sugestion=" + sugestion + ", email=" + email + "]";
	}
	public sugestions(int id, String sugestion, String email) {
		super();
		this.id = id;
		this.sugestion = sugestion;
		this.email = email;
	}

	
	
}
