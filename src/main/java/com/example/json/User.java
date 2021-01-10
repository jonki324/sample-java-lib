package com.example.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * ユーザークラス.
 */
@Data
public class User {
  @JsonProperty("user_id")
  private Integer userId;

  @JsonProperty("user_name")
  private String userName;

  @JsonProperty("date_of_birth")
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonSerialize(using = LocalDateSerializer.class)
  private LocalDate dateOfBirth;

  @JsonProperty("mail_list")
  private List<String> mailList = new ArrayList<>();

  public void addMail(String mail) {
    mailList.add(mail);
  }
}
