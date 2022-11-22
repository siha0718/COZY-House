package com.ssafy.home.user.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "UserDto : 유저정보", description = "유저의 상세 정보를 나타낸다.")
public class UserDto {
	private String userid; // 아이디
	private String userpwd; // 비밀번호
	private String username; // 이름
	private String useremail;// 이메일
	private String joindate; // 가입날짜
	private int userclass; //유저등급
	
	public UserDto() {
	}
	public UserDto(String userid, String userpwd, String username, String useremail, String joindate, int userclass) {
		super();
		this.userid = userid;
		this.userpwd = userpwd;
		this.username = username;
		this.useremail = useremail;
		this.joindate = joindate;
		this.userclass = userclass;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String email) {
		this.useremail = email;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public int getUserclass() {
		return userclass;
	}
	public void setUserclass(int userclass) {
		this.userclass = userclass;
	}
	@Override
	public String toString() {
		return "UserDto [userid=" + userid + ", userpwd=" + userpwd + ", username=" + username + ", useremail=" + useremail
				+ ", joindate=" + joindate + ", userclass=" + userclass + "]";
	}
	
}
