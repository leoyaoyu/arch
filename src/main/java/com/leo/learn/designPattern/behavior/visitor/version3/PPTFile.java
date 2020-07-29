package com.leo.learn.designPattern.behavior.visitor.version3;

public class PPTFile extends ResourceFile {

  public PPTFile(String filePath){
    super(filePath);
  }

  @Override
  public void accept(Extractor extractor) {
    extractor.extract2Txt(this);
  }
}
