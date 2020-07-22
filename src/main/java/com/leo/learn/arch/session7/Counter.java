package com.leo.learn.arch.session7;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class Counter {
  static CopyOnWriteArrayList<Long> list = new CopyOnWriteArrayList();

  public static long percent95(){
    List<Long> orderedList = list.stream().sorted().collect(Collectors.toList());
    int index = new Double(Math.floor(list.size() * 0.95)).intValue();
    return orderedList.get(index);
  }

  public static long average() {
    return new Double(list.stream().mapToLong(Long::longValue).average().orElse(0D)).longValue();
  }
}
