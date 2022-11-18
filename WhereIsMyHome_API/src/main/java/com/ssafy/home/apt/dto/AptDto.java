package com.ssafy.home.apt.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "ApiDto : 아파트정보", description = "아파트의 상세 정보를 나타낸다.")
public class AptDto {
	
	private int aptCode;
	private String aptName;
	private String dongCode;
	private String dongName;
	private int buildYear;
	private String jibun;
	private String lat;
	private String lng;
	private String userid;
	
	
	public AptDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public AptDto(int aptCode, String aptName, String dongCode, String dongName, int buildYear, String jibun,
			String lat, String lng, String userid) {
		super();
		this.aptCode = aptCode;
		this.aptName = aptName;
		this.dongCode = dongCode;
		this.dongName = dongName;
		this.buildYear = buildYear;
		this.jibun = jibun;
		this.lat = lat;
		this.lng = lng;
		this.userid = userid;
	}


	public int getAptCode() {
		return aptCode;
	}


	public void setAptCode(int aptCode) {
		this.aptCode = aptCode;
	}


	public String getAptName() {
		return aptName;
	}


	public void setAptName(String aptName) {
		this.aptName = aptName;
	}


	public String getDongCode() {
		return dongCode;
	}


	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}


	public String getDongName() {
		return dongName;
	}


	public void setDongName(String dongName) {
		this.dongName = dongName;
	}


	public int getBuildYear() {
		return buildYear;
	}


	public void setBuildYear(int buildYear) {
		this.buildYear = buildYear;
	}


	public String getJibun() {
		return jibun;
	}


	public void setJibun(String jibun) {
		this.jibun = jibun;
	}


	public String getLat() {
		return lat;
	}


	public void setLat(String lat) {
		this.lat = lat;
	}


	public String getLng() {
		return lng;
	}


	public void setLng(String lng) {
		this.lng = lng;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	@Override
	public String toString() {
		return "AptDto [aptCode=" + aptCode + ", aptName=" + aptName + ", dongCode=" + dongCode + ", dongName="
				+ dongName + ", buildYear=" + buildYear + ", jibun=" + jibun + ", lat=" + lat + ", lng=" + lng
				+ ", userid=" + userid + "]";
	}
	
	
	
	
}
