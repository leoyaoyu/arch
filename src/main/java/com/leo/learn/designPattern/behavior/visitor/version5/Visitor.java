package com.leo.learn.designPattern.behavior.visitor.version5;

public interface Visitor {
  void visit(PDFFile file);
  void visit(PPTFile file);
  void visit(WordFile file);
}
