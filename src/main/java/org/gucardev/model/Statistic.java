package org.gucardev.model;

import lombok.Data;

@Data
public class Statistic {

  private long numberOfWords;
  private long numberOfDots;
  private String mostUsedWord = "";

  @Override
  public String toString() {
    return "Statistic {"
        + "numberOfWords="
        + numberOfWords
        + ", numberOfDots="
        + numberOfDots
        + ", mostUsedWord='"
        + mostUsedWord
        + '\''
        + '}';
  }
}
