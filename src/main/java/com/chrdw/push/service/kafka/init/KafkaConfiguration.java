package com.chrdw.push.service.kafka.init;

import com.chrdw.push.service.datamodel.PriceEvent;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

/**
 * @Date: 2019/12/1
 * @author: <a href="mailto:v-edwang@expedia.com">Edwang</a>
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

  @Bean
  ConcurrentKafkaListenerContainerFactory<String, PriceEvent> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, PriceEvent> factory =
      new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    return factory;
  }

  @Bean
  public ConsumerFactory<String, PriceEvent> consumerFactory() {
    return new DefaultKafkaConsumerFactory<>(consumerConfigs());
  }

  @Bean
  public Map<String, Object> consumerConfigs() {
    Map<String, Object> props = new HashMap<>(kafkaProperties.buildConsumerProperties());
    return props;
  }

  @Bean
  @KafkaListener(topics = "${config.appconfig.kafkaTopicId}")
  public MultiListener multiListener() {
    return new MultiListener();
  }
}
