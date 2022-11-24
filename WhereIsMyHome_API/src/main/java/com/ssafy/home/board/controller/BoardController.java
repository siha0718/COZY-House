package com.ssafy.home.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.home.board.dto.BoardDto;
import com.ssafy.home.board.dto.BoardParameterDto;
import com.ssafy.home.board.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/board")
@Api("게시판 컨트롤러 ")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	private BoardService boardService;

	@Autowired
	public BoardController(BoardService boardService) {
		logger.info("보드 컨트롤러 호출");
		this.boardService = boardService;
	}

	@ApiOperation(value = "게시판 글작성", notes = "새로운 게시글 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<Map<String, Object>> writeArticle(
			@RequestBody @ApiParam(value = "게시글 정보.", required = true) BoardDto boardDto) {
		logger.info("writeArticle - 호출 {}", boardDto);

		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;

		try {
			int res = boardService.writeArticle(boardDto);

			if (res == 1) {
				logger.info("글 등록 성공");
				status = HttpStatus.ACCEPTED;
				resultMap.put("msg", SUCCESS);
			} else {
				logger.info("글 등록 실패");
				status = HttpStatus.ACCEPTED;
				resultMap.put("msg", FAIL);
			}
		} catch (Exception e) {
			logger.error("board 디비 접근 실패 : { }", e);
			resultMap.put("msg", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "게시판 글목록", notes = "모든 게시글의 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<Map<String, Object>> listArticle() {
		logger.info("listArticle 호출");

		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		List<BoardDto> boardList = null;

		try {
			boardList = boardService.listArticle();
			logger.info("불러온 보드 목록  {}", boardList);
			resultMap.put("boardList", boardList);
			resultMap.put("msg", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			logger.error("리스트 호출실패 : { }", e);
			resultMap.put("msg", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "게시판 글보기", notes = "글번호에 해당하는 게시글의 정보를 반환한다.", response = BoardDto.class)
	@GetMapping("/{articleno}")
	public ResponseEntity<Map<String, Object>> getArticle(
			@PathVariable("articleno") @ApiParam(value = "얻어올 글의 글번호.", required = true) int articleno) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		logger.info("getArticle - 호출 : " + articleno);
		try {
			BoardDto board = boardService.getArticle(articleno);
			logger.info("가져온 글 정보 - 호출 : " + board);
			resultMap.put("board", board);
			resultMap.put("msg", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			logger.error("글 호출실패 : { }", e);
			resultMap.put("msg", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "게시판 글수정", notes = "수정할 게시글 정보를 입력한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping
	public ResponseEntity<Map<String, Object>> modifyArticle(
			@RequestBody @ApiParam(value = "수정할 글정보.", required = true) BoardDto boardDto) {
		logger.info("modifyArticle - 호출 {}", boardDto);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;

		try {
			int res = boardService.modifyArticle(boardDto);
			if (res == 1) {
				logger.info("글 수정 성공");
				status = HttpStatus.ACCEPTED;
				resultMap.put("msg", SUCCESS);
			} else {
				logger.info("글 수정 실패");
				status = HttpStatus.ACCEPTED;
				resultMap.put("msg", FAIL);
			}
		} catch (Exception e) {
			logger.error("글 수정 디비 접근실패 : { }", e);
			resultMap.put("msg", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "게시판 글삭제", notes = "글번호에 해당하는 게시글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/{articleno}")
	public ResponseEntity<Map<String, Object>> deleteArticle(
			@PathVariable("articleno") @ApiParam(value = "살제할 글의 글번호.", required = true) int articleno)
			throws Exception {
		logger.info("deleteArticle - 호출, 번호는 {}", articleno);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		
		try {
			int res = boardService.deleteArticle(articleno);
			if (res == 1) {
				logger.info("글 삭제 성공");
				status = HttpStatus.ACCEPTED;
				resultMap.put("msg", SUCCESS);
			} else {
				logger.info("글 삭제 실패");
				status = HttpStatus.ACCEPTED;
				resultMap.put("msg", FAIL);
			}
		} catch (Exception e) {
			logger.error("글 삭제 디비 접근실패 : { }", e);
			resultMap.put("msg", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
}