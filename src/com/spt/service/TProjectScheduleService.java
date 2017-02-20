package com.spt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spt.dao.TProjectScheduleDao;

@Repository
public class TProjectScheduleService implements BaseService{
	private static final Logger logger = LoggerFactory.getLogger(TProjectScheduleService.class);
	 
	@Autowired
	private TProjectScheduleDao tProjectScheduleDao;
	
	public List<Map<String,Object>> getProjectScheduleInfoList(Map<String,Object> map){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try{
			list = tProjectScheduleDao.getProjectScheduleInfoList(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
