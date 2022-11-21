package com.ssafy.home.comment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.home.comment.dto.CommentDto;
import com.ssafy.home.comment.service.CommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


//http://localhost:9999/vue/swagger-ui.html
@RestController
@RequestMapping("/comment")
@Api("댓글 컨트롤러 ")
@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.POST} , maxAge = 6000)
public class CommentController {

	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	CommentService service;
	
	@Autowired
	public CommentController(CommentService service) {
		logger.info("댓글 컨트롤러 호출");
		this.service = service;
	}
	
	
	/* -------------------------- 댓글 작성 -------------------------- */

	
	
	@ApiOperation(value = "댓글 작성", notes = "새로운 댓글을 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping("/{aptCode}")
	public ResponseEntity<Map<String, Object>> writeComment(
			@RequestBody @ApiParam(value = "댓글 정보", required = true) CommentDto commentDto, 
			@PathVariable @ApiParam(value = "아파트 번호", required = true) int aptCode) throws Exception {
		Map<String, Object> resMap = new HashMap<String, Object>();
		HttpStatus status = null;
		
		try {
			commentDto.setAptCode(aptCode);
			int res = service.registerComment(commentDto);
			
			logger.info("writeComment - 호출");
			if (res == 1) {
				resMap.put("msg", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}
			else {
				resMap.put("msg", FAIL);
				status = HttpStatus.NO_CONTENT;
			}
			
		} catch (Exception e) {
			logger.error("댓글 등록 실패 : {}", e);
			resMap.put("msg", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		
		return new ResponseEntity<Map<String, Object>>(resMap, status);
	}
	
	

	/* -------------------------- 댓글 수정 -------------------------- */

	
	
	@ApiOperation(value = "댓글수정", notes = "수정할 댓글정보를 입력한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("/{aptCode}/{cmno}")
	public ResponseEntity<Map<String, Object>> modifyComment(
			@RequestBody @ApiParam(value = "수정할 글정보.", required = true) CommentDto commentDto,
			@PathVariable @ApiParam(value = "수정할 댓글의 아파트 정보", required = true) int aptCode,
			@PathVariable @ApiParam(value = "댓글 번호", required = true) int cmno) throws Exception {
			
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		HttpStatus status = null;	
		commentDto.setCmno(cmno);
		commentDto.setAptCode(aptCode);
		
		try {
			logger.info("modifyComment - 호출 {}", commentDto);
			int res = service.modifyComment(commentDto);
			
			if (res == 1) {
				resMap.put("msg", SUCCESS);
				status = HttpStatus.ACCEPTED;	
			}
			else { 
				resMap.put("msg", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("댓글 수정 실패 : {}", e);
			resMap.put("msg", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<Map<String, Object>>(resMap, status);
	}
	
	
	
	/* -------------------------- 댓글 목록 조회-------------------------- */

	
 
	@ApiOperation(value = "댓글목록", notes = "댓글의 정보를 반환한다.", response = List.class)
	@GetMapping("/{aptCode}")
	public ResponseEntity<Map<String, Object>> listComment(
			@PathVariable("aptCode") @ApiParam(value = "아파트 번호", required = true) int aptCode) throws Exception {
		Map<String, Object> resMap = new HashMap<String, Object>();
		HttpStatus status = null;
		List<CommentDto> commentList = null;
	
		try {			
			logger.info("listComment - 호출");
			commentList = service.getCommentList(aptCode);
			System.out.println(">>>>>댓글목록 사이즈 : " + commentList.size());
			
			if(commentList != null && commentList.size() > 0) {
				resMap.put("commentList", commentList);
				resMap.put("msg", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}
			else {
				resMap.put("msg", "댓글이 없습니다.");
				status = HttpStatus.ACCEPTED;
			}
			
			
		} catch (Exception e) {
			logger.error("댓글 조회 실패 : {}", e);
			resMap.put("msg", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		
		return new ResponseEntity<Map<String, Object>>(resMap, status);
	}
	
	
	
	
	/* -------------------------- 댓글 내용 조회 -------------------------- */

	
	
	@ApiOperation(value = "댓글보기", notes = "글번호에 해당하는 댓글의 정보를 반환한다.", response = CommentDto.class)
	@GetMapping("/{aptCode}/{cmno}")
	public ResponseEntity<Map<String, Object>> getComment(
			@PathVariable("aptCode") @ApiParam(value = "얻어올 글의 글번호.", required = true) int aptCode,
			@PathVariable("cmno") @ApiParam(value = "댓글 번호", required = true) int cmno) throws Exception {
				
		Map<String, Object> resMap = new HashMap<String, Object>();
		HttpStatus status = null;
		CommentDto comment = null;
		
		try {
			
			logger.info("getComment - 호출 : " + aptCode);
			comment = service.getComment(aptCode, cmno);
			if(comment != null) {
				resMap.put("msg", SUCCESS);
				resMap.put("article", comment);
				status = HttpStatus.ACCEPTED;
			}
			else {
				resMap.put("msg", FAIL);
				status = HttpStatus.ACCEPTED;
				
			}
			
		} catch (Exception e) {
			logger.error("댓글 조회 실패 : {}", e);
			resMap.put("msg", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String, Object>>(resMap, status);
	}
	
	
	
	/* -------------------------- 댓글 삭제 -------------------------- */

	
	@ApiOperation(value = "댓글삭제", notes = "글번호에 해당하는 댓글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/{aptCode}/{cmno}")
	public ResponseEntity<Map<String, Object>> deleteComment(
			@PathVariable("aptCode") @ApiParam(value = "삭제할 댓글의 글번호.", required = true) int aptCode, 
			@PathVariable("cmno") @ApiParam(value = "댓글번호.", required = true) int cmno) throws Exception {
			
		Map<String, Object> resMap = new HashMap<String, Object>();
		HttpStatus status = null;	
		
		try {
			
			logger.info("deleteComment - 호출");
			
			int res = service.deleteComment(aptCode, cmno);
			
			if (res == 1) {
				resMap.put("msg", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}
			else {
				resMap.put("msg", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("댓글 삭제 실패 : {}", e);
			resMap.put("msg", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resMap, status);
	}
		
	
	
	
	
}