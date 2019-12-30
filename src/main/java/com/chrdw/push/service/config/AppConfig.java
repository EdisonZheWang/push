package com.chrdw.push.service.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * @Date: 2019/12/1
 * @author: <a href="mailto:chrdw.p@gmail.com">Edison Zhe Wang</a>
 */

@Data
public class AppConfig {

  private int consumeEventThreadCnt;
  private int produceEventThreadCnt;
  private String kafkaTopicId;
  private String kafkaConsumerPollBatchSize;
  private int kafkaConsumerPollTimeOut;
  private int pushTimeout;

  @Autowired
  private ThreadPoolTaskExecutor pushExecutor;
}
