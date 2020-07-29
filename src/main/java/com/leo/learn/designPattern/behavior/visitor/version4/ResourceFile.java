package com.leo.learn.designPattern.behavior.visitor.version4;

public abstract class ResourceFile {

  protected String filePath;

  public ResourceFile(String filePath) {
    this.filePath = filePath;
  }

  public abstract void accept(Extractor extractor);
  public abstract void accept(Compressor compressor);
}
