package com.chrdw.push.service.kafka.init;

import com.chrdw.push.service.datamodel.PriceEvent;
import org.springframework.kafka.annotation.KafkaHandler;

/**
 * @Date: 2019/12/1
 * @author: <a href="mailto:v-edwang@expedia.com">Edwang</a>
 */
public class MultiListener {
  @KafkaHandler(isDefault = true)
  public void listenDefault(PriceEvent priceEvent) {

  }
}
