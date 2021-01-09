package com.example.common;

import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;
import lombok.extern.slf4j.Slf4j;

/**
 * コマンドファクトリークラス.
 */
@Slf4j
public class CommandFactory {
  private static final ResourceBundle BUNDLE;

  static {
    BUNDLE = ResourceBundle.getBundle("app");
  }

  /**
   * コマンドクラス生成.
   *
   * @return 実行クラス
   */
  public static Command create() {
    Command command = null;
    try {
      Class<?> cls = Class.forName(BUNDLE.getString("EXECUTE_CLASS"));
      command = (Command) cls.getDeclaredConstructor().newInstance();
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
        | InvocationTargetException | NoSuchMethodException | SecurityException e) {
      log.error("クラスロード失敗");
      throw new RuntimeException(e);
    }
    return command;
  }
}
