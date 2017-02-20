package com.spt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spt.service.TProjectScheduleService;

@Controller
@Repository
public class TProjectScheduleInfoController {
	
	private static final Logger logger = LoggerFactory.getLogger(TProjectScheduleInfoController.class);
	@Autowired
	private TProjectScheduleService tProjectScheduleService;
	
	/*@RequestMapping(value="getProjectInfoList.do")
	@ResponseBody
	public String getProjectInfoList(Map<String,Object> map){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> searchMap = new HashMap<String,Object>();
		
		ObjectMapper mapper = new ObjectMapper();
		list = tProjectScheduleService.getProjectScheduleInfoList(map);
		searchMap.put("results", list);
		searchMap.put("total", 20);
		String json =null;
		try {
			json = mapper.writeValueAsString(searchMap);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} 
		logger.info(" result is " + json);
		return json;
	}*/
	
	@RequestMapping(value="getProjectInfoList.do")
	@ResponseBody
	public void getProjectInfoList(HttpServletRequest request,HttpServletResponse response,Model model){
		
		Map<String,Object> searchMap = new HashMap<String,Object>();
		Map<String,Object> map = new HashMap<String,Object>();
		
		/*int pageNo = Integer.parseInt(request.getParameter("page") == null ?"1":request.getParameter("page"));
		int pageSize  =Integer.parseInt(request.getParameter("rows"));
		
		int beginRow = (pageNo-1)*pageSize;
		int endRow = beginRow + pageSize;
		
		map.put("pageNo", pageNo);
		map.put("pageSize", pageSize);
		map.put("beginRow", beginRow);
		map.put("endRow", endRow);*/
		
		List<Map<String,Object>> list = tProjectScheduleService.getProjectScheduleInfoList(map);
		if(list != null && list.size() != 0){
			searchMap.put("results", list);
			searchMap.put("total", 20);
			ObjectMapper mapper = new ObjectMapper();
			String json =null;
			try {
				json = mapper.writeValueAsString(searchMap);
				logger.info(" result is " + json);
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().write(json.toString());
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
}
