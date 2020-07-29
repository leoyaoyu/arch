package com.leo.learn.designPattern.behavior.visitor.factory.compressor;

import com.leo.learn.designPattern.behavior.visitor.factory.Compressor;
import com.leo.learn.designPattern.behavior.visitor.factory.Extractor;
import com.leo.learn.designPattern.behavior.visitor.factory.ResourceFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PPTCompressor extends Compressor {

  private static Logger log = LoggerFactory.getLogger(Extractor.class);

  @Override
  public void visit(ResourceFile file) {
    log.info("compress ppt");
  }
}
