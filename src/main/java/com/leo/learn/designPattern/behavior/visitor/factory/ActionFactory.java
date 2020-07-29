package com.leo.learn.designPattern.behavior.visitor.factory;

public interface ActionFactory {
  Visitor getActor(ResourceFile file);
}
