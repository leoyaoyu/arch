package com.leo.learn.designPattern.behavior.visitor.version2;

public abstract class ResourceFile {

  protected String filePath;

  public ResourceFile(String filePath) {
    this.filePath = filePath;
  }
}
