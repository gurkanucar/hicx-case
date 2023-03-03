package org.gucardev.model;

public enum FileType {
  TXT("txt");

  String label;

  FileType(String label) {
    this.label = label;
  }

  public static boolean contains(String test) {
    for (FileType c : FileType.values()) {
      if (c.name().equals(test)) {
        return true;
      }
    }
    return false;
  }
}
