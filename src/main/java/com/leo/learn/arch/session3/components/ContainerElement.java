package com.leo.learn.arch.session3.components;

import java.util.ArrayList;
import java.util.List;

public class ContainerElement implements WinElement {

  List<WinElement> elements;

  public ContainerElement(){
    this.elements = new ArrayList<>();
  }

  public void add(WinElement element) {
    this.elements.add(element);
  }

  @Override
  public void print() {
    System.out.println("print " + this.getClass().getSimpleName() + "(");
    elements.forEach(WinElement::print);
    System.out.println(")");

  }
}
