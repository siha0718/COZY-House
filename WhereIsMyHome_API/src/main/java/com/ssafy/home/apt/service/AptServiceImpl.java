package com.ssafy.home.apt.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.home.apt.dao.AptDao;
import com.ssafy.home.apt.dto.AptDto;

@Service
public class AptServiceImpl implements AptService{

	private AptDao dao;
	
	@Autowired
	public AptServiceImpl(AptDao dao) {
		this.dao = dao;
	}
	
	@Override
	public List<AptDto> getList(String regCode) throws SQLException {
		return dao.getList(regCode);
	}


	@Override
	public int insertApt(AptDto aptDto) throws SQLException {
		return dao.insertApt(aptDto);
	}


	@Override
	public int deleteApt(AptDto aptDto) throws SQLException {
		return dao.deleteApt(aptDto);
	}


	@Override
	public int modifyApt(AptDto aptDto) throws SQLException {
		return dao.modifyApt(aptDto);
	}


	
}
