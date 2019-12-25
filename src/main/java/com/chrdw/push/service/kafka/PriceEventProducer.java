package com.chrdw.push.service.kafka;

import com.chrdw.push.service.config.Config;
import com.chrdw.push.service.model.PriceEvent;
import java.util.UUID;
import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;

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
    KafkaTemplate kafkaTemplate = config.getKafkaTemplate();
    String kafkaTopicId = config.getAppConfig().getKafkaTopicId();
    while (true) {
      try {
        PriceEvent priceEvent = new PriceEvent();
        kafkaTemplate.send(kafkaTopicId, UUID.randomUUID().toString(), priceEvent);
        logger.info("produce kafka event");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
