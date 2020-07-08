package com.leo.learn.arch.session5;

import java.util.*;
import java.util.stream.Stream;

public class ConsistentHashing {

  //真实结点列表,考虑到服务器上线、下线的场景，即添加、删除的场景会比较频繁，这里使用LinkedList会更好
  private List<String> realNodes = new LinkedList<String>();

  //虚拟节点，key表示虚拟节点的hash值，value表示虚拟节点的名称
  private SortedMap<Integer, String> virtualNodes = new TreeMap<Integer, String>();

  //虚拟节点的数目，这里写死，为了演示需要，一个真实结点对应5个虚拟节点
  private final int VIRTUAL_NODES = 5;

  //使用FNV1_32_HASH算法计算服务器的Hash值,这里不使用重写hashCode的方法，最终效果没区别
  private int getHash(String str){
    final int p = 16777619;
    int hash = (int)2166136261L;
    for (int i = 0; i < str.length(); i++)
      hash = (hash ^ str.charAt(i)) * p;
      hash += hash << 13;
      hash ^= hash >> 7;
      hash += hash << 3;
      hash ^= hash >> 17;
      hash += hash << 5;

    // 如果算出来的值为负数则取其绝对值
    if (hash < 0)
      hash = Math.abs(hash);
    return hash;
  }

  //得到应当路由到的结点
  private Integer getServerHash(String key) {
    //得到该key的hash值
    int hash = getHash(key);
    // 得到大于该Hash值的所有Map
    SortedMap<Integer, String> subMap = virtualNodes.tailMap(hash);
    String virtualNode;
    Integer serverKey;

    if (subMap.isEmpty()) {
      //如果没有比该key的hash值大的，则从第一个node开始
      serverKey = virtualNodes.firstKey();
      //返回对应的服务器
      virtualNode = virtualNodes.get(serverKey);
    } else {
      //第一个Key就是顺时针过去离node最近的那个结点
      serverKey = subMap.firstKey();
      //返回对应的服务器
      virtualNode = subMap.get(serverKey);
    }
    return serverKey;
  }
  //得到应当路由到的结点
  private String getServer(String key){
    //得到该key的hash值
    int hash = getHash(key);
    // 得到大于该Hash值的所有Map
    SortedMap<Integer, String> subMap = virtualNodes.tailMap(hash);
    String virtualNode;
    Integer serverKey;

    if(subMap.isEmpty()){
      //如果没有比该key的hash值大的，则从第一个node开始
      serverKey = virtualNodes.firstKey();
      //返回对应的服务器
      virtualNode = virtualNodes.get(serverKey);
    }else{
      //第一个Key就是顺时针过去离node最近的那个结点
      serverKey = subMap.firstKey();
      //返回对应的服务器
      virtualNode = subMap.get(serverKey);
    }

    //virtualNode虚拟节点名称要截取一下
    if(virtualNode != null && !"".equals(virtualNode)){
      //System.out.println("hash: "+ hash + ",key: " + key + " mapped to server(key : " +serverKey + " : " +
      // virtualNode);
      return virtualNode.substring(0, virtualNode.indexOf("&&"));
    }
    return null;
  }

  public void addNodeWithVirtualOnes(String node){
    for(int i=0; i<VIRTUAL_NODES; i++){
      String virtualNodeName = node + "&&VN" + String.valueOf(i);
      int hash = getHash(virtualNodeName);
      System.out.println("虚拟节点[" + virtualNodeName + "]被添加, hash值为" + hash);
      virtualNodes.put(hash, virtualNodeName);
    }
  }

  public void showNodes(){
    virtualNodes.keySet().forEach(key -> {
      System.out.println(key + " : " + virtualNodes.get(key));
    });
  }

  public static String getRandomString(int length){
    String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    Random random=new Random();
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<length;i++){
      int number=random.nextInt(62);
      sb.append(str.charAt(number));
    }
    return sb.toString();
  }

  public static void main(String[] args){

    //待添加入Hash环的服务器列表
    String[] servers = {
            "192.168.0.0:111", "192.168.0.1:111",
            "192.168.0.2:111", "192.168.0.3:111",
            "192.168.0.4:111", "192.168.0.5:111",
            "192.168.0.6:111", "192.168.0.7:111",
            "192.168.0.8:111", "192.168.0.9:111" };
    System.out.println("----show the hash set start--");

    //add nodes
    ConsistentHashing consistentHashing = new ConsistentHashing();
    for (String server : servers) {
      consistentHashing.addNodeWithVirtualOnes(server);
    }

    //print nodes in hash cycle
    consistentHashing.showNodes();


    Stream<Integer> integers = Stream.iterate(0, i -> i + 1);
    int amount = 100000;

    long total = integers.limit(amount).mapToInt(index -> {
      String randomStr = getRandomString(32);
      //System.out.println("[" + randomStr + "]的hash值为" +
      //        consistentHashing.getHash(randomStr) + ", 被路由到结点[" + consistentHashing.getServerHash(randomStr) + "]");

      Integer diff = consistentHashing.getServerHash(randomStr) - consistentHashing.getHash(randomStr);
      if(diff < 0) diff = 0;
      //System.out.println(diff);
      return diff / amount;
    }).sum();

    System.out.println("sum : " + total);




  }
}
