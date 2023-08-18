package com.example.polls.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name="beginvid")
public class BeginVid {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	 private String title;
	 
	 @Lob
	 private byte[] video;
	 
	    private String name;
	    public BeginVid() {
			super();
		}
		public BeginVid(Long id, String title, byte[] video, String name, String mimeType, String path) {
			super();
			this.id = id;
			this.title = title;
			this.video = video;
			this.name = name;
			this.mimeType = mimeType;
			this.path = path;
		}
		private String mimeType;
	    private String path;
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
		public byte[] getVideo() {
			return video;
		}
		public void setVideo(byte[] video) {
			this.video = video;
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
	 

}
