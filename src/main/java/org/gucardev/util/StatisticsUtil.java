package org.gucardev.util;

import java.util.HashMap;
import java.util.Map;

public class StatisticsUtil {

  private StatisticsUtil() {}

  public static int calcNumberOfSpecificChar(String text, char c) {
    int count = 0;
    for (int i = 0; i < text.length(); i++) {
      if (text.charAt(i) == c) {
        count++;
      }
    }
    return count;
  }

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
