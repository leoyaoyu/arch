package com.leo.learn.designPattern.creator.prototype;

import java.util.List;

public class MyClass implements Cloneable{

  private String name;
  private Integer age;
  private City city;
  private List<String> classmates;

  public MyClass(String name, Integer age, City city, List<String> classmates) {
    this.name = name;
    this.age = age;
    this.city = city;
    this.classmates = classmates;
  }

  @Override
  public String toString(){
    return this.name + ", " + this.age + " in city " + this.city.toString() + ", classmates :" + this.classmates;
  }

  @Override
  protected MyClass clone() {
    try{
      return (MyClass) super.clone();
    } catch (CloneNotSupportedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }

  public List<String> getClassmates() {
    return classmates;
  }

  public void setClassmates(List<String> classmates) {
    this.classmates = classmates;
  }
}