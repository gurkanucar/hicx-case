package org.gucardev.util;

import java.util.HashMap;
import java.util.Map;

/** The type Statistics util. */
public class StatisticsUtil {

  private StatisticsUtil() {}

  /**
   * Calc number of specific char int.
   *
   * @param text the text
   * @param c the c
   * @return the int
   */
  public static int calcNumberOfSpecificChar(String text, char c) {
    int count = 0;
    for (int i = 0; i < text.length(); i++) {
      if (text.charAt(i) == c) {
        count++;
      }
    }
    return count;
  }

  /**
   * Calculate number of words int.
   *
   * @param text the text
   * @return the int
   */
  public static int calculateNumberOfWords(String text) {
    int count = 0;
    String[] words = text.split("\\s+");
    for (String word : words) {
      if (!word.isEmpty()) {
        count++;
      }
    }
    return count;
  }

  /**
   * Calculate most used word string.
   *
   * @param text the text
   * @return the string
   */
  public static String calculateMostUsedWord(String text) {
    String mostUsedWord = null;
    int maxCount = 0;
    Map<String, Integer> wordCounts = new HashMap<>();
    String[] words = text.split("\\s+");
    for (String word : words) {
      if (!word.isEmpty()) {
        Integer count = wordCounts.get(word);
        if (count == null) {
          count = 0;
        }
        count++;
        wordCounts.put(word, count);
        if (count > maxCount) {
          mostUsedWord = word;
          maxCount = count;
        }
      }
    }
    return mostUsedWord;
  }
}
