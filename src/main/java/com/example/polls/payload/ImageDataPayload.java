package com.example.polls.payload;

import javax.persistence.Column;

public class ImageDataPayload {

    private String imagename;


    private String description;

   

   
    private String imagepathContentType;




	public String getImagename() {
		return imagename;
	}




	public void setImagename(String imagename) {
		this.imagename = imagename;
	}




	public String getDescription() {
		return description;
	}




	public ImageDataPayload() {
		super();
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getImagepathContentType() {
		return imagepathContentType;
	}




	public void setImagepathContentType(String imagepathContentType) {
		this.imagepathContentType = imagepathContentType;
	}
    
    

}
