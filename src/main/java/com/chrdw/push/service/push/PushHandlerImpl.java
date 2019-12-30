package com.chrdw.push.service.push;

import com.chrdw.push.service.model.PriceEvent;
import org.springframework.stereotype.Component;

/**
 * @Date: 12/26/19
 * @author: <a href="mailto:chrdw.p@gmail.com">Edison Zhe Wang</a>
 */
@Component
public class PushHandlerImpl implements IPushHandler<PriceEvent, PushResponse> {


  @Override
  public PushResponse handlePush(PriceEvent priceEvent) {
    return null;
  }
}
