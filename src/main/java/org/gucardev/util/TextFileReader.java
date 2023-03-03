package org.gucardev.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {
  public static String read(String filePath) throws IOException {
    StringBuilder sb = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line = reader.readLine();
      while (line != null) {
        sb.append(line);
        sb.append(System.lineSeparator());
        line = reader.readLine();
      }
    }
    return sb.toString();
  }
}
