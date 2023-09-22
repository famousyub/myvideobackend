package com.example.polls.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stadezone")
public class StadeZone implements Serializable{

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id ;
	
	 @Column(length = 128, nullable = false)
	  private String title;

	  @Column(length = 256)
	  private String description;

	  @Column(nullable = false)
	  private int level;
	  
	  private String stadeUrl;
	  
	  public StadeZone() {
		super();
	}


	public StadeZone(String title, String description, int level, String stadeUrl, boolean avaible, boolean published) {
		super();
		this.title = title;
		this.description = description;
		this.level = level;
		this.stadeUrl = stadeUrl;
		this.avaible = avaible;
		this.published = published;
	}


	public StadeZone(Long id, String title, String description, int level, String stadeUrl, boolean avaible,
			boolean published) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.level = level;
		this.stadeUrl = stadeUrl;
		this.avaible = avaible;
		this.published = published;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public String getStadeUrl() {
		return stadeUrl;
	}


	public void setStadeUrl(String stadeUrl) {
		this.stadeUrl = stadeUrl;
	}


	public boolean isAvaible() {
		return avaible;
	}


	public void setAvaible(boolean avaible) {
		this.avaible = avaible;
	}


	public boolean isPublished() {
		return published;
	}


	public void setPublished(boolean published) {
		this.published = published;
	}


	private boolean avaible ;
	  

	  @Column
	  private boolean published;
	  
	  
	
	
	
	
}
