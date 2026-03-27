package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.GenderEntity;
import com.example.demo.entity.UserEntity;

/**
 * ユーザー情報 Mapper
 */
@Mapper
public interface UserMapper {

	/**
	 * ユーザー情報の全検索
	 * 
	 * @return
	 */
	List<UserEntity> findAll();

	/**
	 * ユーザー情報 主キー検索
	 * 
	 * @param id ユーザーID
	 * @return
	 */
	UserEntity getOne(Integer id);

	/**
	 * ユーザー情報 新規登録
	 *
	 * @param user ユーザー情報
	 */
	void userSave(UserEntity user);

	/**
	 * 性別マスタを取得
	 *
	 * @return 性別マスタ
	 */
	List<GenderEntity> findAllGender();

	/**
	 * メールアドレスの重複件数
	 *
	 * @param email メールアドレス
	 * @return 件数
	 */
	int countByEmail(@Param("email") String email);

	/**
	 * ユーザー情報 論理削除
	 *
	 * @param id ユーザーID
	 */
	void userDelete(Integer id);
}
