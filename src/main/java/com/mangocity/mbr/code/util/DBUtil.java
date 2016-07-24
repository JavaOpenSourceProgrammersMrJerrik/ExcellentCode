package com.mangocity.mbr.code.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

public class DBUtil {

	// 更新（包括 UPDATE、INSERT、DELETE，返回受影响的行数）
	public static int update(QueryRunner runner, Connection conn, String sql, Object... params) {
		int result = 0;
		try {
			if (conn != null) {
				result = runner.update(conn, sql, params);
			} else {
				result = runner.update(sql, params);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
