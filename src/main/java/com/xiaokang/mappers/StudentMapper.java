package com.xiaokang.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.xiaokang.pojo.Student;

public interface StudentMapper {
	int add(Student student);

	int update(Student student);

	int delete(Integer id);

	Student findById(Integer id);

	List<Student> findAll();

	// Map<String, Student> findAllWithMap();

	Student findStudentWithAddressAndGrade(Integer id);

	Student findByGradeId(Integer gradeId);

	List<Student> findStudents(RowBounds rowBounds);

	int studentTotalCount();

	List<Student> findStudents2(Map<String, Object> map);
}
