package com.ssafy.home.apt.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "ApiDto : 아파트정보", description = "아파트의 상세 정보를 나타낸다.")
public class AptDto {
	
	private int houseCode;
	private String houseName;
	private String regCode;
	private String dongName;
	private String jibun;
	private String price;
	private String year;
	private String month;
	private String type;
	private String userid;
	
	
	public AptDto() {
		// TODO Auto-generated constructor stub
	}


	public AptDto(int houseCode, String houseName, String regCode, String dongName, String jibun, String price,
			String year, String month, String type, String userid) {
		super();
		this.houseCode = houseCode;
		this.houseName = houseName;
		this.regCode = regCode;
		this.dongName = dongName;
		this.jibun = jibun;
		this.price = price;
		this.year = year;
		this.month = month;
		this.type = type;
		this.userid = userid;
	}


	public int getAptCode() {
		return houseCode;
	}


	public void setAptCode(int houseCode) {
		this.houseCode = houseCode;
	}


	public String getHouseName() {
		return houseName;
	}


	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}


	public String getRegCode() {
		return regCode;
	}


	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}


	public String getDongName() {
		return dongName;
	}


	public void setDongName(String dongName) {
		this.dongName = dongName;
	}


	public String getJibun() {
		return jibun;
	}


	public void setJibun(String jibun) {
		this.jibun = jibun;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	@Override
	public String toString() {
		return "AptDto [houseCode=" + houseCode + ", houseName=" + houseName + ", regCode=" + regCode + ", dongName="
				+ dongName + ", jibun=" + jibun + ", price=" + price + ", year=" + year + ", month=" + month + ", type="
				+ type + ", userid=" + userid + "]";
	}
}
