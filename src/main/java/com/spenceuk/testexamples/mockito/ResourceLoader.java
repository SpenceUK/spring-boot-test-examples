package com.spenceuk.testexamples.mockito;

import java.io.IOException;

/**
 * The FileClient in this class, if it was a real, would
 * load a file from disk and could be part of a larger service
 * shared across the whole application.
 *
 * We only want to concern ourselves with the methods within this
 * class so it's a candidate for mocking to avoid the test causing
 * any side effects and limiting the scope to just this method as
 * the FileClient should be covered with its own tests elsewhere.
 */
public class ResourceLoader {

  private FileClient fileClient;

  public ResourceLoader(FileClient fileClient) {
    this.fileClient = fileClient;
  }

  public String getFileContents(String fileName) throws IOException {
    File file = fileClient.readFileFromDisk(fileName);
    return file.getContents() + "\nEOF";
  }
}