package org.gucardev.factory;

import org.gucardev.model.BaseFileProcessor;
import org.gucardev.model.FileType;
import org.gucardev.model.TextFileProcessor;

/** The type File processor factory. */
public class FileProcessorFactory {

  private FileProcessorFactory() {}

  /**
   * Create base file processor.
   *
   * @param fileType the file type
   * @param path the path
   * @return the base file processor
   */
  public static BaseFileProcessor create(FileType fileType, String path) {

    switch (fileType) {
      case TXT:
        return new TextFileProcessor(path);
      default:
        throw new IllegalArgumentException("Unknown type " + fileType);
    }
  }
}
