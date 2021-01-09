package com.example;

import com.example.common.Command;
import com.example.common.CommandFactory;

/**
 * メインクラス.
 *
 */
public class App {
  /**
   * メインメソッド.
   *
   * @param args 引数
   */
  public static void main(String[] args) {
    Command command = CommandFactory.create();
    command.execute();
  }
}
