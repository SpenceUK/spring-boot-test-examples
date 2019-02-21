package com.spenceuk.testexamples.mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class UseOfMocksTests {

  private static final String CONTENTS = "file-contents";

  @Mock private FileClient fileClientMock;
  private ResourceLoader resourceLoader;
  private File testFile;

  /**
   * Test Setup.
   */
  @Before
  public void setup() {
    /**
     * The MockitoAnnotations init mocks method initialises ('new's up) the
     * mock objects in this class file.
     */
    MockitoAnnotations.initMocks(this);

    /**
     * Pass the mock into the class under test.
     */
    resourceLoader = new ResourceLoader(fileClientMock);

    // create a test file to be used later
    testFile = new File();
    testFile.setContents(CONTENTS);
  }

  @Test
  public void getFileContentsReturnsStringWithEOFTest(){
    /**
     * Mockito.when waits for the given mock and method call to be invoked and
     * then returns the given response, in this case it has to be called with
     * the specific String "readme.txt", string equality in Java means two strings
     * with the same characters are equal, if I passed an object here it would have to
     * be called with the same Object from the same memory address.
    */
    Mockito.when(fileClientMock.readFileFromDisk("readme.txt")).thenReturn(testFile);

    String expected = CONTENTS + "\nEOF";
    String actual = resourceLoader.getFileContents("readme.txt");

    /**
     * This kind of assertion is favoured over assertTrue and assertFalse
     * as assertEquals will highlight what is different if not equal.
     * You can add a String message to add comments on the assertion/test
     * if you want to and I would do this with assertTrue/False to aid
     * debugging.
     */
    assertEquals(expected, actual);

    /**
     * This verifies that the mock was interacted with and can confirm the
     * return was triggered.
     */
    Mockito.verify(fileClientMock, Mockito.times(1)).readFileFromDisk("readme.txt");
  }

  @Test
  public void mockWithLooseArgumentsTest() {
    /**
     * This mock setup widens the argument from the specific string "readme.txt" to
     * any string. Mockito has lots of helpers like this where you can choose from
     * supplied ones or choose Mockito.any(Class<T> clazz) which you can use :
     * <code> Mockito.any(FileClient.class) </code> and the return will be triggered
     * when any object of the type FileClient are passed.
     */
    Mockito.when(fileClientMock.readFileFromDisk(Mockito.anyString())).thenReturn(testFile);

    String expected = CONTENTS + "\nEOF";
    String actual = resourceLoader.getFileContents("readme.txt");

    /**
     * assert true method, changes this and the assertEquals in the test above and see
     * difference in error failure message. try it without the added message:
     * "Expected String matches actual" you will see that the failure message is
     * less than helpful.
     */
    assertTrue("Expected String matches actual", expected.equals(actual));
    Mockito.verify(fileClientMock, Mockito.times(1)).readFileFromDisk(Mockito.anyString());
  }

}