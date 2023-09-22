package com.example.polls.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;


public class ReservationDto {

    private Long  id;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
    private String title;
    private double total;
    private String field;
    private String description;
    private String path;
    public ReservationDto() {
		super();
	}
	public ReservationDto(Long id, String name, LocalDateTime start, LocalDateTime end, String title, double total,
			String field, String description, String path, String imageURL, String address, String startProgram,
			String endProgram) {
		super();
		this.id = id;
		this.name = name;
		this.start = start;
		this.end = end;
		this.title = title;
		this.total = total;
		this.field = field;
		this.description = description;
		this.path = path;
		this.imageURL = imageURL;
		this.address = address;
		this.startProgram = startProgram;
		this.endProgram = endProgram;
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
	public LocalDateTime getStart() {
		return start;
	}
	public void setStart(LocalDateTime start) {
		this.start = start;
	}
	public LocalDateTime getEnd() {
		return end;
	}
	public void setEnd(LocalDateTime end) {
		this.end = end;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
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
	private String imageURL;
    private String address;
    private String startProgram;
    private String endProgram;


}
