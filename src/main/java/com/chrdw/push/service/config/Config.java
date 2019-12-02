package com.chrdw.push.service.config;

import com.chrdw.push.service.kafka.PriceEventConsumer;
import com.chrdw.push.service.kafka.init.MultiListener;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @Date: 2019/12/1
 * @author: <a href="mailto:v-edwang@expedia.com">Edwang</a>
 */

@Data
@Component
@Configuration
@ConfigurationProperties(prefix = "config")
public class Config {

  private AppConfig appConfig;

  private CustomConfig customConfig;

  @Autowired
  private MultiListener multiListener;

  @Autowired
  @Qualifier("kafkaProducer")
  private KafkaTemplate kafkaTemplate;

}
