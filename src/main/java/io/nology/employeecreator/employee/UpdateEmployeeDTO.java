package io.nology.employeecreator.employee;

import jakarta.validation.constraints.Pattern;

public class UpdateEmployeeDTO {
	@Pattern(regexp = "^(?=\\S).*$", message="First name cannot be an empty string")
	String firstName;
	
	@Pattern(regexp = "^(?=\\S).*$", message="Last name cannot be an empty string")
	String lastName;
	
	String email;
	String mobile;
	String address;
	String contractType;
	String startDate;
	String hoursType;
	Integer hoursPerWeek;
	String middleName;
	String finishDate;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getHoursType() {
		return hoursType;
	}
	public void setIsFullTime(String hoursType) {
		this.hoursType = hoursType;
	}
	public Integer getHoursPerWeek() {
		return hoursPerWeek;
	}
	public void setHoursPerWeek(Integer hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}	
	
	
}
