package org.gucardev.model;

/** The enum File type. */
public enum FileType {
  TXT("txt");

  String extension;

  FileType(String extension) {
    this.extension = extension;
  }

  /**
   * From string file type.
   *
   * @param text the text
   * @return the file type
   */
  public static FileType fromString(String text) {
    for (FileType fileType : FileType.values()) {
      if (fileType.extension.equalsIgnoreCase(text)) {
        return fileType;
      }
    }
    return null;
  }

  /**
   * Contains boolean.
   *
   * @param label the label
   * @return the boolean
   */
  public static boolean contains(String label) {
    for (FileType c : FileType.values()) {
      if (c.extension.equals(label)) {
        return true;
      }
    }
    return false;
  }
}
