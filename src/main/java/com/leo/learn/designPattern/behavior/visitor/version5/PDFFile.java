package com.leo.learn.designPattern.behavior.visitor.version5;

public class PDFFile extends ResourceFile {

  public PDFFile(String filePath){
    super(filePath);
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
