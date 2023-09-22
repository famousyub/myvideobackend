package com.example.polls.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import com.example.polls.model.audit.UserDateAudit;



@Entity
@Table(name = "receipt")
public class Receipt extends UserDateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    public Receipt() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Long getFieldId() {
		return fieldId;
	}

	public void setFieldId(Long fieldId) {
		this.fieldId = fieldId;
	}

	public PaymentTerrain getPaymentTerrain() {
		return paymentTerrain;
	}

	public void setPaymentTerrain(PaymentTerrain paymentTerrain) {
		this.paymentTerrain = paymentTerrain;
	}

	public ReservationTerrain getReservation() {
		return reservation;
	}

	public void setReservation(ReservationTerrain reservation) {
		this.reservation = reservation;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public Receipt(Long id, Double totalprice, Long paymentId, Long fieldId, PaymentTerrain paymentTerrain,
			ReservationTerrain reservation, Field field) {
		super();
		this.id = id;
		this.totalprice = totalprice;
		this.paymentId = paymentId;
		this.fieldId = fieldId;
		this.paymentTerrain = paymentTerrain;
		this.reservation = reservation;
		this.field = field;
	}

	private Double totalprice ;


    private Long paymentId;
    private  Long fieldId;



    @OneToOne(mappedBy = "receipt", cascade = CascadeType.ALL)
    private PaymentTerrain paymentTerrain;

    @OneToOne
    @JoinColumn(name = "ReservationId")
    private ReservationTerrain reservation;

    @ManyToOne
    @JoinColumn(name = "FieldId", insertable = false, updatable = false)
    private Field field;


}
