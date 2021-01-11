package com.example.csv;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import java.util.Date;
import lombok.Data;

/**
 * ユーザークラス.
 */
@Data
public class User {
  @CsvBindByName(column = "ユーザーID")
  private Integer userId;

  @CsvBindByName(column = "ユーザー名")
  private String userName;

  @CsvBindByName(column = "生年月日")
  @CsvDate(value = "yyyy-MM-dd")
  private Date dateOfBirth;
}
