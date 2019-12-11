package com.xiaokang.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @Description: 年级实体类
 * @author 小康
 * @version V1.0.0 2019年11月28日 上午10:11:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
	private Integer id;
	private String gradeName;
	private List<Student> students;

	public String toString() {
		return "Grade [id=" + id + ",gradeName=" + gradeName + "]";
	}
}
