package com.leo.learn.designPattern.behavior.visitor.factory;

import java.util.ArrayList;
import java.util.List;

public class ToolAppliaction {
  public static void main(String[] args) {
    ExtractorFactory extractorFactory = new ExtractorFactory();
    CompressorFactory compressorFactory = new CompressorFactory();
    List<ResourceFile> files = initAllFile();
    files.forEach(resourceFile -> {
      extractorFactory.getActor(resourceFile).visit(resourceFile);
      compressorFactory.getActor(resourceFile).visit(resourceFile);
    });
  }

  private static List<ResourceFile> initAllFile() {
    List<ResourceFile> list = new ArrayList<>();
    list.add(new PPTFile("a.ppt"));
    list.add(new PDFFile("b.pdf"));
    list.add(new PDFFile("c.pdf"));
    list.add(new WordFile("d.word"));
    list.add(new PPTFile("e.ppt"));
    return list;
  }
}
