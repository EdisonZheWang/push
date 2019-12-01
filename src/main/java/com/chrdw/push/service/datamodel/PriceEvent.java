package com.chrdw.push.service.datamodel;

import java.util.List;

/**
 * @Date: 2019/12/1
 * @author: <a href="mailto:v-edwang@expedia.com">Edwang</a>
 */
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

  public PriceEvent() {
  }

  public Partner getPartner() {
    return this.partner;
  }

  public void setPartner(Partner partner) {
    this.partner = partner;
  }

  public String getBrandName() {
    return this.brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public Boolean getBookable() {
    return this.bookable;
  }

  public void setBookable(Boolean bookable) {
    this.bookable = bookable;
  }

  public String getKey() {
    return this.key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public List<Integer> getHotelIds() {
    return this.hotelIds;
  }

  public void setHotelIds(List<Integer> hotelIds) {
    this.hotelIds = hotelIds;
  }

  public String getCheckIn() {
    return this.checkIn;
  }

  public void setCheckIn(String checkIn) {
    this.checkIn = checkIn;
  }

  public Integer getNights() {
    return this.nights;
  }

  public void setNights(Integer nights) {
    this.nights = nights;
  }

  public String getCurrency() {
    return this.currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Boolean getEnableMultiSource() {
    return this.enableMultiSource;
  }

  public void setEnableMultiSource(Boolean enableMultiSource) {
    this.enableMultiSource = enableMultiSource;
  }

  public List<Integer> getProviderIds() {
    return this.providerIds;
  }

  public void setProviderIds(List<Integer> providerIds) {
    this.providerIds = providerIds;
  }

  public List<RateType> getRateTypes() {
    return this.rateTypes;
  }

  public void setRateTypes(List<RateType> rateTypes) {
    this.rateTypes = rateTypes;
  }

  public List<SubPosa> getSubPosas() {
    return this.subPosas;
  }

  public void setSubPosas(List<SubPosa> subPosas) {
    this.subPosas = subPosas;
  }

  public List<PartnerChain> getPartnerChains() {
    return this.partnerChains;
  }

  public void setPartnerChains(List<PartnerChain> partnerChains) {
    this.partnerChains = partnerChains;
  }
}
