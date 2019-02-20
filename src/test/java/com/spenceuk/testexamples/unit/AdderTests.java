package com.spenceuk.testexamples.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AdderTests {

  /**
   * The Test annotation tells JUnit that the public void method
   * to which it is attached can be run as a test case. To run
   * the method, JUnit first constructs a fresh instance of the
   * class then invokes the annotated method. Any exceptions thrown
   * by the test will be reported by JUnit as a failure. If no
   * exceptions are thrown, the test is assumed to have succeeded.
   *
   * <p>It is common to have three parts to a test:
   * <p>Arrange -> Act -> Assert
   * <p>Given -> When -> Then
   */
  @Test
  public void canAddTwoPositiveIntsTest() {
    Adder classUnderTest = new Adder();

    int result = classUnderTest.add(2, 2);

    assertEquals("Calling add() with 2 + 2 result = 4", 4, result);
  }
}