package com.spenceuk.testexamples.mockito;

import java.io.IOException;

public class FileClient {
  public File readFileFromDisk(String fileName) throws IOException {
    throw new IOException("I blow up when called! you need to mock me.");
  }

}
