package com.example.polls.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import com.example.polls.model.audit.UserDateAudit;


@Entity
@Table(name = "field")
public class Field extends UserDateAudit {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FieldId")
    private Long id ;

    public Field() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public FieldDetail getDetail() {
		return detail;
	}

	public void setDetail(FieldDetail detail) {
		this.detail = detail;
	}

	public Field(Long id, String title, String imageUrl, Double pricehour, String pathurl, FieldDetail detail) {
		super();
		this.id = id;
		this.title = title;
		this.imageUrl = imageUrl;
		this.pricehour = pricehour;
		this.pathurl = pathurl;
		this.detail = detail;
	}

	private String title ;
    private  String imageUrl ;
    private Double pricehour ;

    private String pathurl ;

    @OneToOne(mappedBy = "field", cascade = CascadeType.ALL)
    private FieldDetail detail;


}
