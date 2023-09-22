package com.example.polls.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;


@Entity
@Table(name = "fielddetail")
public class FieldDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    private String description;
    private String address;
    private String startProgram;
    public Long getId() {
		return id;
	}

	public FieldDetail() {
		super();
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

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public FieldDetail(Long id, String description, String address, String startProgram, String endProgram,
			Field field) {
		super();
		this.id = id;
		this.description = description;
		this.address = address;
		this.startProgram = startProgram;
		this.endProgram = endProgram;
		this.field = field;
	}

	private String endProgram;

    @OneToOne
    @MapsId
    @JoinColumn(name = "FieldId")
    private Field field;
}
