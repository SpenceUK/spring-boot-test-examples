package com.spenceuk.testexamples;

import org.junit.Test;
import org.junit.runner.RunWith;
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
public class TestExamplesApplicationTests {

  @Test
  public void contextLoads() {
  }

}
