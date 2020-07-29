package com.leo.learn.designPattern.behavior.visitor.version5;

public class WordFile extends ResourceFile {

  public WordFile(String filePath){
    super(filePath);
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
