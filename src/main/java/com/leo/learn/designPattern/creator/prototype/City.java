package com.leo.learn.designPattern.creator.prototype;

public class City {

  private String city;
  private String province;

  public City(String city, String province) {
    this.city = city;
    this.province = province;
  }

  @Override
  public String toString(){
    return this.province + ", " + this.city;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }
}
