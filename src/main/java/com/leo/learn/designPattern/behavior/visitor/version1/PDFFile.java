package com.leo.learn.designPattern.behavior.visitor.version1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PDFFile extends ResourceFile {

  private static Logger log = LoggerFactory.getLogger(WordFile.class);

  public PDFFile(String filePath){
    super(filePath);
  }

  @Override
  public void extract2Txt() {
    log.info("pdf extract to txt");
  }
}
