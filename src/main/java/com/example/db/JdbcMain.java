package com.example.db;

import com.example.common.Command;

/**
 * JDBCでDB操作実行クラス.
 */
public class JdbcMain implements Command {
  @Override
  public void execute() {
    UserService service = new UserService();
    // service.createTable();
    // service.add();
    service.findAll();
  }
}
