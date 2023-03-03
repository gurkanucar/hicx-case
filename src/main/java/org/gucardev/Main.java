package org.gucardev;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.gucardev.util.FileWatcher;
import org.gucardev.util.TextFileReader;

public class Main {

  public static void main(String[] args) {
    Path path = Paths.get(
        "D:\\SoftwareProjects\\hicx-case\\src\\main\\resources\\watch_this_directory");
    try {

      String filePath = Path.of(String.valueOf(path), "asd.txt").toString();
      String fileContents = TextFileReader.read(filePath);
      System.out.println(fileContents);

      Thread thread = new Thread(new FileWatcher(path));
      thread.start();
    } catch (Exception e) {
      System.out.println("Error creating file watcher: " + e.getMessage());
    }
  }
}
