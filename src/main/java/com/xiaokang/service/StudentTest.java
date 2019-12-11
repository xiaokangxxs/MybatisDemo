package com.xiaokang.service;

import java.util.List;

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
public class StudentTest {
	private Logger logger = Logger.getLogger(StudentTest.class);
	SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
	StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

	@Test
	public void testAdd() {
		Student student = new Student("赵六", 22);
		int affectRows = studentMapper.add(student);
		if (affectRows > 0) {
			logger.info("添加成功！" + LocalDateTimeUtils.getStringByLocalDateTime());
		}
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testUpdate() {
		Student student = new Student(6, "小明", 22);
		int affectRows = studentMapper.update(student);
		if (affectRows > 0) {
			logger.info("修改成功！" + LocalDateTimeUtils.getStringByLocalDateTime());
		}
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testDelete() {
		int affectRows = studentMapper.delete(5);
		if (affectRows > 0) {
			logger.info("删除成功！" + LocalDateTimeUtils.getStringByLocalDateTime());
		}
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testFindById() {
		Student student = studentMapper.findById(5);
		if (student != null) {
			logger.info("查询成功！" + LocalDateTimeUtils.getStringByLocalDateTime());
			System.out.println(student);
		}
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testFindAll() {
		List<Student> students = studentMapper.findAll();
		if (!students.isEmpty() && students.size() > 0) {
			logger.info("查询所有用户信息成功！" + LocalDateTimeUtils.getStringByLocalDateTime());
			students.forEach((perStudent) -> {
				System.out.println(perStudent);
			});
		}
		sqlSession.commit();
		sqlSession.close();
	}

	// 无效
	@Test
	public void testFindAllWithMap() {
//		Map<String, Student> findAllWithMap = studentMapper.findAllWithMap();
//		Collection<Student> values = findAllWithMap.values();
//		values.forEach((perStudent) -> {
//			System.out.println(perStudent);
//		});
	}
}
