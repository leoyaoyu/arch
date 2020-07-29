package com.leo.learn.designPattern.behavior.snapshot.version1;

public class InputText {

  private StringBuilder text = new StringBuilder();

  public String getText() {
    return this.text.toString();
  }

  public void append(String input) {
    this.text.append(input);
  }

  public void setText(String text) {
    this.text.replace(0, this.text.length(), text);
  }
}
