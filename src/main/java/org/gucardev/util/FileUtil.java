package org.gucardev.util;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {

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

  public static String getFileCreatedDate(String path) {
    String formattedDate = "";
    try {
      Path filePath = new File(path).toPath();
      BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
      Date creationDate = new Date(attrs.creationTime().toMillis());
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      formattedDate = dateFormat.format(creationDate);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return formattedDate;
  }

  public static long getFileSize(String path) {
    File file = new File(path);
    return file.length();
  }
}
