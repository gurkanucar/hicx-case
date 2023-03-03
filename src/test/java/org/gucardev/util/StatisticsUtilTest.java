package org.gucardev.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StatisticsUtilTest {

  @Test
  void testCalcNumberOfSpecificChar() {
    assertEquals(5, StatisticsUtil.calcNumberOfSpecificChar("Hello.my.name.is.gurkan.", '.'));
    assertEquals(0, StatisticsUtil.calcNumberOfSpecificChar("hello world", 'x'));
    assertEquals(3, StatisticsUtil.calcNumberOfSpecificChar("this is a test", ' '));
  }

  @Test
  void testCalculateNumberOfWords() {
    assertEquals(2, StatisticsUtil.calculateNumberOfWords("hello world"));
    assertEquals(4, StatisticsUtil.calculateNumberOfWords("The quick brown fox"));
    assertEquals(1, StatisticsUtil.calculateNumberOfWords("singleword"));
  }

  @Test
  void testCalculateMostUsedWord() {
    assertEquals(
        "the", StatisticsUtil.calculateMostUsedWord("the quick brown fox jumps over the lazy dog"));
    assertEquals("foo", StatisticsUtil.calculateMostUsedWord("foo bar baz foo foo bar"));
    assertEquals("world", StatisticsUtil.calculateMostUsedWord("hello hello world world world"));
  }
}
