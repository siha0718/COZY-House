package com.ssafy.home.comment.service;

import java.util.List;

import com.ssafy.home.comment.dto.CommentDto;
import com.ssafy.home.star.dto.service.StarDto;

public interface CommentService {

	
	public int registerComment(CommentDto params);
	
	public int modifyComment(CommentDto params);

	public int deleteComment(int aptCode, int cmno);

	public CommentDto getComment(int aptCode, int cmno);
	
	public List<CommentDto> getCommentList(int aptCode);


}
