package org.gucardev.util;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class FileUtil {

  private FileUtil() {}

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

  public static String getFileExtension(String path) {
    String extension = "";
    int i = path.lastIndexOf('.');
    if (i > 0) {
      extension = path.substring(i + 1);
    }
    return extension;
  }

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

  public static long getFileSize(String path) {
    File file = new File(path);
    return file.length();
  }
}
