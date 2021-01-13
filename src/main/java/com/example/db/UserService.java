package com.example.db;

import java.sql.Connection;
import lombok.extern.slf4j.Slf4j;

/**
 * ユーザーサービスクラス.
 */
@Slf4j
public class UserService {
  /**
   * ユーザーテーブル作成.
   */
  public void createTable() {
    try (ConnectionManager connectionManager = new ConnectionManager()) {
      try {
        Connection connection = connectionManager.getConnection();
        UserDao dao = new UserDao(connection);
        dao.createTable();
        connectionManager.commit();
      } catch (RuntimeException e) {
        connectionManager.rollback();
      }
    } catch (Exception e) {
      log.error("コネクションクローズ失敗: {}", e);
      throw new RuntimeException(e);
    }
  }
}
