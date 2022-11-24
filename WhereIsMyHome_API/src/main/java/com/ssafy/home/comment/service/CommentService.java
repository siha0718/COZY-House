package com.ssafy.home.comment.service;

import java.util.List;
import java.util.Map;

import com.ssafy.home.comment.dto.CommentDto;
import com.ssafy.home.star.dto.StarDto;

public interface CommentService {

	
	public int writeComment(CommentDto commentDto);
	
	public int modifyComment(CommentDto commentDto);

	public List<CommentDto> getCommentList(Map<String, String> map);

	public int deleteComment(int cmNum);

}
