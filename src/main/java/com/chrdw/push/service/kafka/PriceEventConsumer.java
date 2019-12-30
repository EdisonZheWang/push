package com.chrdw.push.service.kafka;

import com.chrdw.push.service.config.Config;
import com.chrdw.push.service.model.PriceEvent;
import com.chrdw.push.service.push.IPushHandler;
import java.time.Duration;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import reactor.core.publisher.Mono;

/**
 * @Date: 2019/12/1
 * @author: <a href="mailto:chrdw.p@gmail.com">Edison Zhe Wang</a>
 */

public class PriceEventConsumer implements Runnable {

  private Config config;
  private Logger logger;
  private IPushHandler pushHandler;

  public PriceEventConsumer(Config config, Logger logger, IPushHandler pushHandler) {
    this.config = config;
    this.logger = logger;
    this.pushHandler = pushHandler;
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
          Mono.just(record.value()).map(m -> pushHandler.handlePush(m))
            .block(Duration.ofSeconds(config.getAppConfig().getPushTimeout()));
        }
        kafkaConsumer.commitAsync();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }
}
