package com.example.demo.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Data;

/**
* 科目情報 リクエストデータ
*/
@Data
public class SubjectForm {
 /**
  * ID
  */
 private Integer id;
  /**
  * 科目
  */
 @NotEmpty(message = "科目を入力してください")
 @Size(max = 50, message = "科目は50文字以内で入力してください")
 private String subject;

}
