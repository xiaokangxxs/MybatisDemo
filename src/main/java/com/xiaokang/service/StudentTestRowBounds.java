package com.xiaokang.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.xiaokang.common.mybatis.SqlSessionFactoryUtils;
import com.xiaokang.common.time.LocalDateTimeUtils;
import com.xiaokang.mappers.StudentMapper;
import com.xiaokang.pojo.Student;

/**
 * 
 * @Description: 测试mybatis数据层
 * @author 小康
 * @version V1.0.0 2019年11月28日 上午7:56:51
 */
public class StudentTestRowBounds {
	private Logger logger = Logger.getLogger(StudentTestRowBounds.class);
	SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
	StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

	// 逻辑分页（先将所有记录放到内存中，再查询指定的记录）
	@Test
	public void testFindStudents() {
		// offset为要显示的第一条记录的下标，limit为记录数量
		int offset = 3, limit = 3;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Student> students = studentMapper.findStudents(rowBounds);
		if (!students.isEmpty() && students.size() > 0) {
			logger.info("查询所有用户信息成功！" + LocalDateTimeUtils.getStringByLocalDateTime());
			students.forEach((perStudent) -> {
				System.out.println(perStudent);
			});
		}
		sqlSession.commit();
		sqlSession.close();
	}

	// 物理分页（开发常用）
	@Test
	public void testFindStudents2() {
		// start为要显示的第一条记录的下标，size为记录数量
		Map<String, Object> map = new HashMap<String, Object>(0);
		map.put("start", 0);
		map.put("size", 5);
		List<Student> students = studentMapper.findStudents2(map);
		if (!students.isEmpty() && students.size() > 0) {
			logger.info("查询前5条用户信息成功！" + LocalDateTimeUtils.getStringByLocalDateTime());
			students.forEach((perStudent) -> {
				System.out.println(perStudent);
			});
		}
		sqlSession.commit();
		sqlSession.close();
	}

	// 总记录数
	@Test
	public void testTotalCount() {
		int studentTotalCount = studentMapper.studentTotalCount();
		logger.info("查询所有总记录数成功！" + LocalDateTimeUtils.getStringByLocalDateTime());
		System.out.println("总记录数:" + studentTotalCount);
		sqlSession.commit();
		sqlSession.close();
	}
}
