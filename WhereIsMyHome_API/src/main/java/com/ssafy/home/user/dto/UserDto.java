package com.ssafy.home.user.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "UserDto : 유저정보", description = "유저의 상세 정보를 나타낸다.")
public class UserDto {
	private String userid; // 아이디
	private String userpwd; // 비밀번호
	private String username; // 이름
	private String email;// 주소
	private String joindate; // 전화번호
	private int userclass;
	
	public UserDto() {
	}
	public UserDto(String userid, String userpwd, String username, String email, String joindate, int userclass) {
		super();
		this.userid = userid;
		this.userpwd = userpwd;
		this.username = username;
		this.email = email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
		return "UserDto [userid=" + userid + ", userpwd=" + userpwd + ", username=" + username + ", email=" + email
				+ ", joindate=" + joindate + ", userclass=" + userclass + "]";
	}
	
}
