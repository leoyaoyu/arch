package com.leo.learn.designPattern.behavior.snapshot.version2;

public class InputText {

  private StringBuilder text = new StringBuilder();

  public String getText() {
    return this.text.toString();
  }

  public void append(String input) {
    this.text.append(input);
  }

  public Snapshot createSnapshot() { return new Snapshot(text.toString()); }

  public void restoreSnapshot(Snapshot snapshot) {
    this.text.replace(0, this.text.length(), snapshot.getText());
  }
}
