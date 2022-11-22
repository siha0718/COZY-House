package com.ssafy.home.comment.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CommentDto : 댓글정보", description = "댓글의 상세 정보를 나타낸다.")
public class CommentDto {
	
	@ApiModelProperty(value = "댓글번호") // 댓글번호가 맞나...?
	private int cmNum;
	@ApiModelProperty(value = "댓글내용")
	private String content;
	@ApiModelProperty(value = "집고유번호")
	private String houseCode;
	@ApiModelProperty(value = "댓글작성자")
	private String userid;
	@ApiModelProperty(value = "댓글작성날짜")
	private String time;
	
	
	public CommentDto() {
		// TODO Auto-generated constructor stub
	}


	public CommentDto(int cmNum, String content, String houseCode, String userid, String time) {
		super();
		this.cmNum = cmNum;
		this.content = content;
		this.houseCode = houseCode;
		this.userid = userid;
		this.time = time;
	}


	public int getCmNum() {
		return cmNum;
	}


	public void setCmNum(int cmNum) {
		this.cmNum = cmNum;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getHouseCode() {
		return houseCode;
	}


	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	@Override
	public String toString() {
		return "CommentDto [cmNum=" + cmNum + ", content=" + content + ", houseCode=" + houseCode + ", userid=" + userid
				+ ", time=" + time + "]";
	}
	
	
}
