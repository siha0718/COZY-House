package com.ssafy.home.star.service;

import java.util.List;

import com.ssafy.home.comment.dto.CommentDto;
import com.ssafy.home.star.dto.service.StarDto;

public interface StarService {

	public int registStar(StarDto starDto);

	public List<String> getStarList(String userid);

	public int deleteStar(StarDto starDto);


}
