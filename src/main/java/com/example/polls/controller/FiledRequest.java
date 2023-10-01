package com.example.polls.controller;

public class FiledRequest {
	
	String title; 
	String imageUrl; 
	Double pricehour;
	String pathurl;
	
	String description;
	String address;
	String startProgram;
	String endProgram;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Double getPricehour() {
		return pricehour;
	}
	public void setPricehour(Double pricehour) {
		this.pricehour = pricehour;
	}
	public String getPathurl() {
		return pathurl;
	}
	public void setPathurl(String pathurl) {
		this.pathurl = pathurl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStartProgram() {
		return startProgram;
	}
	public void setStartProgram(String startProgram) {
		this.startProgram = startProgram;
	}
	public String getEndProgram() {
		return endProgram;
	}
	public void setEndProgram(String endProgram) {
		this.endProgram = endProgram;
	}
	public FiledRequest(String title, String imageUrl, Double pricehour, String pathurl, String description,
			String address, String startProgram, String endProgram) {
		super();
		this.title = title;
		this.imageUrl = imageUrl;
		this.pricehour = pricehour;
		this.pathurl = pathurl;
		this.description = description;
		this.address = address;
		this.startProgram = startProgram;
		this.endProgram = endProgram;
	}
	public FiledRequest() {
		super();
	}
	
	

}
