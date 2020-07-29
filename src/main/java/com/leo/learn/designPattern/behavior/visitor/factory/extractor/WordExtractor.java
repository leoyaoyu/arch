package com.leo.learn.designPattern.behavior.visitor.factory.extractor;

import com.leo.learn.designPattern.behavior.visitor.factory.Extractor;
import com.leo.learn.designPattern.behavior.visitor.factory.ResourceFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WordExtractor extends Extractor {

  private static Logger log = LoggerFactory.getLogger(Extractor.class);

  @Override
  public void visit(ResourceFile file) {
    log.info("extract word to txt");
  }
}
