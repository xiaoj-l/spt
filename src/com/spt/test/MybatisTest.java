package com.spt.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.spt.controller.TProjectScheduleInfoController;

public class MybatisTest extends BaseTest{
	
	@Autowired
	private TProjectScheduleInfoController tProjectScheduleService;
	
	@Test
	public void testMybatisTest(){
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("year", "2016");
		map.put("projectId", "0001");
//		System.out.println(tProjectScheduleService.getProjectInfoList(map));
	}
}
