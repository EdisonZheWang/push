package com.chrdw.push.service.kafka.init;

import com.chrdw.push.service.model.PriceEvent;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

/**
 * @Date: 2019/12/1
 * @author: <a href="mailto:chrdw.p@gmail.com">Edison Zhe Wang</a>
 */
@Configuration
public class KafkaConfiguration {

  @Autowired
  private KafkaProperties kafkaProperties;

  @Bean
  public Map<String, Object> producerConfigs() {
    Map<String, Object> props = new HashMap<>(kafkaProperties.buildProducerProperties());
    return props;
  }

  @Bean
  public ProducerFactory<String, PriceEvent> producerFactory() {
    return new DefaultKafkaProducerFactory<>(producerConfigs());
  }

  @Bean
  public KafkaTemplate<String, PriceEvent> kafkaProducer() {
    return new KafkaTemplate<>(producerFactory());
  }

  private Map<String, Object> consumerConfigs() {
    kafkaProperties.setClientId("chrdw-push-service".concat("-")
      .concat(ManagementFactory.getRuntimeMXBean().getName().split("@")[1].replace('.', '_')));
    return new HashMap<>(kafkaProperties.buildConsumerProperties());
  }

  @Bean
  public KafkaConsumerFactory customKafkaConsumerFactory() {
    return new KafkaConsumerFactory<String, PriceEvent>(consumerConfigs());
  }

}
