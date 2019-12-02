package com.chrdw.push.service.kafka.init;

import com.chrdw.push.service.datamodel.PriceEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;

/**
 * @Date: 2019/12/1
 * @author: <a href="mailto:v-edwang@expedia.com">Edwang</a>
 */
public class MultiListener {

  private Logger logger =  LoggerFactory.getLogger("consume.logger");

  @KafkaHandler(isDefault = true)
  public void listenDefault(PriceEvent priceEvent) {
    logger.info(priceEvent.getKey());
  }
}
