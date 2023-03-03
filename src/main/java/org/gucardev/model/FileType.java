package org.gucardev.model;

public enum FileType {
  TXT("txt");

  String extension;

  FileType(String extension) {
    this.extension = extension;
  }

  public static boolean contains(String label) {
    for (FileType c : FileType.values()) {
      if (c.name().equals(label)) {
        return true;
      }
    }
    return false;
  }
}
