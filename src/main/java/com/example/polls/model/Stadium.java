package com.example.polls.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import com.example.polls.model.audit.UserDateAudit;

@Entity
@Table(name="stadiumd")
public class Stadium extends UserDateAudit{
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
	
	 @Column(length = 128, nullable = false)
	  private String title;
	 
	  @Column(nullable = false)
	  private int level;
	
	
	private String description;
	
	private String  image;
	
	
	@Column(name="hourPrice")
	private BigDecimal hourpice;
	
	private String address ;
	
	@Column(name = "ownerID")
	private Integer ounwerId;
	
	private boolean avaible ;
	  

	  public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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

	@Column
	  private boolean published;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public BigDecimal getHourpice() {
		return hourpice;
	}

	public void setHourpice(BigDecimal hourpice) {
		this.hourpice = hourpice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Stadium(String description, String image, BigDecimal hourpice, String address, Integer ounwerId) {
		super();
		this.description = description;
		this.image = image;
		this.hourpice = hourpice;
		this.address = address;
		this.ounwerId = ounwerId;
	}

	public Integer getOunwerId() {
		return ounwerId;
	}

	public Stadium() {
		super();
	}

	public void setOunwerId(Integer ounwerId) {
		this.ounwerId = ounwerId;
	}

	public Stadium(Long id, String description, String image, BigDecimal hourpice, String address, Integer ounwerId) {
		super();
		this.id = id;
		this.description = description;
		this.image = image;
		this.hourpice = hourpice;
		this.address = address;
		this.ounwerId = ounwerId;
	}
	
	
	
	

}
