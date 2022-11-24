package com.ssafy.home.board.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.home.board.dto.BoardDto;
import com.ssafy.home.board.dto.BoardParameterDto;

public interface BoardService {

	int writeArticle(BoardDto boardDto) throws Exception;

	List<BoardDto> listArticle() throws Exception;

	BoardDto getArticle(int articleno) throws Exception;

	int modifyArticle(BoardDto boardDto) throws Exception;

	int deleteArticle(int articleno) throws Exception;


}
