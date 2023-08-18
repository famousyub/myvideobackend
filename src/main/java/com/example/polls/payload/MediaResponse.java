package com.example.polls.payload;

public class MediaResponse {
	
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String description ;
	
	private String url_ ;
	
	private String tagy ;
	
	private String tag;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl_() {
		return url_;
	}

	public void setUrl_(String url_) {
		this.url_ = url_;
	}

	public String getTagy() {
		return tagy;
	}

	public void setTagy(String tagy) {
		this.tagy = tagy;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public MediaResponse() {
		super();
	}
	
	

}
