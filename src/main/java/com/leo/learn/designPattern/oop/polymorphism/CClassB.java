package com.leo.learn.designPattern.oop.polymorphism;

public class CClassB extends PClass {

  @Override
  public String getNumber() {
    return "this is a child class b output";
  }

  @Override
  public String getNewInfo() {
    return "this is a info from b child class";
  }
}
