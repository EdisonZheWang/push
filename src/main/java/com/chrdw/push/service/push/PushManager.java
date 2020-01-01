package com.chrdw.push.service.push;

import com.chrdw.push.service.config.Config;
import com.chrdw.push.service.kafka.PriceEventConsumer;
import com.chrdw.push.service.kafka.PriceEventProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * @Date: 2019/12/1
 * @author: <a href="mailto:chrdw.p@gmail.com">Edison Zhe Wang</a>
 */
@Component
public class PushManager implements InitializingBean {

  @Autowired
  private Config config;

  @Autowired
  private IPushHandler pushHandler;

  @Override
  public void afterPropertiesSet() throws Exception {
    ThreadPoolTaskExecutor executor = config.getAppConfig().getPushExecutor();
    executor.initialize();

    int consumeEventThreadCnt = config.getAppConfig().getConsumeEventThreadCnt();
    Logger consumeLogger = LoggerFactory.getLogger("consume.logger");
    for (int i = 0; i < consumeEventThreadCnt; i++) {
      executor.submit(new PriceEventConsumer(config, consumeLogger, pushHandler));
    }
    int produceEventThreadCnt = config.getAppConfig().getProduceEventThreadCnt();
    Logger produceLogger = LoggerFactory.getLogger("produce.logger");
    for (int i = 0; i < produceEventThreadCnt; i++) {
      executor.submit(new PriceEventProducer(config, produceLogger));
    }
  }
}
