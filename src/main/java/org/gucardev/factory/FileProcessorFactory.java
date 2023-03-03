package org.gucardev.factory;

import org.gucardev.model.BaseFileProcessor;
import org.gucardev.model.FileType;
import org.gucardev.model.TextFileProcessor;

public class FileProcessorFactory {

  private FileProcessorFactory() {}

  public static BaseFileProcessor create(FileType fileType, String path) {

    switch (fileType) {
      case TXT:
        return new TextFileProcessor(path);
      default:
        throw new IllegalArgumentException("Unknown type " + fileType);
    }
  }
}
