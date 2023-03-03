package org.gucardev.model;

public enum FileType {
  TXT("txt");

  String extension;

  FileType(String extension) {
    this.extension = extension;
  }

  public static FileType fromString(String text) {
    for (FileType fileType : FileType.values()) {
      if (fileType.extension.equalsIgnoreCase(text)) {
        return fileType;
      }
    }
    return null;
  }

  public static boolean contains(String label) {
    for (FileType c : FileType.values()) {
      if (c.extension.equals(label)) {
        return true;
      }
    }
    return false;
  }
}
