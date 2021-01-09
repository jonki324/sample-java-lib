package com.example.lombok;

import com.example.common.Command;
import lombok.extern.slf4j.Slf4j;

/**
 * Lombok使い方.
 */
@Slf4j
public class Lombok implements Command {
  @Override
  public void execute() {
    User user = new User();
    user.setId(Integer.valueOf(1));
    user.setName("Bob");
    log.info(user.toString());
  }
}
