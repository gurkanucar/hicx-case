package org.gucardev.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FileTypeTest {

  @Test
  @DisplayName("Test fromString method with valid file type string")
  void testFromStringMethodWithValidFileTypeString() {
    FileType expected = FileType.fromString("txt");
    assertEquals(expected, FileType.TXT);
  }

  @Test
  @DisplayName("Test fromString method with invalid file type string")
  void testFromStringMethodWithInvalidFileTypeString() {
    FileType expected = FileType.fromString("invalid");
    assertNull(expected);
  }

  @Test
  @DisplayName("Test contains method with valid file type extension")
  void testContainsMethodWithValidFileTypeExtension() {
    assertTrue(FileType.contains("txt"));
  }

  @Test
  @DisplayName("Test contains method with invalid file type extension")
  void testContainsMethodWithInvalidFileTypeExtension() {
    assertFalse(FileType.contains("invalid"));
  }
}
