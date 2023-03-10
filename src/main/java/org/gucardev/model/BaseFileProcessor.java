package org.gucardev.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/** The type Base file processor. */
@Data
public abstract class BaseFileProcessor implements Serializable {

  protected Statistic statistic;

  protected LocalDateTime created;

  protected String statisticResult;

  protected String path;
  protected String fileName;
  protected String extension;
  protected long size;

  BaseFileProcessor(String path) {
    this.path = path;
  }

  public abstract void processFile();

  public abstract void calculateNumberOfWords();

  public abstract void calculateNumberOfDots();

  public abstract void calculateMostUsedWord();

  public abstract void moveToProcessedFolder();
}
