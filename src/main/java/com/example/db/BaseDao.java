package com.example.db;

import java.sql.Connection;

/**
 * ベースDAOクラス.
 */
public abstract class BaseDao {
  private Connection connection;

  public BaseDao(Connection connection) {
    this.connection = connection;
  }

  public Connection getConnection() {
    return connection;
  }
}
