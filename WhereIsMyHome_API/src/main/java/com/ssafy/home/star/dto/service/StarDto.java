package com.ssafy.home.star.dto.service;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "StarDto : 북마크 정보", description = "즐겨찾기 상세 정보를 나타낸다.")
public class StarDto {


	@ApiModelProperty(value = "유저아이디")
	private String userid;
	
	@ApiModelProperty(value = "아파트 코드")
	private int aptCode;
	
	
	public StarDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public StarDto(String userid, int aptCode) {
		super();
		this.userid = userid;
		this.aptCode = aptCode;
	}
	
	
	public String getUserid() {
		return userid;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public int getAptCode() {
		return aptCode;
	}
	
	public void setAptCode(int aptCode) {
		this.aptCode = aptCode;
	}
	
	
	@Override
	public String toString() {
		return "StarDto [userid=" + userid + ", aptCode=" + aptCode + "]";
	}

	
	
}
