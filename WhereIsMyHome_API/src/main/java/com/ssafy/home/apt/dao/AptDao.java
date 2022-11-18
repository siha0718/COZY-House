package com.ssafy.home.apt.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.home.apt.dto.AptDto;

@Mapper
public interface AptDao {

	public List<AptDto> selectAll(String dong) throws SQLException;
	public int insertApt(AptDto aptDto) throws SQLException;
	public int deleteApt(AptDto aptDto) throws SQLException;
	public int modifyApt(AptDto aptDto)  throws SQLException; 
	
}
