package com.spenceuk.testexamples.unit;

import lombok.extern.slf4j.Slf4j;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Slf4j
public class JunitFlowExamplesTests {

  /**
   * <code>@BeforeClass</code>
   * Runs this static method before the class executes any other methods.
   */
  @BeforeClass
  public static void beforeClass() {
    log.info("@BeforeClass static method invoked.");
  }

  /**
   * <code>@Before</code>
   * runs this method before every test method.
   */
  @Before
  public void setup() {
    log.info("@Before setup method invoked.");
  }

  /**
   * <code>@After</code>
   * runs this method after every test method.
   */
  @After
  public void teardown() {
    log.info("@After teardown method invoked.");
  }

  @Test
  public void methodOneTest() {
    log.info("methodOneTest invoked");
  }

  @Test
  public void methodTwoTest() {
    log.info("methodTwoTest invoked");
  }

  /**
   * <code>@AfterClass</code>
   * Runs this static method after the class has executed all other test methods.
   */
  @AfterClass
  public static void afterClass() {
    log.info("@AfterClass static method invoked.");
  }

}