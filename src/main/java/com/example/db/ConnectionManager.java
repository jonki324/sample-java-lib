package com.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import lombok.extern.slf4j.Slf4j;

/**
 * コネクションマネージャークラス.
 */
@Slf4j
public class ConnectionManager {
  private static final ResourceBundle R_BUNDLE = ResourceBundle.getBundle("db");

  private Connection connection;

  static {
    try {
      Class.forName(R_BUNDLE.getString("DRIVER"));
      log.info("DBドライバー読込成功");
    } catch (ClassNotFoundException e) {
      log.error("DBドライバー読込失敗: {}", e.getMessage());
      throw new RuntimeException(e);
    }
  }

  /**
   * コネクション取得.
   *
   * @return コネクション
   */
  public Connection getConnection() {
    try {
      if (connection == null || connection.isClosed()) {
        connection = DriverManager.getConnection(R_BUNDLE.getString("URL"));
        connection.setAutoCommit(false);
        log.info("コネクション取得成功");
      }
    } catch (SQLException e) {
      log.error("コネクション取得失敗: {}", e.getMessage());
      throw new RuntimeException(e);
    }
    return connection;
  }

  /**
   * コネクション切断.
   */
  public void closeConnection() {
    try {
      if (connection != null && !connection.isClosed()) {
        connection.close();
        log.info("コネクション切断成功");
      }
    } catch (SQLException e) {
      log.error("コネクション切断失敗: {}", e.getMessage());
      throw new RuntimeException(e);
    }
  }

  /**
   * コミット.
   */
  public void commit() {
    try {
      if (connection != null && !connection.isClosed()) {
        connection.commit();
        log.info("コミット成功");
      }
    } catch (SQLException e) {
      log.error("コミット失敗: {}", e.getMessage());
      throw new RuntimeException(e);
    }
  }

  /**
   * ロールバック.
   */
  public void rollback() {
    try {
      if (connection != null && !connection.isClosed()) {
        connection.rollback();
        log.info("ロールバック成功");
      }
    } catch (SQLException e) {
      log.error("ロールバック失敗: {}", e.getMessage());
      throw new RuntimeException(e);
    }
  }
}
