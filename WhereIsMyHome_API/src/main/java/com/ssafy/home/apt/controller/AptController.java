package com.ssafy.home.apt.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.home.apt.dto.AptDto;
import com.ssafy.home.apt.service.AptService;
import com.ssafy.home.user.controller.UserController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



@RestController
@RequestMapping("/apt")
@Api("Apt 컨드롤러")
public class AptController {
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	
	private AptService service;	
	
	
	@Autowired
	public AptController(AptService service) {
		logger.info("appart 생성자 호출");
		this.service = service;
	}
	
	
	//********************* 아파트 리스트 불러오기 ************************/
	
	
	@ApiOperation(value="아파트 리스트 조회", notes = "지역코드에 맞는 저장된 아파트 리스트를 불러온다")
	@GetMapping("/{regCode}")
	public ResponseEntity<Map<String, Object>> getList(@PathVariable("regCode") @ApiParam(value="얻어올 지역 번호", required = true) String regCode)  {
		
		logger.info("getList - 호출");
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		
		List<AptDto> aptList;
		
		try {
			
			aptList = service.getList(regCode);		
			
			System.out.println(aptList);
			resultMap.put("aptList", aptList);
			resultMap.put("msg", SUCCESS);
			status = HttpStatus.ACCEPTED;
			
		} catch (SQLException e) {
			logger.error("리스트 호출실패 : { }", e);
			resultMap.put("msg", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	
	//********************* 아파트 매물 올리기 ************************/
	
	
	@ApiOperation(value = "아파트 매물 업로드", notes = "새로운 매물 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<Map<String, Object>> insertApt(@RequestBody @ApiParam(value = "게시글 정보.", required = true) AptDto aptDto)  {
	

		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		
		try {
			logger.info("insertApt - 호출");
			
			logger.info("apt 정보"+aptDto);
			int res = service.insertApt(aptDto);

			if (res == 1) {				
				logger.info("매물 정보 등록 성공");
				status = HttpStatus.ACCEPTED;
				resultMap.put("msg", SUCCESS);		
			}
			else {
				logger.info("매물 정보 등록 실패");
				status = HttpStatus.ACCEPTED;
				resultMap.put("msg", FAIL);	
			}
			
			
		} catch (SQLException e) {
			logger.error("insertApt 호출실패 : { }", e);
			resultMap.put("msg", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
		
	}
		
	
	
	
	//********************* 아파트 매물 삭제 *************************/
	
	//삭제할때 어떤 파라미터 받아와서 해당 매물을 삭제할건지? 추후 수정

	@ApiOperation(value = "아파트 매물 삭제", notes = "(...)에 해당하는 매물을 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping
	public ResponseEntity<Map<String, Object>> deleteApt(@RequestBody @ApiParam(value="삭제할 매물 정보", required=true) AptDto aptDto) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		
		try {
			logger.info("deleteApt - 호출");
			
			int res = service.deleteApt(aptDto);
			if (res == 1) {
				logger.info("매물 정보 삭제 성공");
				status = HttpStatus.ACCEPTED;
				resultMap.put("msg", SUCCESS);		
			}
			else { 
				logger.info("매물 정보 삭제 실패");
				status = HttpStatus.ACCEPTED;
				resultMap.put("msg", FAIL);	
			}
			
		} catch (SQLException e) {
			logger.error("deleteApt 호출실패 : { }", e);
			resultMap.put("msg", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	
	
	//********************* 아파트 매물 수정  ************************/
	

	@ApiOperation(value = "매물 수정", notes = "수정할 매물 정보를 입력한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping
	public ResponseEntity<Map<String, Object>> modifyApt(@RequestBody @ApiParam(value = "수정할 글정보.", required = true)  AptDto aptDto) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;		
		
		try {
			
			logger.info("modifyApt - 호출 {}",  aptDto);
			
			int res = service.modifyApt(aptDto);
			if (res == 1) {
				logger.info("매물 정보 수정 성공");
				status = HttpStatus.ACCEPTED;
				resultMap.put("msg", SUCCESS);	
			}
			else { 
				logger.info("매물 정보 수정 실패");
				status = HttpStatus.ACCEPTED;
				resultMap.put("msg", FAIL);	
			}
			
		} catch (SQLException e) {
			logger.error("modifyApt 호출실패 : { }", e);
			resultMap.put("msg", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	

}
