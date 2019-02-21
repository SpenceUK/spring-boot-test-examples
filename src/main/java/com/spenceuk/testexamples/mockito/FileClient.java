package com.spenceuk.testexamples.mockito;

import java.io.IOException;

import org.springframework.stereotype.Component;

/**
 * Component means this is a candidate for autowiring
 * by spring and being used for dependency injection.
 */
@Component
public class FileClient {

  /**
   * This operation is a fake to attempt to read from disk
   * and it throws a Java Runtime Error.
   */
  public File readFileFromDisk(String fileName) {
    throw new RuntimeException("I blow up when call me!");
  }

  /**
   * This operation is a fake for a safe operation that will attempt to
   * read a file from disk but understands this is a risky operation so
   * declared the fact it can have an IOException error, so you can handle
   * this in your code by re throwing it or captruing it in a Try -> Catch block.
   */
  public File safelyReadFileFromDisk(String fileName) throws IOException {
    throw new IOException("I tried to get the file but failed.");
  }

}
