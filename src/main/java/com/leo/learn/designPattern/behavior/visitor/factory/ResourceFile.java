package com.leo.learn.designPattern.behavior.visitor.factory;

public abstract class ResourceFile {

  protected String filePath;

  public ResourceFile(String filePath) {
    this.filePath = filePath;
  }

}
