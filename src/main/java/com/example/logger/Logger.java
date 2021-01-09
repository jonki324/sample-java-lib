package com.example.logger;

import com.example.common.Command;
import lombok.extern.slf4j.Slf4j;

/**
 * ロガー使い方.
 */
@Slf4j
public class Logger implements Command {
  @Override
  public void execute() {
    log.error("LOG TEST {}", "error");
    log.warn("LOG TEST {}", "warn");
    log.info("LOG TEST {}", "info");
    log.debug("LOG TEST {}", "debug");
    log.trace("LOG TEST {}", "trace");
  }
}
