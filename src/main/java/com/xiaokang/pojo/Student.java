package com.xiaokang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @Description: 学生实体类
 * @author 小康
 * @version V1.0.0 2019年11月28日 上午7:28:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private Integer id;
	private String name;
	private Integer age;
	private Integer status;
	private Address address;
	private Grade grade;

	public Student(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Student(Integer id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

}
