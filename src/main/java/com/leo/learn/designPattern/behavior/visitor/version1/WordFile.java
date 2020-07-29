package com.leo.learn.designPattern.behavior.visitor.version1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WordFile extends ResourceFile {

  private static Logger log = LoggerFactory.getLogger(WordFile.class);

  public WordFile(String filePath){
    super(filePath);
  }

  @Override
  public void extract2Txt() {
    log.info("word extract to txt");
  }
}
