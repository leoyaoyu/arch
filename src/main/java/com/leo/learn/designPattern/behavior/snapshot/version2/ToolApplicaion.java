package com.leo.learn.designPattern.behavior.snapshot.version2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class ToolApplicaion {

  private static Logger log = LoggerFactory.getLogger(ToolApplicaion.class);

  public static void main(String[] args) {
    InputText inputText = new InputText();
    SnapshotHolder snapshotHolder = new SnapshotHolder();
    Scanner scanner = new Scanner(System.in);
    while(scanner.hasNext()) {
      String input = scanner.next();
      switch (input) {
        case ":list": log.info("{}", inputText.getText()); break;
        case ":undo":
          Snapshot snapshot = snapshotHolder.popSnapshot();
          inputText.restoreSnapshot(snapshot);
          break;
        default:
          snapshotHolder.pushSnapshot(inputText.createSnapshot());
          inputText.append(input);
      }
    }
  }
}
