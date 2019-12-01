package com.chrdw.push.service.datamodel;

public class RateType {
  private SiteType siteType;
  private ShoppingPath shoppingPath;

  public RateType() {
  }

  public SiteType getSiteType() {
    return this.siteType;
  }

  public void setSiteType(SiteType siteType) {
    this.siteType = siteType;
  }

  public ShoppingPath getShoppingPath() {
    return this.shoppingPath;
  }

  public void setShoppingPath(ShoppingPath shoppingPath) {
    this.shoppingPath = shoppingPath;
  }
}
