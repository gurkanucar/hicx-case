package org.gucardev.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Comparator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileUtilTest {
  private static final String TEST_FOLDER_PATH = "file-test-folder";
  private static final String TEST_FILE_PATH = TEST_FOLDER_PATH + "/test-file.txt";

  @BeforeAll
  static void setup() throws IOException {
    Files.createDirectory(Paths.get(TEST_FOLDER_PATH));
    Files.write(Paths.get(TEST_FILE_PATH), "test content".getBytes());
  }

  @AfterAll
  static void cleanup() throws IOException {

    Path pathToBeDeleted = Paths.get(TEST_FOLDER_PATH);
    Files.walk(pathToBeDeleted)
        .sorted(Comparator.reverseOrder())
        .map(Path::toFile)
        .forEach(File::delete);
    Files.deleteIfExists(Paths.get(TEST_FILE_PATH));
  }

  @BeforeEach
  void reset() throws IOException {
    Files.deleteIfExists(Paths.get(TEST_FILE_PATH));
    Files.write(Paths.get(TEST_FILE_PATH), "test content".getBytes());
  }

  @Test
  void testCreateFolder() {
    // Arrange
    String folderName = "test-folder-2";
    String folderPath = TEST_FOLDER_PATH + "/" + folderName;
    FileUtil.createFolder(folderPath);
    assertTrue(new File(folderPath).exists());
  }

  @Test
  void testMoveFile() throws IOException {
    String destinationFilePath = TEST_FOLDER_PATH + "/test-file-moved.txt";
    FileUtil.moveFile(Paths.get(TEST_FILE_PATH), Paths.get(destinationFilePath));
    assertTrue(Files.exists(Paths.get(destinationFilePath)));
    assertFalse(Files.exists(Paths.get(TEST_FILE_PATH)));
  }

  @Test
  void testGetFileName() {
    String fileName = "test-file.txt";
    String result = FileUtil.getFileName(TEST_FOLDER_PATH + "/" + fileName);
    assertEquals("test-file", result);
  }

  @Test
  void testGetFileExtension() {
    String fileName = "test-file.txt";
    String result = FileUtil.getFileExtension(TEST_FOLDER_PATH + "/" + fileName);
    assertEquals("txt", result);
  }

  @Test
  void testGetFileCreatedDate() {
    String fileName = "test-file.txt";
    LocalDateTime result = FileUtil.getFileCreatedDate(TEST_FOLDER_PATH + "/" + fileName);
    assertNotNull(result);
  }

  @Test
  void testGetFileSize() {
    String fileName = "test-file.txt";
    long result = FileUtil.getFileSize(TEST_FOLDER_PATH + "/" + fileName);
    assertEquals(12, result);
  }
}
