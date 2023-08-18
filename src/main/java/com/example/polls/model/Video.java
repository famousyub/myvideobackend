package com.example.polls.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="video")
public class Video {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	 private String title;
	    private String description;
	    @Column(name = "tags")
	    private String tags;
	    
	    
	    private VideoStatus videoStatus;
	    
	    private String searchtext;
	    
	    
	    @Lob
	    private byte[] videoshare ;
	    
	    
	    private String videoUrl;
	    
	    
	    @JsonIgnore
	    @Column(name = "original_path")
	    @Type(type = "text")
	    public String originalFilePath;
	    
	    @Column(name = "created_date", nullable = true,updatable = true)
	    @CreationTimestamp
	    private Timestamp createdDate ;

	    public Timestamp getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Timestamp createdDate) {
			this.createdDate = createdDate;
		}

		public Video() {
			super();
		}

		public Video(Long id, String title, String description, String tags, VideoStatus videoStatus,
				String searchtext, byte[] videoshare, String videoUrl, String originalFilePath, String originalFileName,
				String originalFileExtension, boolean write, String compressedFilePath, boolean compressed,
				String thumbnailPath, boolean thumbnail) {
			super();
			this.id = id;
			this.title = title;
			this.description = description;
			this.tags = tags;
			this.videoStatus = videoStatus;
			this.searchtext = searchtext;
			this.videoshare = videoshare;
			this.videoUrl = videoUrl;
			this.originalFilePath = originalFilePath;
			this.originalFileName = originalFileName;
			this.originalFileExtension = originalFileExtension;
			this.write = write;
			this.compressedFilePath = compressedFilePath;
			this.compressed = compressed;
			this.thumbnailPath = thumbnailPath;
			this.thumbnail = thumbnail;
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

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getTags() {
			return tags;
		}

		public void setTags(String tags) {
			this.tags = tags;
		}

		public VideoStatus getVideoStatus() {
			return videoStatus;
		}

		public void setVideoStatus(VideoStatus videoStatus) {
			this.videoStatus = videoStatus;
		}

		public String getSearchtext() {
			return searchtext;
		}

		public void setSearchtext(String searchtext) {
			this.searchtext = searchtext;
		}

		public byte[] getVideoshare() {
			return videoshare;
		}

		public void setVideoshare(byte[] videoshare) {
			this.videoshare = videoshare;
		}

		public String getVideoUrl() {
			return videoUrl;
		}

		public void setVideoUrl(String videoUrl) {
			this.videoUrl = videoUrl;
		}

		public String getOriginalFilePath() {
			return originalFilePath;
		}

		public void setOriginalFilePath(String originalFilePath) {
			this.originalFilePath = originalFilePath;
		}

		public String getOriginalFileName() {
			return originalFileName;
		}

		public void setOriginalFileName(String originalFileName) {
			this.originalFileName = originalFileName;
		}

		public String getOriginalFileExtension() {
			return originalFileExtension;
		}

		public void setOriginalFileExtension(String originalFileExtension) {
			this.originalFileExtension = originalFileExtension;
		}

		public boolean isWrite() {
			return write;
		}

		public void setWrite(boolean write) {
			this.write = write;
		}

		public String getCompressedFilePath() {
			return compressedFilePath;
		}

		public void setCompressedFilePath(String compressedFilePath) {
			this.compressedFilePath = compressedFilePath;
		}

		public boolean isCompressed() {
			return compressed;
		}

		public void setCompressed(boolean compressed) {
			this.compressed = compressed;
		}

		public String getThumbnailPath() {
			return thumbnailPath;
		}

		public void setThumbnailPath(String thumbnailPath) {
			this.thumbnailPath = thumbnailPath;
		}

		public boolean isThumbnail() {
			return thumbnail;
		}

		public void setThumbnail(boolean thumbnail) {
			this.thumbnail = thumbnail;
		}

		@Column(name = "original_file_name", nullable = false)
	    @Type(type = "text")
	    public String originalFileName;

	    @Column(name = "original_file_ext", nullable = false)
	    public String originalFileExtension;

	    @JsonIgnore
	    @Column(name = "is_write")
	    private boolean write;

	    @JsonIgnore
	    @Column(name = "compressed_path")
	    @Type(type = "text")
	    public String compressedFilePath;

	    @JsonIgnore
	    @Column(name = "is_compressed")
	    private boolean compressed;

	    @JsonIgnore
	    @Column(name = "thumbnail_path")
	    @Type(type = "text")
	    private String thumbnailPath;

	    @JsonIgnore
	    @Column(name = "is_thumbnail")
	    private boolean thumbnail;
	    
	    
	    
	    

}
