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
import org.springframework.web.bind.annotation.RequestParam;
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
	@PostMapping
	public ResponseEntity<Map<String, Object>> writeComment(
			@RequestBody @ApiParam(value = "댓글 정보", required = true) CommentDto commentDto) throws Exception {
		Map<String, Object> resMap = new HashMap<String, Object>();
		HttpStatus status = null;
		logger.info("writeComment - 호출");
		logger.info("받은 정보 -" + commentDto);
		try {
			int res = service.writeComment(commentDto);
			
			logger.info("writeComment - 호출");
			if (res == 1) {
				resMap.put("msg", SUCCESS);
				resMap.put("cmNum", commentDto.getCmNum());
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
	@PutMapping
	public ResponseEntity<Map<String, Object>> modifyComment(
			@RequestBody @ApiParam(value = "수정할 글정보.", required = true) CommentDto commentDto) throws Exception {
			
		Map<String, Object> resMap = new HashMap<String, Object>();
		HttpStatus status = null;	
		logger.info("modifyComment - 호출 {}", commentDto);
		
		try {
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
	@GetMapping
	public ResponseEntity<Map<String, Object>> getCommentList(
			@RequestParam @ApiParam(value = "집 고유 번호", required = true) String houseCode,
			@RequestParam @ApiParam(value = "유저아이디", required = true) String userid) throws Exception {
		Map<String, Object> resMap = new HashMap<String, Object>();
		HttpStatus status = null;
		logger.info("listComment - 호출");
		
		List<CommentDto> commentList = null;
		Map<String, String> map = new HashMap<String, String>();
		map.put("houseCode", houseCode);
		map.put("userid", userid);
		try {
			commentList = service.getCommentList(map);
			System.out.println(">>>>>댓글목록 사이즈 : " + commentList.size());
			
			resMap.put("commentList", commentList);
			resMap.put("msg", SUCCESS);
			status = HttpStatus.ACCEPTED;
			
		} catch (Exception e) {
			logger.error("댓글 조회 실패 : {}", e);
			resMap.put("msg", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		
		return new ResponseEntity<Map<String, Object>>(resMap, status);
	}
	
	
	
	/* -------------------------- 댓글 삭제 -------------------------- */

	
	@ApiOperation(value = "댓글삭제", notes = " 해당하는 댓글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping
	public ResponseEntity<Map<String, Object>> deleteComment(
			@RequestBody @ApiParam(value = "수정할 글정보.", required = true) String cmNum) throws Exception {
			
		Map<String, Object> resMap = new HashMap<String, Object>();
		HttpStatus status = null;	
		logger.info("deleteComment - 호출 {}" + cmNum);
		
		try {
			int res = service.deleteComment(Integer.parseInt(cmNum));
			
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