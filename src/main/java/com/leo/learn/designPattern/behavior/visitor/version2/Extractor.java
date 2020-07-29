package com.leo.learn.designPattern.behavior.visitor.version2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Extractor {

  private static Logger log = LoggerFactory.getLogger(Extractor.class);

  public void extract2Txt(PDFFile file) {
    log.info("pdf extract to txt");
  }

  public void extract2Txt(PPTFile file) {
    log.info("ppt extract to txt");
  }

  public void extract2Txt(WordFile file) {
    log.info("word extract to txt");
  }
}
