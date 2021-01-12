package com.example.db;

import java.sql.Connection;

/**
 * ユーザーDAOクラス.
 */
public class UserDao extends BaseDao {
  public UserDao(Connection connection) {
    super(connection);
  }
}
