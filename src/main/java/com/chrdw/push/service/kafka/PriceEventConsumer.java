package com.chrdw.push.service.kafka;

import com.chrdw.push.service.config.Config;
import com.chrdw.push.service.model.PriceEvent;
import java.time.Duration;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;

/**
 * @Date: 2019/12/1
 * @author: <a href="mailto:v-edwang@expedia.com">Edwang</a>
 */

public class PriceEventConsumer implements Runnable {

  private Config config;
  private Logger logger;

  public PriceEventConsumer(Config config, Logger logger) {
    this.config = config;
    this.logger = logger;
  }

  @Override
  public void run() {
    KafkaConsumer<String, PriceEvent> kafkaConsumer = config.getCustomKafkaConsumerFactory()
      .getKafkaConsumer(config.getAppConfig().getKafkaTopicId());
    while (true) {
      try {
        ConsumerRecords<String, PriceEvent> records = kafkaConsumer
          .poll(Duration.ofSeconds(config.getAppConfig().getKafkaConsumerPollTimeOut()));
        for (ConsumerRecord<String, PriceEvent> record : records) {
          System.out.println(
            record.key() + "-" + record.value() + "-" + record.offset() + "-" + record.partition());
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }
}
