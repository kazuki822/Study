package com.example.demo.entity;

import java.util.Date;

import lombok.Data;

/**
 * ユーザー情報 Entity
 */
@Data
public class UserEntity {

	/**
	 * ID
	 */
	private Integer id;

	/**
	 * 名前
	 */
	private String name;

	/**
	 * 住所
	 */
	private String address;

	/**
	 * 電話番号
	 */
	private String phone;

	/**
	 * メールアドレス
	 */
	private String email;

	/**
	 * 性別ID
	 */
	private Integer genderId;

	/**
	 * 性別名（マスタJOIN）
	 */
	private String genderName;

	/**
	 * 削除フラグ
	 */
	private Integer deleteFlg;

	/**
	 * 更新日時
	 */
	private Date updateDate;

	/**
	 * 登録日時
	 */
	private Date createDate;
}