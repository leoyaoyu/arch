package com.leo.learn.designPattern.behavior.visitor.version5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Compressor implements Visitor{

  private static Logger log = LoggerFactory.getLogger(Compressor.class);

  public void visit(PDFFile file) {
    log.info("compress pdf");
  }

  public void visit(PPTFile file) {
    log.info("compress ppt");
  }

  public void visit(WordFile file) {
    log.info("compress word");
  }

}
