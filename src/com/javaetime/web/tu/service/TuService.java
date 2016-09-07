package com.javaetime.web.tu.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface TuService {
	public List<String[]> queryzhu() throws ClassNotFoundException, SQLException;
	public Map<String, Object> queryBing() throws ClassNotFoundException, SQLException;
}
