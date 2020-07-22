package com.leo.learn.arch.session7;

import org.junit.Before;
import org.junit.Test;

public class CounterTest {

  @Before
  public void setup(){
    for(int i = 1; i < 100; i++) {
      Counter.list.add(new Long(i));
    }
  }

  @Test
  public void percent95() {
    System.out.println("percent 95: " +  Counter.percent95());
  }

  @Test
  public void avarage() {
    System.out.println("average : " + Counter.average());
  }
}