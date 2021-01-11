package com.example.csv;

import com.example.common.Command;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * OpenCSV使い方.
 */
@Slf4j
public class Csv implements Command {
  @Override
  public void execute() {
    writeCsv();
    readCsv();
  }

  private void writeCsv() {
    try (Writer writer = Files.newBufferedWriter(Paths.get("user_w.csv"))) {
      User user1 = new User();
      user1.setUserId(Integer.valueOf(1));
      user1.setUserName("Bob");
      user1.setDateOfBirth(
          new SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.of(2021, 01, 02).toString()));
      User user2 = new User();
      user2.setUserId(Integer.valueOf(2));
      user2.setUserName("Alice");
      user2.setDateOfBirth(
          new SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.of(2021, 01, 03).toString()));
      List<User> users = List.of(user1, user2);

      StatefulBeanToCsv<User> beanToCsv = new StatefulBeanToCsvBuilder<User>(writer).build();
      beanToCsv.write(users);
    } catch (ParseException | IOException | CsvDataTypeMismatchException
        | CsvRequiredFieldEmptyException e) {
      e.printStackTrace();
      log.error("CSV書き込みエラー");
    }
  }

  private void readCsv() {
    try (Reader reader = Files.newBufferedReader(Paths.get("user_w.csv"))) {
      CsvToBean<User> csvToBean = new CsvToBeanBuilder<User>(reader).withType(User.class).build();
      List<User> users = csvToBean.parse();
      log.info(users.toString());
    } catch (IOException e) {
      e.printStackTrace();
      log.error("CSV読み込みエラー");
    }
  }
}
