package com.ssafy.home.star.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ssafy.home.star.dao.StarMapper;
import com.ssafy.home.star.dto.service.StarDto;

@Service
public class StarServiceImpl implements StarService {

	private StarMapper starMapper;
	

	@Autowired
	public StarServiceImpl(StarMapper starMapper) {
		this.starMapper = starMapper;
	}


	//**************** 북마크 등록 **********************/
	
	
	@Override
	public int registStar(StarDto starDto) {
		return starMapper.insertStar(starDto);
	}

	//**************** 북마크 목록 조회 **********************/
	

	@Override
	public List<StarDto> getStarList(String userid) {
		return starMapper.getStarList(userid);
	}

	//**************** 북마크 삭제 **********************/
	
	@Override
	public int deleteStar(StarDto starDto) {
		return starMapper.deleteStar(starDto);
	}

	
	
	
	
}
