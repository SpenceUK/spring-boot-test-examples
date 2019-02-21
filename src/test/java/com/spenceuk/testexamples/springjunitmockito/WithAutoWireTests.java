package com.spenceuk.testexamples.springjunitmockito;

import static org.junit.Assert.assertEquals;

import com.spenceuk.testexamples.mockito.FileClient;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * The <code>@RunWith(SpringRunner.class)</code> and
 * <code>@SpringBootTest</code> annotations start up the
 * Spring Boot application context and you can see the spring boot
 * application start up in the terminal when this test runs.
 *
 * <p>The Application is started up once for this test class and
 * persisted between the test methods within this class file.
 *
 * <p>As the same application context is persisted between tests
 * this means that your tests are not clean. You should be careful
 * when using this approach, you will most likely doing this becuase
 * you are relying on Spring's <code>@Autowired</code> dependency
 * injection to provide you with a component or service within the class
 * under test. e.g. a repository. You are moving away from Unit testing
 * into integration testing.
 *
 * <p>It would be a better strategy to refactor the code so you can
 * pass a mock into the class under test. Your method under test calling
 * other methods within your class under test is OK but you should be wary
 * of your unit under test calling other classes or performing any input
 * or output operations unless you're specifically testing this functionality.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WithAutoWireTests {

  /**
   * With the annotations above the class declaration
   * you get the spring application context/container and
   * you can take advantage of dependency injection and
   * inversion of control but this adds overhead to your
   * unit tests and is it needed? can you refactor to make
   * testing simpler and quicker.
   */
  @Autowired private FileClient fileClient;

  /**
   * The expected annotation decorator indicates that
   * you expect this method to throw the declared
   * Exception, use this when you want to confirm
   * this behavior in a test.
   */
  @Test(expected = RuntimeException.class)
  public void fileClientthrowsExceptionTest() {
    fileClient.readFileFromDisk("readme.txt");
  }

  /**
   * This is testing the declared Exception, I could in a different scenario
   * be using a mock and instead of returning an object when it is called, I
   * can have it throw an Exception:
   *
   * <p><code>
   * Mockito.when(mock.methodCall()).thenThrow(new Exception("msg"));
   * </code>
   *
   * <p>you can then catch the exception and then assert on it.
   */
  @Test
  public void safelyReadFileFromDisk() {
    try {
      fileClient.safelyReadFileFromDisk("readme.txt");
    } catch (IOException ex) {
      assertEquals("I tried to get the file but failed.", ex.getMessage());
    }
  }

}