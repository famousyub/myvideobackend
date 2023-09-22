package com.example.polls.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "customer")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerId")
    private Long  customerId;

    private String emailAddress;
    private String firstName;
    private String lastName;
    private String phoneNo;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<ReservationTerrain> reservations;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public List<ReservationTerrain> getReservations() {
		return reservations;
	}

	public void setReservations(List<ReservationTerrain> reservations) {
		this.reservations = reservations;
	}

	public Customer(Long customerId, String emailAddress, String firstName, String lastName, String phoneNo,
			List<ReservationTerrain> reservations) {
		super();
		this.customerId = customerId;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.reservations = reservations;
	}

	public Customer() {
		super();
	}
    
    


}
