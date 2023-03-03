package org.gucardev;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.gucardev.factory.FileProcessorFactory;
import org.gucardev.model.FileType;
import org.gucardev.model.TextFileProcessor;
import org.gucardev.util.FileUtil;
import org.gucardev.util.FileWatcher;
import org.gucardev.util.TextFileReader;

public class Main {

  public static void main(String[] args) {
    Path path = Paths.get(
        "D:\\SoftwareProjects\\hicx-case\\src\\main\\resources\\watch_this_directory");
    try {

      TextFileProcessor textFileProcessor =
          (TextFileProcessor) FileProcessorFactory.create(FileType.TXT);

      String filePath = Path.of(String.valueOf(path), "example.txt").toString();

      String fileName = FileUtil.getFileName(filePath);
      String fileExtension = FileUtil.getFileExtension(filePath);
      String fileCreatedDate = FileUtil.getFileCreatedDate(filePath);
      long fileSize = FileUtil.getFileSize(filePath);

      System.out.printf(
          "%s %s %s - %d bytes \n\n", fileName, fileExtension, fileCreatedDate, fileSize);

      String fileContents = TextFileReader.read(filePath);
      System.out.println(fileContents);

      Thread thread = new Thread(new FileWatcher(path));
      thread.start();
    } catch (Exception e) {
      System.out.println("Error creating file watcher: " + e.getMessage());
    }
  }
}
