package com.chrdw.push.service.model;

public class PartnerChain {
  private Partner partner;
  private String brandName;

  public PartnerChain() {
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
}
