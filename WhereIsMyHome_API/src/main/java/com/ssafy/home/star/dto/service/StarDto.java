package com.ssafy.home.star.dto.service;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "StarDto : 북마크 정보", description = "즐겨찾기 상세 정보를 나타낸다.")
public class StarDto {

	
	@ApiModelProperty(value = "집고유번호")
	private String houseCode;
	@ApiModelProperty(value = "집이름")
	private String houseName;
	@ApiModelProperty(value = "지역코드")
	private String regCode;
	@ApiModelProperty(value = "동이름")
	private String dongName;
	@ApiModelProperty(value = "지번")
	private String jibun;
	@ApiModelProperty(value = "가격")
	private String price;
	@ApiModelProperty(value = "년")
	private String year;
	@ApiModelProperty(value = "월")
	private String month;
	@ApiModelProperty(value = "집타입")
	private String type;
	@ApiModelProperty(value = "유저아이디")
	private String userid;
	
	
	public StarDto() {
		// TODO Auto-generated constructor stub
	}


	public StarDto(String houseCode, String houseName, String regCode, String dongName, String jibun, String price,
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


	public String getHouseCode() {
		return houseCode;
	}


	public void setHouseCode(String houseCode) {
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
		return "StarDto [houseCode=" + houseCode + ", houseName=" + houseName + ", regCode=" + regCode + ", dongName="
				+ dongName + ", jibun=" + jibun + ", price=" + price + ", year=" + year + ", month=" + month + ", type="
				+ type + ", userid=" + userid + "]";
	}
	
}
