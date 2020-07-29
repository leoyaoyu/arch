package com.leo.learn.designPattern.behavior.visitor.version5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Extractor implements Visitor {

  private static Logger log = LoggerFactory.getLogger(Extractor.class);

  @Override
  public void visit(PDFFile file) {
    log.info("pdf extract to txt");
  }

  @Override
  public void visit(PPTFile file) {
    log.info("ppt extract to txt");
  }

  @Override
  public void visit(WordFile file) {
    log.info("word extract to txt");
  }
}
