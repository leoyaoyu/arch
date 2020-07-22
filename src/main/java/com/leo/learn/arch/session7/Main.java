package com.leo.learn.arch.session7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

  public static void main(String[] args) {

    int threadAmount = 10;
    int executeTime = 10;
    String url = "https://www.baidu.com";
    //String url = "http://yaoyuleo.51vip.biz/plan/user/ofNCI5E-dRxz40VjBDHp9ovRwxNQ/goal/33/latest";

    ExecutorService executors = Executors.newFixedThreadPool(threadAmount);
    for(int i = 0 ; i < threadAmount ; i++) {
      executors.execute(new ClientThread(url, executeTime));
    }

    try{
      Thread.sleep(5000);
      executors.shutdown();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      System.out.println("test url: " +  url);
      System.out.println("percent95: " +  Counter.percent95());
      System.out.println("average: " + Counter.average());
      System.out.println("execute time: " + Counter.list.size());
      System.out.println("time consumer: ");
      Counter.list.stream().sorted().forEach(item -> {
        System.out.println(item);
      });
    }
  }
}
