package org.gucardev.util;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/** The type File util. */
public class FileUtil {

  private FileUtil() {}

  /**
   * Create folder.
   *
   * @param path the path
   */
  public static void createFolder(String path) {
    try {
      File folder = new File(path);
      folder.mkdirs();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Move file.
   *
   * @param sourceFilePath the source file path
   * @param destinationFilePath the destination file path
   */
  public static void moveFile(Path sourceFilePath, Path destinationFilePath) {
    try {
      createFolder(String.valueOf(destinationFilePath));
      Files.move(sourceFilePath, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets file name.
   *
   * @param path the path
   * @return the file name
   */
  public static String getFileName(String path) {
    File file = new File(path);
    String fileName = file.getName();
    int dotIndex = fileName.lastIndexOf('.');
    if (dotIndex > 0) {
      return fileName.substring(0, dotIndex);
    } else {
      return fileName;
    }
  }

  /**
   * Gets file extension.
   *
   * @param path the path
   * @return the file extension
   */
  public static String getFileExtension(String path) {
    String extension = "";
    int i = path.lastIndexOf('.');
    if (i > 0) {
      extension = path.substring(i + 1);
    }
    return extension;
  }

  /**
   * Gets file created date.
   *
   * @param path the path
   * @return the file created date
   */
  public static LocalDateTime getFileCreatedDate(String path) {
    try {
      Path filePath = new File(path).toPath();
      BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
      return LocalDateTime.ofInstant(
          Instant.ofEpochMilli(attrs.creationTime().toMillis()), ZoneId.systemDefault());

    } catch (Exception e) {
      e.printStackTrace();
    }
    return LocalDateTime.now();
  }

  /**
   * Gets file size.
   *
   * @param path the path
   * @return the file size
   */
  public static long getFileSize(String path) {
    File file = new File(path);
    return file.length();
  }
}
