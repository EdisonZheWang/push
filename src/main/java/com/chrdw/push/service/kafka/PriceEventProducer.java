package com.chrdw.push.service.kafka;

import com.chrdw.push.service.config.Config;
import org.slf4j.Logger;

/**
 * @Date: 2019/12/1
 * @author: <a href="mailto:v-edwang@expedia.com">Edwang</a>
 */
public class PriceEventProducer implements Runnable {

  private Config config;
  private Logger logger;

  public PriceEventProducer(Config config, Logger logger) {
    this.config = config;
    this.logger = logger;
  }

  @Override
  public void run() {
    logger.info("produce kafka event");
    try {
      Thread.sleep(5 * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
