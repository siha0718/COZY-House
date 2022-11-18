package com.ssafy.home.user.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.home.user.dto.UserDto;

@Mapper
public interface UserMapper {

	public int getclass(String userid) throws SQLException;

	public List<UserDto> selectAll() throws SQLException;

	public int regist(UserDto user) throws SQLException;

	public UserDto login(UserDto user) throws SQLException;

	public int delete(UserDto user) throws SQLException;

	public int modify(UserDto user) throws SQLException;

	public UserDto info(String userid) throws SQLException;

	public int countId(String userid) throws SQLException;

}
