package org.gucardev.model;

import java.io.Serializable;
import lombok.Data;

@Data
public abstract class BaseFileProcessor implements Serializable {

  private String path;
  private String fileName;
  private String extension;

  public abstract void calculateNumberOfWords();

  public abstract void calculateNumberOfDots();

  public abstract void calculateMostUsedWord();
}
