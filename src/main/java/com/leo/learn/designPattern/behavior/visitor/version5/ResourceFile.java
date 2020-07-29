package com.leo.learn.designPattern.behavior.visitor.version5;

public abstract class ResourceFile {

  protected String filePath;

  public ResourceFile(String filePath) {
    this.filePath = filePath;
  }

  public abstract void accept(Visitor visitor);
}
