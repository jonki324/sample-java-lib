package com.example.mybatis;

import com.example.common.Command;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis使い方.
 */
@Slf4j
public class Mybatis implements Command {
  @Override
  public void execute() {
    try (InputStream in = Resources.getResourceAsStream("mybatis-config.xml")) {
      SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
      try (SqlSession session = factory.openSession()) {
        List<UserEntiry> users = session.selectList("com.example.mybatis.selectAll");
        log.info("ユーザーリスト: {}", users.toString());
      }
    } catch (IOException e) {
      log.error("設定ファイル取得失敗: {}", e.getMessage());
    }
  }
}
