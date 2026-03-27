package com.example.demo.entity;

import lombok.Data;

/**
 * 性別マスタ Entity
 */
@Data
public class GenderEntity {

	/**
	 * 性別ID
	 */
	private Integer genderId;

	/**
	 * 性別名
	 */
	private String genderName;
}
