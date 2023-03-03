package org.gucardev.util;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;

public class FileWatcher implements Runnable {

  private final WatchService watchService;
  private final Path directory;

  public FileWatcher(Path directory) throws IOException {
    this.directory = directory;
    this.watchService = FileSystems.getDefault().newWatchService();
    this.directory.register(
        watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY
        // uncomment this if you need
        // StandardWatchEventKinds.ENTRY_DELETE
        );

    // Iterate through existing files in the directory and process them
    try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
      for (Path path : stream) {
        if (Files.isRegularFile(path)) {
          // Process existing file as if it were newly created
          handleFile(path, "EXISTING");
        }
      }
    }
  }

  public void run() {
    try {
      WatchKey key;
      while ((key = watchService.take()) != null) {
        for (WatchEvent<?> event : key.pollEvents()) {
          WatchEvent.Kind<?> kind = event.kind();
          Path fileName = (Path) event.context();
          Path filePath = directory.resolve(fileName);
          if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
            handleFile(filePath, "CREATED");
          } else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
            handleFile(filePath, "MODIFIED");
          }
        }
        key.reset();
        Thread.sleep(2000);
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      System.out.println("File watcher interrupted.");
    }
  }

  private Map<Path, Long> lastModifiedTimes = new HashMap<>();

  private void handleFile(Path path, String eventType) {
    // ignore temp files
    if (path.toString().endsWith("~")) {
      return;
    }
    Long lastModifiedTime = lastModifiedTimes.get(path);
    long newModifiedTime = path.toFile().lastModified();

    if (eventType.equals("MODIFIED")) {
      if (lastModifiedTime != null && newModifiedTime == lastModifiedTime) {
        return;
      }
      System.out.println("File MODIFIED: " + path);
    } else {
      System.out.println("File " + eventType + ": " + path);
    }

    lastModifiedTimes.put(path, newModifiedTime);
  }
}
