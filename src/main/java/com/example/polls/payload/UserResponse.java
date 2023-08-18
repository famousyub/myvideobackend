package com.example.polls.payload;

public class UserResponse {
	
    private Long id;
    private String username;
    private String name;
    private String phonenumber;
    private String email ;
    private byte[] imageuser;
    
    public byte[] getImageuser() {
		return imageuser;
	}
	public void setImageuser(byte[] imageuser) {
		this.imageuser = imageuser;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String bio ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public UserResponse() {
		super();
	}
    

}
