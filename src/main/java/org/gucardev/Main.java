package org.gucardev;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.gucardev.util.FileWatcher;

public class Main {

  public static void main(String[] args) {
    Path path = Paths.get(
        "D:\\SoftwareProjects\\hicx-case\\src\\main\\resources\\watch_this_directory");
    try {
      Thread thread = new Thread(new FileWatcher(path));
      thread.start();
    } catch (Exception e) {
      System.out.println("Error creating file watcher: " + e.getMessage());
    }
  }
}
