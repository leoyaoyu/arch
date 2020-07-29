package com.leo.learn.designPattern.behavior.visitor.version5;

public class PPTFile extends ResourceFile {

  public PPTFile(String filePath){
    super(filePath);
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
