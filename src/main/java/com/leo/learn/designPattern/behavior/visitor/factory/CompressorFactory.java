package com.leo.learn.designPattern.behavior.visitor.factory;

import com.leo.learn.designPattern.behavior.visitor.factory.compressor.PDFCompressor;
import com.leo.learn.designPattern.behavior.visitor.factory.compressor.PPTCompressor;
import com.leo.learn.designPattern.behavior.visitor.factory.compressor.WordCompressor;

import java.util.HashMap;
import java.util.Map;

public class CompressorFactory implements ActionFactory {

  private static Map<Class, Compressor> map = new HashMap<>();
  static {
    map.put(PDFFile.class, new PDFCompressor());
    map.put(PPTFile.class, new PPTCompressor());
    map.put(WordFile.class, new WordCompressor());

  }

  @Override
  public Visitor getActor(ResourceFile file) {
    return map.get(file.getClass());
  }

}
