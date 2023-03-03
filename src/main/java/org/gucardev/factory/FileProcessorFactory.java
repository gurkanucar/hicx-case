package org.gucardev.factory;

import org.gucardev.model.BaseFileProcessor;
import org.gucardev.model.FileType;
import org.gucardev.model.TextFileProcessor;

public class FileProcessorFactory {

  public static BaseFileProcessor create(FileType fileType) {

    switch (fileType) {
      case TXT:
        return new TextFileProcessor();
      default:
        throw new IllegalArgumentException("Unknown type " + fileType);
    }
  }
}
