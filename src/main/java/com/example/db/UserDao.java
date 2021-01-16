package com.example.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import lombok.extern.slf4j.Slf4j;

/**
 * ユーザーDAOクラス.
 */
@Slf4j
public class UserDao extends BaseDao {
  public UserDao(Connection connection) {
    super(connection);
  }

  /**
   * テーブル作成.
   */
  public void createTable() {
    try (Statement stmt = getConnection().createStatement()) {
      stmt.executeUpdate("create table users(user_id varchar(10), user_name varchar(50))");
    } catch (SQLException e) {
      log.error("SQL実行失敗: {}", e.getMessage());
      throw new RuntimeException(e);
    }
  }
}
