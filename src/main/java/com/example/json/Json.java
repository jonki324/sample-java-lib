package com.example.json;

import com.example.common.Command;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.ResourceBundle;
import lombok.extern.slf4j.Slf4j;

/**
 * Jackson使い方.
 */
@Slf4j
public class Json implements Command {
  @Override
  public void execute() {
    readJsonString();
    writeJsonString();
  }

  private void readJsonString() {
    try {
      String json = ResourceBundle.getBundle("app").getString("JSON_USER");

      ObjectMapper mapper = new ObjectMapper();
      User user = mapper.readValue(json, User.class);

      log.info("User Object from JsonString: {}", user.toString());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      log.error("Json read error");
    }
  }

  private void writeJsonString() {
    try {
      User user = new User();
      user.setUserId(Integer.valueOf(2));
      user.setUserName("Alice");
      user.setDateOfBirth(LocalDate.of(2021, 1, 2));
      user.addMail("mail1@mail.com");
      user.addMail("mail2@mail.com");

      ObjectMapper mapper = new ObjectMapper();
      String json = mapper.writeValueAsString(user);

      log.info("JsonString from User Object: {}", json);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      log.error("Json write error");
    }
  }
}
