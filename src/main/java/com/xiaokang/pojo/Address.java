package com.xiaokang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @Description: 住址实体类
 * @author 小康
 * @version V1.0.0 2019年11月28日 上午8:33:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	private Integer id;
	private String sheng;
	private String shi;
	private String qu;

}
