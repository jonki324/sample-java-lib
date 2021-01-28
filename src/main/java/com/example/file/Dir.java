package com.example.file;

import com.example.common.Command;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.extern.slf4j.Slf4j;

/**
 * ディレクトリ操作.
 */
@Slf4j
public class Dir implements Command {
  @Override
  public void execute() {
    create();
    list();
    walk();
  }

  private void create() {
    try {
      Path path = Paths.get("./", "out", "inner");
      Files.createDirectory(path);
    } catch (IOException e) {
      log.error("IOエラー", e);
    }
  }

  private void list() {
    try {
      Path path = Paths.get("./", "out");
      Files.list(path).forEach(System.out::println);
    } catch (IOException e) {
      log.error("IOエラー", e);
    }
  }

  private void walk() {
    try {
      Path path = Paths.get("./", "src");
      Files.walk(path, 2).forEach(System.out::println);
    } catch (IOException e) {
      log.error("IOエラー", e);
    }
  }
}
