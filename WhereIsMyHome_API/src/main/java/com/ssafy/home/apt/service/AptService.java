package com.ssafy.home.apt.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.home.apt.dto.AptDto;

public interface AptService {

	List<AptDto> infos(String dong) throws SQLException;
	int insertApt(AptDto aptDto) throws SQLException;
	int deleteApt(AptDto aptDto)  throws SQLException;
	int modifyApt(AptDto aptDto) throws SQLException;


}
