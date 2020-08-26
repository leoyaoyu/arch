package com.leo.learn.designPattern.creator.prototype.sample;

import java.util.ArrayList;
import java.util.List;

public class Person implements Cloneable{

  //姓名
  private String name;
  //年龄
  private int age;
  //朋友
  private List<String> friends;
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public List<String> getFriends() {
    return friends;
  }
  public void setFriends(List<String> friends) {
    this.friends = friends;
  }
  //重写toString方法
  @Override
  public String toString() {
    return "Person [name=" + name + ", age=" + age + ", friends=" + friends + "]";
  }
  //浅层克隆
  public Person shallowClone() {
    try {
      return (Person) super.clone();
    } catch (CloneNotSupportedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }
  //深层克隆
  public Person deepClone() {
    try {
      Person person = (Person) super.clone();
      List<String> newFriends = new ArrayList<String>();
      for(String friend : this.getFriends()) {
        newFriends.add(friend);
      }
      person.setFriends(newFriends);
      return person;
    } catch (CloneNotSupportedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  public static void main(String[] args) {
    //创建对象person1
    Person person1 = new Person();
    //初始化对象
    person1.setName("zhangsan");
    person1.setAge(20);
    List<String> friends = new ArrayList<String>();
    friends.add("lisi");
    friends.add("wangwu");
    person1.setFriends(friends);
    //person2是浅层克隆
    Person person2 = person1.shallowClone();
    //person3是深层克隆
    Person person3 = person1.deepClone();
    //获取浅层克隆的friends的list对象
    List<String> person2_friends = person2.getFriends();
    //向引用对象中添加值
    person2_friends.add("shallow");
    person2.setFriends(person2_friends);
    //获取深层克隆的friends的list对象
    List<String> person3_friends = person3.getFriends();
    //向引用对象中添加值
    person3_friends.add("deep");
    person3.setFriends(person3_friends);

    System.out.println("原型："+person1);
    System.out.println("浅层克隆："+person2);
    System.out.println("深层克隆："+person3);
  }
}