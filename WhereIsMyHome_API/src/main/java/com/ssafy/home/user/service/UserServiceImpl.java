package com.ssafy.home.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.home.user.dao.UserMapper;
import com.ssafy.home.user.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{

	private UserMapper userMapper;
	
	@Autowired
	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper=userMapper;
	}
	
	@Override
	public int getclass(String userid) throws Exception {
		return userMapper.getclass(userid);
	}

	@Override
	public List<UserDto> selectAll() throws Exception {
		return userMapper.selectAll();
	}

	@Override
	public int regist(UserDto user) throws Exception {
		return userMapper.regist(user);
	}

	@Override
	public UserDto login(UserDto user) throws Exception {
		return userMapper.login(user);
	}

	@Override
	public int delete(UserDto user) throws Exception {
		return userMapper.delete(user);
	}

	@Override
	public int modify(UserDto user) throws Exception {
		return userMapper.modify(user);
	}

	@Override
	public UserDto userinfo(String userid) throws Exception {
		return userMapper.info(userid);
	}

	@Override
	public int countId(String userid) throws Exception {
		return userMapper.countId(userid);
	}

}
