package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.UserEntity;

/**
 * ユーザー情報 Mapper
 */
@Mapper
public interface UserMapper {

  /**
  * ユーザー情報の全検索
  * @return
  */
  List<UserEntity> findAll();
}