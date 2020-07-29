package com.leo.learn.designPattern.behavior.visitor.factory;

import com.leo.learn.designPattern.behavior.visitor.factory.extractor.PDFExtractor;
import com.leo.learn.designPattern.behavior.visitor.factory.extractor.PPTExtractor;
import com.leo.learn.designPattern.behavior.visitor.factory.extractor.WordExtractor;

import java.util.HashMap;
import java.util.Map;

public class ExtractorFactory implements ActionFactory {

  private static Map<Class, Extractor> map = new HashMap<>();
  static {
    map.put(PDFFile.class, new PDFExtractor());
    map.put(PPTFile.class, new PPTExtractor());
    map.put(WordFile.class, new WordExtractor());

  }

  @Override
  public Visitor getActor(ResourceFile file) {
    return map.get(file.getClass());
  }

}
