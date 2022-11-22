package com.ssafy.home.star.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.home.star.dto.service.StarDto;

@Mapper
public interface StarMapper {

	public int insertStar(StarDto starDto);

	public List<String> selectAll(String userid);

	public int deleteStar(StarDto starDto);
	

}