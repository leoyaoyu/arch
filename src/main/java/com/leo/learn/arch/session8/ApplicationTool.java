package com.leo.learn.arch.session8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

/**
 * two linked list may have the same surfix, output the start element of the suffix;
 * O(n), T(n)
 */
public class ApplicationTool {

  static Logger log = LoggerFactory.getLogger(ApplicationTool.class);

  public static void main(String[] args) {
    log.info("--------list1----------");
    Node list1 = initLinkedList1();
    print(list1);
    log.info("--------list2----------");
    Node list2 = initLinkedList2();
    print(list2);
    log.info("--------start calculation----------");
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    pushdList(list1, stack1);
    pushdList(list2, stack2);

    Integer value1 = -1;
    Integer value2 = -1;
    Integer firstValue = -1;
    int duplicateAmount = -1;

    while(value1 == value2 && !stack1.empty() && !stack2.empty()) {
      firstValue = value1;
      value1 = stack1.pop();
      value2 = stack2.pop();
      duplicateAmount++;
    }
    if(firstValue != -1){
      log.info("cross element is : {}, duplicate amount is {}", firstValue, duplicateAmount);
    }

  }

  static void pushdList(Node list, Stack stack) {
    Node node = new Node(0);
    node.next = list;
    while(node.next != null){
      node = node.next;
      stack.push(node.value);
    }
  }

  static void print(Node n1) {
    Node node = new Node(0);
    node.next = n1;
    while(node.next != null){
      node = node.next;
      log.info(node.value.toString());
    }
  }


  public static Node initLinkedList1() {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(10);
    Node n6 = new Node(11);
    Node n7 = new Node(12);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
    n6.next = n7;
    return n1;
  }

  public static Node initLinkedList2() {
    Node n1 = new Node(25);
    Node n2 = new Node(26);
    Node n3 = new Node(27);
    Node n4 = new Node(24);
    Node n5 = new Node(20);
    Node n6 = new Node(21);
    Node n7 = new Node(22);
    Node n8 = new Node(10);
    Node n9 = new Node(11);
    Node n10 = new Node(12);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
    n6.next = n7;
    n7.next = n8;
    n8.next = n9;
    n9.next = n10;
    return n1;
  }
}
