package com.example.polls.model;

import java.io.Serializable;

import javax.persistence.*;

@Table(name="videoevent")
@Entity

public class VideoEvent implements Serializable {
	
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private String mimeType;
	    private String path;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public VideoEvent() {
			super();
		}
		public VideoEvent(Long id, String name, String mimeType, String path) {
			super();
			this.id = id;
			this.name = name;
			this.mimeType = mimeType;
			this.path = path;
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
	    
	    

}
