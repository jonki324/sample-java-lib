package com.example.date;

import com.example.common.Command;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.extern.slf4j.Slf4j;

/**
 * 日付操作.
 */
@Slf4j
public class Date implements Command {
  @Override
  public void execute() {
    now();
    stringToDatetime();
    convert();
    plusMinus();
  }

  private void now() {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    log.info(now.format(fmt).toString());
  }

  private void stringToDatetime() {
    String dateString = "2021/01/30 23:01:59";
    log.info(dateString);
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime dt = LocalDateTime.parse(dateString, fmt);
    log.info(dt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString());
  }

  private void convert() {
    LocalDateTime now = LocalDateTime.now();
    Timestamp ts = Timestamp.valueOf(now);
    log.info(ts.toString());
    LocalDateTime dt = ts.toLocalDateTime();
    log.info(dt.toString());
  }

  private void plusMinus() {
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime oneDayPlus = now.plusDays(1);
    LocalDateTime oneDayMinus = now.minusDays(1);
    log.info(now.toString());
    log.info(oneDayPlus.toString());
    log.info(oneDayMinus.toString());
  }
}
