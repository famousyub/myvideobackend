package com.example.polls.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldDto {

    private  Long  FieldId ;
    private  String  Title ;
    private  String ImageURL ;
    private  String PathURL ;
    private double PriceHour ;
    private  String Description ;
    private  String Address ;
    private  String StartProgram ;
    private String EndProgram ;
	public Long getFieldId() {
		return FieldId;
	}
	public void setFieldId(Long fieldId) {
		FieldId = fieldId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getImageURL() {
		return ImageURL;
	}
	public void setImageURL(String imageURL) {
		ImageURL = imageURL;
	}
	public String getPathURL() {
		return PathURL;
	}
	public void setPathURL(String pathURL) {
		PathURL = pathURL;
	}
	public double getPriceHour() {
		return PriceHour;
	}
	public void setPriceHour(double priceHour) {
		PriceHour = priceHour;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getStartProgram() {
		return StartProgram;
	}
	public void setStartProgram(String startProgram) {
		StartProgram = startProgram;
	}
	public FieldDto() {
		super();
	}
	public String getEndProgram() {
		return EndProgram;
	}
	public void setEndProgram(String endProgram) {
		EndProgram = endProgram;
	}
	public FieldDto(Long fieldId, String title, String imageURL, String pathURL, double priceHour, String description,
			String address, String startProgram, String endProgram) {
		super();
		FieldId = fieldId;
		Title = title;
		ImageURL = imageURL;
		PathURL = pathURL;
		PriceHour = priceHour;
		Description = description;
		Address = address;
		StartProgram = startProgram;
		EndProgram = endProgram;
	}
    
    
}
