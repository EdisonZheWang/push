package com.chrdw.push.service.config;

import lombok.Data;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * @Date: 2019/12/1
 * @author: <a href="mailto:v-edwang@expedia.com">Edwang</a>
 */

@Data
public class AppConfig {

  private int consumeEventThreadCnt;
  private int produceEventThreadCnt;

  private ThreadPoolTaskExecutor pushExecutor;
}
