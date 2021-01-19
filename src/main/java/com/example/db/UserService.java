package com.example.db;

import java.sql.Connection;
import java.util.List;
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

  /**
   * ユーザー追加.
   */
  public void add() {
    try (ConnectionManager connectionManager = new ConnectionManager()) {
      try {
        Connection connection = connectionManager.getConnection();
        UserDao dao = new UserDao(connection);
        UserEntiry user = new UserEntiry();
        user.setUserId("u01");
        user.setUserName("Bob");
        dao.insert(user);
        connectionManager.commit();
      } catch (RuntimeException e) {
        connectionManager.rollback();
      }
    } catch (Exception e) {
      log.error("コネクションクローズ失敗: {}", e);
      throw new RuntimeException(e);
    }
  }

  /**
   * ユーザー全件取得.
   */
  public void findAll() {
    try (ConnectionManager connectionManager = new ConnectionManager()) {
      Connection connection = connectionManager.getConnection();
      UserDao dao = new UserDao(connection);
      List<UserEntiry> users = dao.selectAll();
      log.info("ユーザーリスト: {}", users.toString());
    } catch (Exception e) {
      log.error("コネクションクローズ失敗: {}", e);
      throw new RuntimeException(e);
    }
  }
}
