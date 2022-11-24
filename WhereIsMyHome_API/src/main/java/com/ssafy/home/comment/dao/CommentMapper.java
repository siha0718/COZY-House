package com.ssafy.home.comment.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.home.comment.dto.CommentDto;

@Mapper
public interface CommentMapper {

	public int writeComment(CommentDto commentDto);

	public int modifyComment(CommentDto commentDto);

	public List<CommentDto> getCommentList(Map<String, String> map);
	
	public int deleteComment(int cmNum);

	public int selectCommentTotalCount(int aptCode);
	

}