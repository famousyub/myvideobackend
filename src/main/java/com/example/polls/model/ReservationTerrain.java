package com.example.polls.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "reservationterrain")
public class ReservationTerrain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Temporal(TemporalType.TIMESTAMP)
    private Date start;
    public ReservationTerrain() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
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

	public String getPrimarycolor() {
		return primarycolor;
	}

	public void setPrimarycolor(String primarycolor) {
		this.primarycolor = primarycolor;
	}

	public String getSecondarycolor() {
		return secondarycolor;
	}

	public void setSecondarycolor(String secondarycolor) {
		this.secondarycolor = secondarycolor;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public ReservationTerrain(Long id, Date start, Date end, String title, Double total, String description,
			String path, String imageURL, String address, String startProgram, String endProgram, String primarycolor,
			String secondarycolor, Customer customer, Long fieldId, PaymentTerrain paymentTerrain, Receipt receipt,
			Field field) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
		this.title = title;
		this.total = total;
		this.description = description;
		this.path = path;
		this.imageURL = imageURL;
		this.address = address;
		this.startProgram = startProgram;
		this.endProgram = endProgram;
		this.primarycolor = primarycolor;
		this.secondarycolor = secondarycolor;
		this.customer = customer;
		this.fieldId = fieldId;
		this.paymentTerrain = paymentTerrain;
		this.receipt = receipt;
		this.field = field;
	}

	@Temporal(TemporalType.TIMESTAMP)
    private Date end ;
    private String title ;
    private Double total ;


    private String description;
    private String path;
    private String imageURL;
    private String address;
    private String startProgram;
    private String endProgram;

    private String primarycolor ;
    private String secondarycolor ;


    @ManyToOne
    @JoinColumn(name = "CustomerId", insertable = true, updatable = true)
    private Customer customer;
    private Long fieldId;
    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
    private PaymentTerrain paymentTerrain;

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
    private Receipt receipt;

    @ManyToOne
    @JoinColumn(name = "FieldId", insertable = false, updatable = false)
    private Field field;

}
