package com.example.zip;

import com.example.common.Command;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import lombok.extern.slf4j.Slf4j;

/**
 * Zipファイル操作クラス.
 */
@Slf4j
public class Zip implements Command {
  @Override
  public void execute() {
    create();
  }

  private void create() {
    Path input = Paths.get("user_w.csv");
    String output = "out.zip";
    try (FileOutputStream fos = new FileOutputStream(output);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ZipOutputStream zos = new ZipOutputStream(bos, Charset.forName("UTF-8"))) {
      byte[] data = Files.readAllBytes(input);
      ZipEntry zip = new ZipEntry("user.csv");
      zos.putNextEntry(zip);
      zos.write(data);
    } catch (IOException e) {
      log.error("IOエラー", e);
    }
  }
}
