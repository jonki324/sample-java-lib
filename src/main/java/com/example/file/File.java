package com.example.file;

import com.example.common.Command;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;

/**
 * ファイル操作.
 */
@Slf4j
public class File implements Command {
  @Override
  public void execute() {
    write();
    read();
    delete();
    copy();
    move();
  }

  private void read() {
    try (Stream<String> s = Files.lines(Paths.get("./file.txt"))) {
      s.forEach(System.out::println);
    } catch (IOException e) {
      log.error("IOエラー", e);
    }
  }

  private void write() {
    List<String> lines = List.of("file line1", "file line2", "file line3");
    List<String> append = List.of("line4", "line5", "line6");
    try {
      Files.write(Paths.get("./file.txt"), lines, Charset.forName("UTF-8"),
          StandardOpenOption.CREATE);

      Files.write(Paths.get("./file.txt"), append, Charset.forName("UTF-8"),
          StandardOpenOption.APPEND);
    } catch (IOException e) {
      log.error("IOエラー", e);
    }
  }

  private void delete() {
    try {
      Files.deleteIfExists(Paths.get("./file.txt"));
    } catch (IOException e) {
      log.error("IOエラー", e);
    }
  }

  private void copy() {
    try {
      Path source = Paths.get("./user_w.csv");
      Path target = Paths.get("./out");
      Files.copy(source, target.resolve(source.getFileName()), StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
      log.error("IOエラー", e);
    }
  }

  private void move() {
    try {
      Path source = Paths.get("./user_w.csv");
      Path target = source.resolveSibling("user_w_new.csv");
      Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
      log.error("IOエラー", e);
    }
  }
}
