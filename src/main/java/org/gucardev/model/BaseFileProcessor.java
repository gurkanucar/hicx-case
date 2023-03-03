package org.gucardev.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public abstract class BaseFileProcessor implements Serializable {

  private Statistic statistic = new Statistic();

  private LocalDateTime created;

  private String path;
  private String fileName;
  private String extension;

  public abstract void calculateNumberOfWords();

  public abstract void calculateNumberOfDots();

  public abstract void calculateMostUsedWord();
}
