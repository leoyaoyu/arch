package com.leo.learn.designPattern.behavior.visitor.version3;

public class PDFFile extends ResourceFile {

  public PDFFile(String filePath){
    super(filePath);
  }

  @Override
  public void accept(Extractor extractor) {
    extractor.extract2Txt(this);
  }
}
