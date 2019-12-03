package com.chrdw.push.service.kafka.init;

import java.util.Collections;
import java.util.Map;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 * @Date: 12/3/19
 * @author: <a href="mailto:v-edwang@expedia.com">Edwang</a>
 */
public class KafkaConsumerFactory<k, v> {

  private String topic;

  private Map<String, Object> consumerConfigs;

  public KafkaConsumerFactory(Map<String, Object> consumerConfigs) {
    this.consumerConfigs = consumerConfigs;
  }

  public KafkaConsumer<k, v> getKafkaConsumer(String topic) {
    KafkaConsumer<k, v> consumer = new KafkaConsumer<>(consumerConfigs);
    consumer.subscribe(Collections.singletonList(topic));
    return consumer;
  }

  public KafkaConsumer<k, v> getKafkaConsumer() {
    KafkaConsumer<k, v> consumer = new KafkaConsumer<>(consumerConfigs);
    consumer.subscribe(Collections.singletonList(topic));
    return consumer;
  }
}
