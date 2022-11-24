package com.ssafy.home.board.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.home.board.dto.BoardDto;
//import com.ssafy.home.board.dto.BoardParameterDto;



@Mapper
public interface BoardMapper {
	
	public int writeArticle(BoardDto boardDto) throws SQLException;
	public List<BoardDto> listArticle() throws SQLException;
	public BoardDto getArticle(int articleno) throws SQLException;
	public int modifyArticle(BoardDto boardDto) throws SQLException;
	public int deleteArticle(int articleno) throws SQLException;
	
}