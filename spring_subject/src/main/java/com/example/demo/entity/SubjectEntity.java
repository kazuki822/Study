package com.example.demo.entity;

import lombok.Data;

/**
* ユーザー情報 Entity
*/
@Data
public class SubjectEntity  {

  /**
   * ID
   */
  private Integer id;

  /**
   * 科目
   */
  private String subject;
}