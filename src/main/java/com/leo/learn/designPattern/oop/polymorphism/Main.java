package com.leo.learn.designPattern.oop.polymorphism;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static Logger log = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {
    PClass c1 = new CClassA();
    PClass c2 = new CClassB();

    List<PClass> list = new ArrayList<>();
    list.add(c1);
    list.add(c2);

    log.info("c1 output: {}", c1.getNumber());
    log.info("c2 output: {}", c2.getNumber());

    list.stream().forEach(x -> log.info("list item : {}", x.getNumber()));

    list.stream().forEach(x -> log.info("list item : {}", x.getNewInfo()));

  }
}
