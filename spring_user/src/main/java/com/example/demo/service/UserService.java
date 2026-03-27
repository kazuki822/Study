package com.example.demo.service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserMapper;
import com.example.demo.dto.UserRequest;
import com.example.demo.entity.GenderEntity;
import com.example.demo.entity.UserEntity;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

	private static final String DUPLICATE_EMAIL_MESSAGE = "同じメールアドレスのユーザーが既に存在します。";

	/**
	 * ユーザー情報 Mapper
	 */
	private final UserMapper userMapper;

	// コンストラクタインジェクション
	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	/**
	 * ユーザー情報 全検索
	 */
	public List<UserEntity> searchAll() {
		return userMapper.findAll();
	}

	/**
	 * ユーザー情報 主キー検索
	 */
	public UserEntity findById(Integer id) {
		return userMapper.getOne(id);
	}

	/**
	 * ユーザー情報 新規登録
	 */
	public void create(UserRequest userRequest) {

		// メール重複チェック
		int emailCount = userMapper.countByEmail(userRequest.getEmail());
		if (emailCount != 0) {
			throw new IllegalArgumentException(DUPLICATE_EMAIL_MESSAGE);
		}

		// 日付生成
		Date now = new Date();

		// DTO → Entity 変換
		UserEntity user = new UserEntity();
		user.setName(userRequest.getName());
		user.setAddress(userRequest.getAddress());
		user.setPhone(userRequest.getPhone());
		user.setEmail(userRequest.getEmail());
		user.setGenderId(userRequest.getGenderId());
		user.setCreateDate(now);
		user.setUpdateDate(now);

		// 登録
		userMapper.userSave(user);
	}

	/**
	 * 性別マスタ取得（Map形式）
	 */
	public Map<Integer, String> getGenderMap() {

		List<GenderEntity> genders = userMapper.findAllGender();
		Map<Integer, String> genderMap = new LinkedHashMap<>();

		for (GenderEntity gender : genders) {
			Integer genderId = gender.getGenderId();
			String genderName = gender.getGenderName();

			if (genderId != null) {
				genderMap.put(genderId, genderName);
			}
		}

		return genderMap;
	}

	/**
	 * ユーザー情報 論理削除
	 * 
	 * @param id ユーザーID
	 */
	public void delete(Integer id) {
		userMapper.userDelete(id);
	}
}
