package com.xiaokang.common.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 * @Description: SqlSessionFactory工具类
 * @author 小康
 * @version V1.0.0 2019年11月28日 上午7:49:14
 */
public class SqlSessionFactoryUtils {
	private static SqlSessionFactory sqlSessionFactory;
	private static InputStream is;
	static {
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		if (sqlSessionFactory == null) {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		}
		return sqlSessionFactory;
	}

	public static SqlSession openSqlSession() {
		return getSqlSessionFactory().openSession();
	}
}
