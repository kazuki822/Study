package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.SubjectEntity;

/**
* 科目情報 Mapper
*/
@Mapper
public interface SubjectMapper {

    /**
     * 科目情報 全検索
     * @return
     */
    List<SubjectEntity> findAll();

    /**
     * 科目情報 新規登録
     * @param subject 科目情報
     */
    void save(SubjectEntity subject);
    /**
     * 科目情報 主キー検索
     * @param id 主キー
     * @return
     */
    SubjectEntity getOne(Integer id);

    /**
     * 科目情報 更新
     * @param subject
     */
    void editUpdate(SubjectEntity subject);

    /**
     * 科目情報 物理削除
     * @param subject 科目情報
     */
    void delete(SubjectEntity subject);
}
