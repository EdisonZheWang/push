package com.chrdw.push.service.model;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date: 2019/12/1
 * @author: <a href="mailto:chrdw.p@gmail.com">Edison Zhe Wang</a>
 */

@Data
@NoArgsConstructor
public class PriceEvent {

  private Partner partner;
  private String brandName;
  private Boolean bookable;
  private String key;
  private List<Integer> hotelIds;
  private String checkIn;
  private Integer nights;
  private String currency;
  private Boolean enableMultiSource;
  private List<Integer> providerIds;
  private List<RateType> rateTypes;
  private List<SubPosa> subPosas;
  private List<PartnerChain> partnerChains;
}
