package com.example.polls.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table
public class StadeDetail  implements Serializable{
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "stadetype")
    private String stadetype;

    @Column(name = "stadename")
    private String stadename;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStadetype() {
		return stadetype;
	}

	public void setStadetype(String stadetype) {
		this.stadetype = stadetype;
	}

	public String getStadename() {
		return stadename;
	}

	public void setStadename(String stadename) {
		this.stadename = stadename;
	}

	public StadeDetail(Long id, String stadetype, String stadename) {
		super();
		this.id = id;
		this.stadetype = stadetype;
		this.stadename = stadename;
	}

	public StadeDetail(String stadetype, String stadename) {
		super();
		this.stadetype = stadetype;
		this.stadename = stadename;
	}

	public StadeDetail() {
		super();
	}
    
    

}
