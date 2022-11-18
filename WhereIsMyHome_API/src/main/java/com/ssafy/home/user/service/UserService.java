package com.ssafy.home.user.service;

import java.util.List;

import com.ssafy.home.user.dto.UserDto;

public interface UserService {

	public int getclass(String userid) throws Exception;
	public List<UserDto> selectAll() throws Exception;
	public int regist(UserDto user) throws Exception;
	public UserDto login(UserDto user) throws Exception;
	public int delete(UserDto user) throws Exception;
	public int modify(UserDto user) throws Exception;
	public UserDto userinfo(String userid) throws Exception;
	public int countId(String userid) throws Exception;
}
