package com.multicampus.biz.util;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactoryBean {
	private static SqlMapClient sqlMapClient = null;
	static {
		Reader reader = null;
		try {
			if (sqlMapClient == null) {
				String configFile = "sql-map-config(ibatis).xml";
				reader = Resources.getResourceAsReader(configFile);
				sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static SqlMapClient getSqlMapClientInstance() {
		return sqlMapClient;
	}
}