package com.leo.learn.designPattern.behavior.visitor.version4;


public class WordFile extends ResourceFile {

  public WordFile(String filePath){
    super(filePath);
  }

  @Override
  public void accept(Extractor extractor) {
    extractor.extract2Txt(this);
  }

  @Override
  public void accept(Compressor compressor) {
    compressor.compress(this);
  }
}
