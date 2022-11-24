package com.ssafy.home.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.home.board.dao.BoardMapper;
import com.ssafy.home.board.dto.BoardDto;
import com.ssafy.home.board.dto.BoardParameterDto;

@Service
public class BoardServiceImpl implements BoardService{

	private BoardMapper boardMapper;
	
	@Autowired
	public BoardServiceImpl(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}
	
	@Override
	public int writeArticle(BoardDto boardDto) throws Exception {
		if(boardDto.getSubject() == null || boardDto.getContent() == null) {
			throw new Exception();
		}
		return boardMapper.writeArticle(boardDto);
	}

	@Override
	public List<BoardDto> listArticle() throws Exception {
//		int start = boardParameterDto.getPg() == 0 ? 0 : (boardParameterDto.getPg() - 1) * boardParameterDto.getSpp();
//		boardParameterDto.setStart(start);
//		return boardMapper.listArticle(boardParameterDto);
		return boardMapper.listArticle();
	}

	@Override
	public BoardDto getArticle(int articleno) throws Exception {
		return boardMapper.getArticle(articleno);
	}

	@Override
	@Transactional
	public int modifyArticle(BoardDto boardDto) throws Exception {
		return boardMapper.modifyArticle(boardDto);
	}

	@Override
	@Transactional
	public int deleteArticle(int articleno) throws Exception {
//		sqlSession.getMapper(BoardMapper.class).deleteMemo(articleno);
		return boardMapper.deleteArticle(articleno);
	}

}
