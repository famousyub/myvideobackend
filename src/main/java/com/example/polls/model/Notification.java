package com.example.polls.model;



import javax.persistence.*;

import lombok.Builder;

import java.time.LocalDateTime;

@Entity
@Table (name = "notification")
@Builder
public class Notification {

	
	
	@Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "message")
    private String message;

    @Column (name = "is_read")
    private boolean read;

   

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}



	public Notification() {
		super();
	}

	public Notification(Long id, String message, boolean read) {
		super();
		this.id = id;
		this.message = message;
		this.read = read;
	
	}

    

   
}
