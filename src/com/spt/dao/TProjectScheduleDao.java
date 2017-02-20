package com.spt.dao;

import java.util.List;
import java.util.Map;

public interface TProjectScheduleDao {
	
	public List<Map<String,Object>> getProjectScheduleInfoList(Map<String,Object> map);
}
