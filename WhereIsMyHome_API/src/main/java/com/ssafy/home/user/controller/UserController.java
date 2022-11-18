package com.ssafy.home.user.controller;

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

import com.ssafy.home.user.dto.UserDto;
import com.ssafy.home.user.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
@Api("사용자 컨트롤러")
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		logger.info("UserController 생성자 호출");
		this.userService = userService;
	}
	
	
	@GetMapping("/list/{userid}")
	@ApiOperation(value = "admin 일때만 모든 사용자 정보 반환", response = Map.class)
	public ResponseEntity<Map<String, Object>> userList(
			@PathVariable("userid") @ApiParam(value = "호출 아이디", required = true) String userid){
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			int loginClass = userService.getclass(userid);
			if(loginClass == 0) { //admin 계정
				logger.info("admin class 확인");
				List<UserDto> users = userService.selectAll();
				logger.info("userList "+users.size()+" (개) 반환");
				resultMap.put("users", users);
				resultMap.put("msg", SUCCESS);
			}
			else {
				logger.info("admin class 아님");
				resultMap.put("msg", FAIL);
			}
			status= HttpStatus.ACCEPTED;
		} catch (Exception e) {
			logger.error("리스트 호출 실패 : {}",e);
			resultMap.put("msg", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@ApiOperation(value = "회원가입", notes="회원가입 결과 메세지", response = Map.class)
	@PostMapping("/regist")
	public ResponseEntity<Map<String, Object>> userRegist(
			@RequestBody @ApiParam(value = "회원가입 시 필요한 회원정보(UserDto).", required = true) UserDto user){
	
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		logger.info("넘어온 User info : {}", user);
		
		try {
			int cnt = userService.countId(user.getUserid());
			if(cnt==0) {
				user.setUserclass(1); //일반회원
				int ret = userService.regist(user);
				if(ret == 1) {
					logger.info("회원가입 DB저장 성공");
					status = HttpStatus.ACCEPTED;
					resultMap.put("msg", SUCCESS);
				}
				else {
					logger.info("회원가입 DB저장 실패");
					status = HttpStatus.ACCEPTED;
					resultMap.put("msg", FAIL);
				}
			}
			else {
				logger.info("이미 있는  ID");
				status = HttpStatus.ACCEPTED;
				resultMap.put("msg", "duplicated");
			}
		} catch (Exception e) {
			logger.error("리스트 호출 실패 : {}",e);
			resultMap.put("msg", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	
	@ApiOperation(value = "로그인", notes="로그인 결과 메세지", response = Map.class)
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> userLogin(
			@RequestBody @ApiParam(value = "로그인 시 필요한 회원정보(UserDto).", required = true) UserDto user) {
		
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		logger.info("넘어온 User info : {}", user);
		
		try {
			UserDto loginUser = userService.login(user);
			if(loginUser != null) {
				logger.info("로그인 DB접근, 비밀번호 확인 성공");
				status = HttpStatus.ACCEPTED;
				resultMap.put("msg", SUCCESS);
			}
			else {
				logger.info("일치하는 회원 정보 없음");
				status = HttpStatus.ACCEPTED;
				resultMap.put("msg", FAIL);				
			}
		} catch (Exception e) {
			logger.error("로그인 호출 실패 : {}",e);
			resultMap.put("msg", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	
	@GetMapping("/{userid}")
	@ApiOperation(value = "로그인 유저 정보 반환", response = Map.class)
	public ResponseEntity<Map<String, Object>> userInfo(
			@PathVariable("userid") @ApiParam(value = "얻어올 글의 글번호.", required = true) String userid){
		
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		logger.info("찾는 user id : {}", userid);
		
		try {
			UserDto user = userService.userinfo(userid);
			if(user != null) {
				logger.info("유저 정보 DB접근  성공");
				status = HttpStatus.ACCEPTED;
				resultMap.put("msg", SUCCESS);
				resultMap.put("userinfo", user);
			}
			else {
				logger.info("일치하는 회원 정보 없음");
				status = HttpStatus.ACCEPTED;
				resultMap.put("msg", FAIL);				
			}
		} catch (Exception e) {
			logger.error("유저 정보 호출 실패 : {}",e);
			resultMap.put("msg", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@DeleteMapping
	@ApiOperation(value = "사용자 정보를 삭제한다.", response = Map.class)
	public ResponseEntity<Map<String, Object>> userDelete(
			@RequestBody @ApiParam(value = "회원 삭제 시 필요한 회원정보(UserDto).", required = true) UserDto user) {
		
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		logger.info("넘어온 User info : {}", user);
		
		try {
			int ret = userService.delete(user);
			if(ret == 1) {
				logger.info("회원삭제  DB저장 성공");
				status = HttpStatus.ACCEPTED;
				resultMap.put("msg", SUCCESS);
			}
			else {
				logger.info("회원삭제 DB저장 실패");
				status = HttpStatus.ACCEPTED;
				resultMap.put("msg", FAIL);
			}
		} catch (Exception e) {
			logger.error("삭제 호출 실패 : {}",e);
			resultMap.put("msg", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	
	
	@PutMapping
	@ApiOperation(value = "사용자 정보를 수정한다.", response = Map.class)
	public ResponseEntity<Map<String, Object>> userModify(
			@RequestBody @ApiParam(value = "회원 수정 시 필요한 회원정보(User).", required = true)UserDto user) {
		
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		logger.info("넘어온 User info : {}", user);

		try {
			int ret = userService.modify(user);
			if(ret == 1) {
				logger.info("회원수정  DB저장 성공");
				status = HttpStatus.ACCEPTED;
				resultMap.put("msg", SUCCESS);
			}
			else {
				logger.info("회원수정 DB저장 실패");
				status = HttpStatus.ACCEPTED;
				resultMap.put("msg", FAIL);
			}
		} catch (Exception e) {
			logger.error("수정 호출 실패 : {}",e);
			resultMap.put("msg", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
}
