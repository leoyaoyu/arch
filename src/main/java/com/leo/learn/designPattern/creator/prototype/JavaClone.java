package com.leo.learn.designPattern.creator.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaClone {

  public static Logger log = LoggerFactory.getLogger(JavaClone.class);

  public static void main(String[] args) {
    City city1 = new City("Beijing", "haidian");
    //List<String> classmates = Arrays.asList("harry", "happy","hence");
    List<String> classmates = new ArrayList();
    classmates.add("harry");
    classmates.add("happy");
    classmates.add("hence");
    MyClass myClass1 = new MyClass("Leo", 35, city1, classmates);
    MyClass myClass2 = myClass1.clone();

    log.info("are they equal ? {}", myClass1 == myClass2);
    log.info("are they equal ? {}", myClass1.equals(myClass2));

    log.info("my class1 : {}", myClass1);
    log.info("my class2 : {}", myClass2);

    myClass2.setName("Levia");
    List<String> classmatesNew = myClass2.getClassmates();
    classmatesNew.add("Jone");
    myClass2.setClassmates(classmatesNew);
    //myClass2.setClassmates(Arrays.asList("Brace", "Bob", "Bilibili", "Brain"));
    City city2 = new City("Yunnan", "kunming");
    myClass1.setCity(city2);

    log.info("my class1 : {}", myClass1);
    log.info("my class2 : {}", myClass2);

    myClass2.setAge(18);
    log.info("my class1 : {}", myClass1);
    log.info("my class2 : {}", myClass2);
  }

}
