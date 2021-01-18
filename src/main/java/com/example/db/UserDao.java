package com.example.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

  /**
   * 追加.
   *
   * @param user ユーザークラス
   */
  public void insert(User user) {
    String sql = "insert into users(user_id, user_name) values(?, ?)";
    try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
      ps.setString(1, user.getUserId());
      ps.setString(2, user.getUserName());
      int res = ps.executeUpdate();
      log.info("insert成功: {}", res);
    } catch (SQLException e) {
      log.error("insert失敗: {}", e.getMessage());
      throw new RuntimeException(e);
    }
  }

  /**
   * 全件取得.
   *
   * @return ユーザーリスト
   */
  public List<User> selectAll() {
    List<User> users = new ArrayList<>();
    String sql = "select * from users;";
    try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        User user = new User();
        user.setUserId(rs.getString("user_id"));
        user.setUserName(rs.getString("user_name"));
        users.add(user);
      }
      log.info("select成功: {}", users.size());
    } catch (SQLException e) {
      log.error("select失敗: {}", e.getMessage());
      throw new RuntimeException(e);
    }
    return users;
  }
}
