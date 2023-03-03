package org.gucardev.model;

import java.io.IOException;
import java.nio.file.Path;
import org.gucardev.util.FileUtil;
import org.gucardev.util.StatisticsUtil;
import org.gucardev.util.TextFileReader;

/** The type Text file processor. */
public class TextFileProcessor extends BaseFileProcessor {

  @Override
  public void processFile() {
    String fileName = this.getFileName();
    String fileExtension = this.getExtension();
    this.calculateMostUsedWord();
    this.calculateNumberOfDots();
    this.calculateNumberOfWords();
    super.statisticResult =
        String.format(
            "file: %s.%s | size: %d byte | created: %s | %s",
            fileName, fileExtension, this.getSize(), this.getCreated(), this.getStatistic());
  }

  /**
   * Instantiates a new Text file processor.
   *
   * @param path the path
   */
  public TextFileProcessor(String path) {
    super(path);
    super.statistic = new Statistic();
    super.fileName = FileUtil.getFileName(path);
    super.extension = FileUtil.getFileExtension(path);
    super.size = FileUtil.getFileSize(path);
    super.created = FileUtil.getFileCreatedDate(path);
  }

  @Override
  public void calculateNumberOfWords() {
    try {
      long numberOfWords = StatisticsUtil.calculateNumberOfWords(TextFileReader.read(this.path));
      this.getStatistic().setNumberOfWords(numberOfWords);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void calculateNumberOfDots() {
    try {
      long numberOfDots =
          StatisticsUtil.calcNumberOfSpecificChar(TextFileReader.read(this.path), '.');
      this.getStatistic().setNumberOfDots(numberOfDots);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void calculateMostUsedWord() {
    try {
      String mostUsedWord = StatisticsUtil.calculateMostUsedWord(TextFileReader.read(this.path));
      this.getStatistic().setMostUsedWord(mostUsedWord);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void moveToProcessedFolder() {
    // Move file to processed subfolder
    Path processedDir = Path.of(super.path).resolveSibling("processed");
    FileUtil.moveFile(Path.of(super.path), processedDir.resolve(Path.of(super.path).getFileName()));
  }
}
