package com.leo.learn.designPattern.behavior.visitor.version1;

public abstract class ResourceFile {

  protected String filePath;

  public ResourceFile(String filePath) {
    this.filePath = filePath;
  }

  public abstract void extract2Txt();
}
