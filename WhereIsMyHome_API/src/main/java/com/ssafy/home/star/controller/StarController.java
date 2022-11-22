package com.ssafy.home.star.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.ssafy.home.star.dto.service.StarDto;
import com.ssafy.home.star.service.StarService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


//http://localhost:9999/vue/swagger-ui.html
@RestController
@RequestMapping("/star")
@Api("즐겨찾기 컨트롤러 ")
@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.POST} , maxAge = 6000)
public class StarController {

	private static final Logger logger = LoggerFactory.getLogger(StarController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	StarService service;
	
	@Autowired
	public StarController(StarService service) {
		logger.info("즐겨찾기 컨트롤러 호출");
		this.service = service;
	}
	
	
	/* -------------------------- 즐겨찾기 등록 -------------------------- */

	
	
	@ApiOperation(value = "즐겨찾기 등록", notes = "새로운 즐겨찾기 등록. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<Map<String, Object>> registStar(
			@RequestBody @ApiParam(value = "즐겨찾기 정보", required = true) StarDto starDto) throws Exception {
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		HttpStatus status = null;
		
		try {
			int res = service.registStar(starDto);
			
			logger.info("registStar - 호출");
			if (res == 1) {
				resMap.put("msg", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}
			else {
				resMap.put("msg", FAIL);
				status = HttpStatus.NO_CONTENT;
			}
			
		} catch (Exception e) {
			logger.error("즐겨찾기 등록 실패 : {}", e);
			resMap.put("msg", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		
		return new ResponseEntity<Map<String, Object>>(resMap, status);
	}
	
	


	
	/* -------------------------- 즐겨찾기 목록 조회-------------------------- */

	
 
	@ApiOperation(value = "즐겨찾기 목록", notes = "즐겨찾기 정보를 반환한다.", response = List.class)
	@GetMapping("/{userid}")
	public ResponseEntity<Map<String, Object>> listStar(
			@PathVariable("aptCode") @ApiParam(value = "아파트 번호", required = true) String userid) throws Exception {
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		HttpStatus status = null;
//		List<StarDto> starList = null;
		List<String> starList = null;
	
		try {			
			logger.info("listStar - 호출");
			starList = service.getStarList(userid);
			System.out.println(">>>>>즐겨찾기 목록 사이즈 : " + starList.size());
			
			if(starList != null && starList.size() > 0) {
				resMap.put("starList", starList);
				resMap.put("msg", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}
			else {
				resMap.put("msg", "즐겨찾기 결과가 없습니다.");
				status = HttpStatus.ACCEPTED;
			}
			
			
		} catch (Exception e) {
			logger.error("즐겨찾기 조회 실패 : {}", e);
			resMap.put("msg", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		
		return new ResponseEntity<Map<String, Object>>(resMap, status);
	}
		
	
	
	/* -------------------------- 즐겨찾기 삭제 -------------------------- */

	
	@ApiOperation(value = "즐겨찾기 삭제", notes = "글번호에 해당하는 댓글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping
	public ResponseEntity<Map<String, Object>> deleteStar(
			@RequestBody @ApiParam(value = "삭제할 즐겨찾기 정보", required = true) StarDto starDto) throws Exception {
			
		Map<String, Object> resMap = new HashMap<String, Object>();
		HttpStatus status = null;	
		
		try {
			
			logger.info("deleteStar - 호출");
			
			int res = service.deleteStar(starDto);
			
			if (res == 1) {
				resMap.put("msg", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}
			else {
				resMap.put("msg", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("줄겨찾기 삭제 실패 : {}", e);
			resMap.put("msg", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resMap, status);
	}
		
	
	
	
	
}