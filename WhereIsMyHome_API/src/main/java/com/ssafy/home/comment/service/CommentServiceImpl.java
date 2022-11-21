package com.ssafy.home.comment.service;


import java.util.List;

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
	public int registerComment(CommentDto params) {
		return commentMapper.insertComment(params);
	}
	
	
	
	/* -------------------------- 댓글 수정 -------------------------- */
	
	
	@Override
	public int modifyComment(CommentDto params) {	
		return commentMapper.updateComment(params);
	}
	
	/* -------------------------- 댓글 삭제 -------------------------- */


	@Override
	public int deleteComment(int aptCode, int cmno) {
		
		CommentDto comment = new CommentDto();
		
		comment.setCmno(cmno);
		comment.setAptCode(cmno);

		return commentMapper.deleteComment(comment);
		
	}
	
	
	
	/* -------------------------- 댓글 내용 조회 -------------------------- */

	
	@Override
	public CommentDto getComment(int aptCode, int cmno) {
		
		CommentDto comment = new CommentDto();
		comment.setAptCode(aptCode);
		comment.setCmno(cmno);
		
		return commentMapper.selectCommentDetail(comment);
	}

	
	
	
	/* -------------------------- 댓글 목록 반환 -------------------------- */

	
	@Override
	public List<CommentDto> getCommentList(int aptCode) {		
		return commentMapper.selectCommentList(aptCode);
	}

	
	
}
