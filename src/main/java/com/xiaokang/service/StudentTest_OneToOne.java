package com.xiaokang.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.xiaokang.common.mybatis.SqlSessionFactoryUtils;
import com.xiaokang.common.time.LocalDateTimeUtils;
import com.xiaokang.mappers.GradeMapper;
import com.xiaokang.mappers.StudentMapper;
import com.xiaokang.pojo.Grade;
import com.xiaokang.pojo.Student;

/**
 * 
 * @Description: 测试mybatis数据层
 * @author 小康
 * @version V1.0.0 2019年11月28日 上午7:56:51
 */
public class StudentTest_OneToOne {
	private Logger logger = Logger.getLogger(StudentTest_OneToOne.class);
	SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
	StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
	GradeMapper gradeMapper = sqlSession.getMapper(GradeMapper.class);

	/*
	 * @Test public void testFindStudentWithAddress() { Student
	 * findStudentWithAddress = studentMapper.findStudentWithAddress(5); if
	 * (findStudentWithAddress != null) { logger.info("查询指定用户信息成功！" +
	 * LocalDateTimeUtils.getStringByLocalDateTime());
	 * System.out.println(findStudentWithAddress); } sqlSession.commit();
	 * sqlSession.close(); }
	 */

	@Test
	public void testFindAllStudent() {
		List<Student> students = studentMapper.findAll();
		if (!students.isEmpty() && students.size() > 0) {
			logger.info("查询所有用户信息成功(带地址)！" + LocalDateTimeUtils.getStringByLocalDateTime());
			students.forEach((perStudent) -> {
				System.out.println(perStudent);
			});
		}
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testFindGradeWithStudents() {
		Grade grade = gradeMapper.findById(1);
		if (grade != null) {
			logger.info("查询年级下所有学生信息成功(带地址)！" + LocalDateTimeUtils.getStringByLocalDateTime());
			System.out.println(grade);
			// 打印该年级下所有的学生信息
			List<Student> students = grade.getStudents();
			students.forEach((perStudent) -> {
				System.out.println(perStudent);
			});
		}
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testFindStudentWithAddressAndGrade() {
		Student findStudentWithAddress = studentMapper.findStudentWithAddressAndGrade(6);
		if (findStudentWithAddress != null) {
			logger.info("查询指定用户信息成功(带地址和年级)！" + LocalDateTimeUtils.getStringByLocalDateTime());
			System.out.println(findStudentWithAddress);
		}
		sqlSession.commit();
		sqlSession.close();
	}
}
