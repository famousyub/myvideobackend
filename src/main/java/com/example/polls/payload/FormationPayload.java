package com.example.polls.payload;

public class FormationPayload {


	
	private String tag ;
	private String description;
	private String thumbnail;
	
	private String searchText;

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

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public FormationPayload(String tag, String description, String thumbnail, String searchText) {
		super();
		this.tag = tag;
		this.description = description;
		this.thumbnail = thumbnail;
		this.searchText = searchText;
	}

	public FormationPayload() {
		super();
	}
	
	

}
