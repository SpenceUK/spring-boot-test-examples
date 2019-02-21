package com.spenceuk.testexamples.springjunitmockito;

import com.spenceuk.testexamples.mockito.File;
import com.spenceuk.testexamples.mockito.FileClient;

import org.springframework.beans.factory.annotation.Autowired;

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
public class SpringResourceLoader {

  private FileClient fileClient;

  /**
   * This constructor has the <code>@Autowired</code> annotation
   * so the spring container will go and find a suitable candidate
   * annotated with <code>@Component or @Service or @Repository</code>
   * create an 'Spring singleton instance' which is one instance per
   * container and inject it into this constructor for you.
   */
  @Autowired
  public SpringResourceLoader(FileClient fileClient) {
    this.fileClient = fileClient;
  }

  public String getFileContents(String fileName) {
    File file = fileClient.readFileFromDisk(fileName);
    return file.getContents() + "\nEOF";
  }
}