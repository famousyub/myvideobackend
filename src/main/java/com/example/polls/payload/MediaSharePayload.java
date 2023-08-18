package com.example.polls.payload;

import javax.persistence.Column;

public class MediaSharePayload {


  
    private String mediadescription;

   
    private String mediatagy;

    

    
    private String mediavideoContentType;






	public String getMediadescription() {
		return mediadescription;
	}




	public void setMediadescription(String mediadescription) {
		this.mediadescription = mediadescription;
	}




	public String getMediatagy() {
		return mediatagy;
	}




	public void setMediatagy(String mediatagy) {
		this.mediatagy = mediatagy;
	}




	public MediaSharePayload() {
		super();
	}




	public String getMediavideoContentType() {
		return mediavideoContentType;
	}




	public void setMediavideoContentType(String mediavideoContentType) {
		this.mediavideoContentType = mediavideoContentType;
	}
    
    


}
