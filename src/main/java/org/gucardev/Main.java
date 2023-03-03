package org.gucardev;

import java.nio.file.Path;
import org.gucardev.util.FileUtil;
import org.gucardev.util.FileWatcher;

public class Main {

  public static void main(String[] args) {
    System.out.println("Application started...");
    // "D:\\SoftwareProjects\\hicx-case\\src\\main\\resources\\watch_this_directory_by_args"
    Path path = setup(args);
    try {
      Thread thread = new Thread(new FileWatcher(path));
      thread.start();
    } catch (Exception e) {
      System.out.println("Error creating file watcher: " + e.getMessage());
    }
  }

  private static Path setup(String[] args) {
    Path path;
    if (args.length == 0 || args[0].trim().isEmpty()) {
      path = Path.of(FileUtil.createDefaultFolder());

    } else {
      path = Path.of(args[0].toString());
    }
    System.out.println("given path: " + path);
    String processedFilesPath = String.valueOf(path.resolve("processed"));
    FileUtil.createFolder(processedFilesPath);
    return path;
  }
}
