package com.javaetime.web.tu.dao;

import java.sql.SQLException;
import java.util.Map;

public interface TuDao {
	/**
     * 根据sql查询列表数据(查询一条)，不支持预编译的方式
     * @param sql
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Map<String, Object> executeQueryForMap(String sql) throws ClassNotFoundException, SQLException;
    /**
     * 根据sql查询列表数据(查询一条)，不支持预编译的方式
     * @param sql
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int executeQueryForInt(String sql ) throws ClassNotFoundException, SQLException ;
}
