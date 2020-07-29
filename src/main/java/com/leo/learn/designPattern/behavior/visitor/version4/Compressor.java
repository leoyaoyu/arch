package com.leo.learn.designPattern.behavior.visitor.version4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Compressor {

  private static Logger log = LoggerFactory.getLogger(Compressor.class);

  public void compress(PDFFile file) {
    log.info("compress pdf");
  }

  public void compress(PPTFile file) {
    log.info("compress ppt");
  }

  public void compress(WordFile file) {
    log.info("compress word");
  }
}
