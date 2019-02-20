package com.spenceuk.testexamples.mockito;

import java.io.IOException;

public class ResourceLoader {

  private FileClient fileClient;

  public ResourceLoader(FileClient fileClient) {
    this.fileClient = fileClient;
  }

  public String getFileContents(String fileName) throws IOException {
    File file = fileClient.readFileFromDisk(fileName);
    return file.getContents();
  }
}