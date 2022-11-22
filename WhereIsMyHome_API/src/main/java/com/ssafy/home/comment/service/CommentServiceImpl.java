package com.ssafy.home.comment.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.home.comment.dao.CommentMapper;
import com.ssafy.home.comment.dto.CommentDto;

@Service
public class CommentServiceImpl implements CommentService {

	private CommentMapper commentMapper;
	

	@Autowired
	public CommentServiceImpl(CommentMapper commentMapper) {
		this.commentMapper = commentMapper;
	}


	/* -------------------------- 댓글 작성 -------------------------- */
	
	
	@Override
	public int writeComment(CommentDto commentDto) {
		return commentMapper.writeComment(commentDto);
	}
	
	
	
	/* -------------------------- 댓글 수정 -------------------------- */
	
	
	@Override
	public int modifyComment(CommentDto commentDto) {	
		return commentMapper.modifyComment(commentDto);
	}
	
	/* -------------------------- 댓글 목록 반환 -------------------------- */
	
	
	@Override
	public List<CommentDto> getCommentList(Map<String, String> map) {		
		return commentMapper.getCommentList(map);
	}
	
	/* -------------------------- 댓글 삭제 -------------------------- */


	@Override
	public int deleteComment(CommentDto commentDto) {
		return commentMapper.deleteComment(commentDto);
	}

	
}
