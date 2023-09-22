package com.example.polls.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Stade implements Serializable {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;

	    @Column(name = "first_name")
	    private String firstName;

	    @Column(name = "last_name")
	    private String lastName;

	    @Column(name = "email")
	    private String email;
	    
	    
	    @Column(name="description")
	    private String stadeUrl;
	    
	    
	    private Boolean disponible;
	    
	    private Integer playernumber;
	    
	    private BigDecimal priceperhour ;
	    
	    
	    private Time startat;
	    
	    public Stade() {
			super();
		}




		public Stade(Long id, String firstName, String lastName, String email, String stadeUrl, Boolean disponible,
				Integer playernumber, BigDecimal priceperhour, Time startat, Time endAt, StadeDetail stadedetail) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.stadeUrl = stadeUrl;
			this.disponible = disponible;
			this.playernumber = playernumber;
			this.priceperhour = priceperhour;
			this.startat = startat;
			this.endAt = endAt;
			this.stadedetail = stadedetail;
		}




		private Time endAt ;
	    
	    
	    

	    public Long getId() {
			return id;
		}




		public void setId(Long id) {
			this.id = id;
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




		public String getEmail() {
			return email;
		}




		public void setEmail(String email) {
			this.email = email;
		}




		public String getStadeUrl() {
			return stadeUrl;
		}




		public void setStadeUrl(String stadeUrl) {
			this.stadeUrl = stadeUrl;
		}




		public Boolean getDisponible() {
			return disponible;
		}




		public void setDisponible(Boolean disponible) {
			this.disponible = disponible;
		}




		public Integer getPlayernumber() {
			return playernumber;
		}




		public void setPlayernumber(Integer playernumber) {
			this.playernumber = playernumber;
		}




		public BigDecimal getPriceperhour() {
			return priceperhour;
		}




		public void setPriceperhour(BigDecimal priceperhour) {
			this.priceperhour = priceperhour;
		}




		public Time getStartat() {
			return startat;
		}




		public void setStartat(Time startat) {
			this.startat = startat;
		}




		public Time getEndAt() {
			return endAt;
		}




		public void setEndAt(Time endAt) {
			this.endAt = endAt;
		}




		public StadeDetail getStadedetail() {
			return stadedetail;
		}




		public void setStadedetail(StadeDetail stadedetail) {
			this.stadedetail = stadedetail;
		}




		@OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "stade_detail_id")
	    private StadeDetail stadedetail;

}
