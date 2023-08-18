package com.example.polls.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Table(name="formation")
@Entity
public class Formation {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="tag")
    private String tag;

    public Long getId() {
		return id;
	}



	public Formation() {
		super();
	}



	public Formation(Long id, String tag, String description, String searchtext, byte[] mediavideo, String thumbnail,
			String name, String mimeType, String path, String mediavideoContentType) {
		super();
		this.id = id;
		this.tag = tag;
		this.description = description;
		this.searchtext = searchtext;
		this.mediavideo = mediavideo;
		this.thumbnail = thumbnail;
		this.name = name;
		this.mimeType = mimeType;
		this.path = path;
		this.mediavideoContentType = mediavideoContentType;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTag() {
		return tag;
	}



	public void setTag(String tag) {
		this.tag = tag;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getSearchtext() {
		return searchtext;
	}



	public void setSearchtext(String searchtext) {
		this.searchtext = searchtext;
	}



	public byte[] getMediavideo() {
		return mediavideo;
	}



	public void setMediavideo(byte[] mediavideo) {
		this.mediavideo = mediavideo;
	}



	public String getThumbnail() {
		return thumbnail;
	}



	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getMimeType() {
		return mimeType;
	}



	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}



	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public String getMediavideoContentType() {
		return mediavideoContentType;
	}



	public void setMediavideoContentType(String mediavideoContentType) {
		this.mediavideoContentType = mediavideoContentType;
	}



	public List<Wishlist> getWishListList() {
		return wishListList;
	}



	public void setWishListList(List<Wishlist> wishListList) {
		this.wishListList = wishListList;
	}



	@Column(name="mediadescription")
    private String description;

    @Column(name="searchtext")
    private String searchtext;
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "formation")
    private List<Wishlist> wishListList;
    

    
    @Lob
    @Column(name="mediavideo")
    private byte[] mediavideo;
    
    private String thumbnail;
    private String name;
    private String mimeType;
    private String path;
    
    

    @Column(name="mediavideo_content_type")
    private String mediavideoContentType;

}
