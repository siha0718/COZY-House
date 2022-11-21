package com.ssafy.home.comment.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CommentDto : 댓글정보", description = "댓글의 상세 정보를 나타낸다.")
public class CommentDto {
	
	@ApiModelProperty(value = "댓글번호") // 댓글번호가 맞나...?
	private int cmno;
	@ApiModelProperty(value = "댓글내용")
	private String content;
	@ApiModelProperty(value = "댓글작성날짜")
	private String date;
	@ApiModelProperty(value = "평점")
	private double star;
	@ApiModelProperty(value = "댓글작성자")
	private String userid;
	@ApiModelProperty(value = "아파트코드")
	private int aptCode;
	
	
	public CommentDto() {
		// TODO Auto-generated constructor stub
	}
	
	public CommentDto(int cmno, String content, String date, double star, String userid, int aptCode) {
		super();
		this.cmno = cmno;
		this.content = content;
		this.date = date;
		this.star = star;
		this.userid = userid;
		this.aptCode = aptCode;
	}
		

	public int getCmno() {
		return cmno;
	}

	public void setCmno(int cmno) {
		this.cmno = cmno;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getStar() {
		return star;
	}

	public void setStar(double star) {
		this.star = star;
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
		return "CommentDto [cmno=" + cmno + ", content=" + content + ", date=" + date + ", star=" + star + ", userid="
				+ userid + ", aptCode=" + aptCode + "]";
	}
	
	
	
}
