package com.example.polls.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import com.example.polls.model.audit.UserDateAudit;

import java.util.Date;


@Entity
@Table(name = "paymentterrain")
public class PaymentTerrain extends UserDateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    public PaymentTerrain() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		TotalAmount = totalAmount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public ReservationTerrain getReservation() {
		return reservation;
	}

	public void setReservation(ReservationTerrain reservation) {
		this.reservation = reservation;
	}

	public PaymentTerrain(Long id, Double totalAmount, Date paymentDate, Receipt receipt,
			ReservationTerrain reservation) {
		super();
		this.id = id;
		TotalAmount = totalAmount;
		this.paymentDate = paymentDate;
		this.receipt = receipt;
		this.reservation = reservation;
	}

	private Double TotalAmount ;


    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;

    //@OneToOne(mappedBy = "payment", cascade = CascadeType.ALL)
    @OneToOne
    @JoinColumn(name = "ReceiptId")
    private Receipt receipt;

    @OneToOne
    @JoinColumn(name = "ReservationId")
    private ReservationTerrain reservation;


}
