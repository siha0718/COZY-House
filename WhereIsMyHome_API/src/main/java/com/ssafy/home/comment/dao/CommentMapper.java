package com.ssafy.home.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.home.comment.dto.CommentDto;

@Mapper
public interface CommentMapper {

	public int insertComment(CommentDto params);

	public CommentDto selectCommentDetail(CommentDto params);

	public int updateComment(CommentDto params);

	public int deleteComment(CommentDto params);

	public List<CommentDto> selectCommentList(int aptCode);

	public int selectCommentTotalCount(int aptCode);
	

}