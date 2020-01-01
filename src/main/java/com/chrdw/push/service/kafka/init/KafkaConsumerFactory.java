package com.chrdw.push.service.kafka.init;

import static org.apache.kafka.clients.CommonClientConfigs.CLIENT_ID_CONFIG;

import java.lang.management.ManagementFactory;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 * @Date: 12/3/19
 * @author: <a href="mailto:chrdw.p@gmail.com">Edison Zhe Wang</a>
 */
public class KafkaConsumerFactory<k, v> {

  private String topic;
  private AtomicInteger sq = new AtomicInteger(0);
  private String consumerPrefix =
    ManagementFactory.getRuntimeMXBean().getName().split("@")[1].replaceAll(".", "-");

  private Map<String, Object> consumerConfigs;

  public KafkaConsumerFactory(Map<String, Object> consumerConfigs) {
    this.consumerConfigs = consumerConfigs;
  }

  public KafkaConsumer<k, v> getKafkaConsumer(String topic) {
    consumerConfigs.put(CLIENT_ID_CONFIG,
      consumerPrefix.concat("-").concat(String.valueOf(sq.getAndIncrement())));
    KafkaConsumer<k, v> consumer = new KafkaConsumer<>(consumerConfigs);
    consumer.subscribe(Collections.singletonList(topic));
    return consumer;
  }

  public KafkaConsumer<k, v> getKafkaConsumer() {
    consumerConfigs.put(CLIENT_ID_CONFIG,
      consumerPrefix.concat("-").concat(String.valueOf(sq.getAndIncrement())));
    KafkaConsumer<k, v> consumer = new KafkaConsumer<>(consumerConfigs);
    consumer.subscribe(Collections.singletonList(topic));
    return consumer;
  }
}
