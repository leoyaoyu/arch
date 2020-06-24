package com.leo.learn.arch.session3.components;

public class ChildElement implements WinElement {

  private String text;


  public ChildElement(){

  }

  public ChildElement(String text) {
    this.text = text;
  }

  @Override
  public void print() {
    if(this.text != null) {
      System.out.println("print " + this.getClass().getSimpleName() + "(" + this.text + ")");
    }
    else{
      System.out.println("print " + this.getClass().getSimpleName());
    }
  }
}
