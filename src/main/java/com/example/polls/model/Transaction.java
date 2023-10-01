package com.example.polls.model;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name="transaction")


public class Transaction implements Serializable {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name="reservationterrain_id", referencedColumnName = "id")
	    private ReservationTerrain reservationterrain;

	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name="user_id", referencedColumnName = "id")
	    private User user;

	    public Long getId() {
			return id;
		}

		public Transaction() {
			super();
		}

		public Transaction(Long id, ReservationTerrain field, User user, LocalDateTime purchaseDate) {
			super();
			this.id = id;
			this.reservationterrain = field;
			this.user = user;
			this.purchaseDate = purchaseDate;
		}

		public void setId(Long id) {
			this.id = id;
		}

	

		public ReservationTerrain getReservationterrain() {
			return reservationterrain;
		}

		public void setReservationterrain(ReservationTerrain reservationterrain) {
			this.reservationterrain = reservationterrain;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public LocalDateTime getPurchaseDate() {
			return purchaseDate;
		}

		public void setPurchaseDate(LocalDateTime purchaseDate) {
			this.purchaseDate = purchaseDate;
		}

		@Column(name="purchase_date")
	    private LocalDateTime purchaseDate;

}
