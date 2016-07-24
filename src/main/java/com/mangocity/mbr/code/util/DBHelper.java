package com.mangocity.mbr.code.util;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;

public class DBHelper {
	private static final BasicDataSource ds = new BasicDataSource();
	private static final QueryRunner runner = new QueryRunner(ds);

	/**
	 * 定义一个局部线程变量（使每个线程都拥有自己的连接）
	 */
	private static ThreadLocal<Connection> connContainer = new ThreadLocal<Connection>();

	static {
		// 初始化数据源
		ds.setDriverClassName(ConfigHelper.getStringValue("jdbc.driver"));
		ds.setUrl(ConfigHelper.getStringValue("jdbc.url"));
		ds.setUsername(ConfigHelper.getStringValue("jdbc.username"));
		ds.setPassword(ConfigHelper.getStringValue("jdbc.password"));
		ds.setMaxActive(ConfigHelper.getIntValue("jdbc.max.active"));
		ds.setMaxIdle(ConfigHelper.getIntValue("jdbc.max.idle"));
	}

	// 获取数据源
	public static DataSource getDataSource() {
		return ds;
	}

	// 开启事务
	public static void beginTransaction() {
		Connection conn = connContainer.get();
		if (conn == null) {
			try {
				conn = ds.getConnection();
				conn.setAutoCommit(false);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				connContainer.set(conn);
			}
		}
	}

	// 提交事务
	public static void commitTransaction() {
		Connection conn = connContainer.get();
		if (conn != null) {
			try {
				conn.commit();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				connContainer.remove();
			}
		}
	}

	// 回滚事务
	public static void rollbackTransaction() {
		Connection conn = connContainer.get();
		if (conn != null) {
			try {
				conn.rollback();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				connContainer.remove();
			}
		}
	}

	// 执行更新（包括 UPDATE、INSERT、DELETE）
	public static int update(String sql, Object... params) {
		// 若当前线程中存在连接，则传入（用于事务处理），否则将从数据源中获取连接
		Connection conn = connContainer.get();
		return DBUtil.update(runner, conn, sql, params);
	}
}